package com.gmail.robertosrjr.reactiveservice.domain;

import com.gmail.robertosrjr.reactiveservice.domain.model.Fare;
import com.gmail.robertosrjr.reactiveservice.domain.model.TaxiRide;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

public class Taxi {

    public Mono<Long> calculateFare(Boolean isNightSurcharge, Long distanceInMile) {

        return Mono.just(0l);
    }
}
