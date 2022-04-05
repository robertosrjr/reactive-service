package com.gmail.robertosrjr.reactiveservice.application.usecase;

import com.gmail.robertosrjr.reactiveservice.domain.model.Fare;
import com.gmail.robertosrjr.reactiveservice.domain.model.TaxiRide;
import reactor.core.publisher.Mono;

public interface TaxiFareCalculatorUseCase {

    Mono<Long> calculateFare(Boolean isNightSurcharge, Long distanceInMile);
}
