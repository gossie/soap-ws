package com.github.gossie.ws;

import com.github.gossie.ws.wsdl.GetMealsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

}
