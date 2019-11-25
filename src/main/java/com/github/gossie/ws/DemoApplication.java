package com.github.gossie.ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataCreator(MealEntityRepository repository) {
		return args -> {
			repository.save(new MealEntity(null, "Chili con carne", Set.of("scharf", "mexikanisch")));
			repository.save(new MealEntity(null, "Chili sin carne", Set.of("scharf", "mexikanisch", "vegetarisch", "vegan")));
			repository.save(new MealEntity(null, "Pizza Margarita", Set.of("italienisch", "vegetarisch")));
		};
	}
}
