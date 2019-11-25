package com.github.gossie.ws;

import com.github.gossie.soap_ws_example.Meal;
import org.springframework.stereotype.Component;

@Component
class MealMapper {

    Meal map(MealEntity meal) {
        Meal mappedMeal = new Meal();
        mappedMeal.setName(meal.getName());
        meal.getTags().forEach(mappedMeal.getTags()::add);

        return mappedMeal;
    }

}
