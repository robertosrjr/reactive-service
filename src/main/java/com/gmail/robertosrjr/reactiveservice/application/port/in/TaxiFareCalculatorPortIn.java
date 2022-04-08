package com.gmail.robertosrjr.reactiveservice.application.port.in;

import com.gmail.robertosrjr.reactiveservice.application.usecase.TaxiFareCalculatorUseCase;
import com.gmail.robertosrjr.reactiveservice.domain.Taxi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Ref.: https://resilience4j.readme.io/docs/getting-started-3
 *
 * */

@Slf4j
@Service
public class TaxiFareCalculatorPortIn implements TaxiFareCalculatorUseCase {

    @Autowired
    Taxi taxi;

    private final String BACKEND = "TaxiFareCalculator";

    @Override
    @CircuitBreaker(name = BACKEND, fallbackMethod = "fallbackCalculateFare")
    @RateLimiter(name = BACKEND)
    @Bulkhead(name = BACKEND)
    @Retry(name = BACKEND, fallbackMethod = "fallbackCalculateFare")
    @TimeLimiter(name = BACKEND)
    public Mono<Long> calculateFare(Boolean isNightSurcharge, Long distanceInMile) {

        log.info("calculateFare: isNightSurcharge:{}, distanceInMile:{}", isNightSurcharge, distanceInMile);
        return this.taxi.calculateFare(isNightSurcharge, distanceInMile);
    }

    public Mono<Long> fallbackCalculateFare(Boolean isNightSurcharge, Long distanceInMile) {

        log.info("calculateFare: isNightSurcharge:{}, distanceInMile:{}", isNightSurcharge, distanceInMile);
        return this.taxi.calculateFare(isNightSurcharge, distanceInMile);
    }
}
