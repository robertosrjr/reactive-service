package com.gmail.robertosrjr.reactiveservice.framework.adapter.in.handler;

import com.gmail.robertosrjr.reactiveservice.application.usecase.TaxiFareCalculatorUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TaxiHandler {

    @Autowired
    TaxiFareCalculatorUseCase taxiFareCalculator;

    public Mono<ServerResponse> calculateFare(ServerRequest request) {

        log.info("taxiHandler...");
        this.taxiFareCalculator.calculateFare(true, 0l);
        Mono<Long> response = Mono.just(0l);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, Long.class);
    }
}
