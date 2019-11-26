package com.github.gossie.ws;

import com.github.gossie.ws.wsdl.GetMealsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class SoapClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner lookup(MealClient quoteClient) {
        return args -> {
            String tag = "vegetarisch";

            if (args.length > 0) {
                tag = args[0];
            }
            GetMealsResponse response = quoteClient.getMeals(tag);
            System.err.println(response.getMeal());
        };
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.github.gossie.ws.wsdl");
        return marshaller;
    }

    @Bean
    public MealClient countryClient(Jaxb2Marshaller marshaller) {
        MealClient client = new MealClient();
        client.setDefaultUri("https://ldwas-soap-example.herokuapp.com//ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
