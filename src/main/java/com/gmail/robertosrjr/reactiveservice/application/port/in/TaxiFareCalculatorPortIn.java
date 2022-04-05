package com.gmail.robertosrjr.reactiveservice.application.port.in;

import com.gmail.robertosrjr.reactiveservice.application.usecase.TaxiFareCalculatorUseCase;
import com.gmail.robertosrjr.reactiveservice.domain.Taxi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TaxiFareCalculatorPortIn implements TaxiFareCalculatorUseCase {

    @Autowired
    Taxi taxi;

    @Override
    public Mono<Long> calculateFare(Boolean isNightSurcharge, Long distanceInMile) {

        log.info("calculateFare: isNightSurcharge:{}, distanceInMile:{}", isNightSurcharge, distanceInMile);
        return this.taxi.calculateFare(isNightSurcharge, distanceInMile);
    }
}
