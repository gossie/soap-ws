package com.github.gossie.ws;

import com.github.gossie.ws.wsdl.GetMealsRequest;
import com.github.gossie.ws.wsdl.GetMealsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class MealClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(MealClient.class);

    public GetMealsResponse getMeals(String tag) {

        GetMealsRequest request = new GetMealsRequest();
        request.setTag(tag);

        log.info("Requesting meals for " + tag);

        GetMealsResponse response = (GetMealsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/meals", request,
                        new SoapActionCallback(
                                "http://github.com/gossie/soap-ws-example/GetCountryRequest"));

        return response;
    }

}
