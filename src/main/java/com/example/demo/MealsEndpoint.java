package com.example.demo;

import com.github.gossie.soap_ws_example.GetMealsRequest;
import com.github.gossie.soap_ws_example.GetMealsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Set;

@RequiredArgsConstructor
@Endpoint
public class MealsEndpoint {
    private static final String NAMESPACE_URI = "http://github.com/gossie/soap-ws-example";

    private final MealEntityRepository mealEntityRepository;
    private final MealMapper mealMapper;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMealsRequest")
    @ResponsePayload
    public GetMealsResponse getMeals(@RequestPayload GetMealsRequest request) {
        GetMealsResponse response = new GetMealsResponse();
        mealEntityRepository.findByTags(request.getTag()).stream()
                .map(mealMapper::map)
                .forEach(response.getMeal()::add);
        return response;
    }

    private boolean filter(MealEntity meal, String tag) {
        return meal.getTags().contains(tag);
    }
}
