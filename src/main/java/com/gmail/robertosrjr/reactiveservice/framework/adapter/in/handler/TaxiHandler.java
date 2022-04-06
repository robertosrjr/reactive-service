package com.gmail.robertosrjr.reactiveservice.framework.adapter.in.handler;

import com.gmail.robertosrjr.reactiveservice.application.usecase.TaxiFareCalculatorUseCase;
import com.gmail.robertosrjr.reactiveservice.application.usecase.TaxiManageUseCase;
import com.gmail.robertosrjr.reactiveservice.domain.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Component
public class TaxiHandler {

    @Autowired
    TaxiFareCalculatorUseCase taxiFareCalculator;

    @Autowired
    TaxiManageUseCase taxiManageUseCase;

    public Mono<ServerResponse> calculateFare(ServerRequest request) {

        Optional<String> isNightSurcharge = request.queryParam("isNightSurcharge");
        Optional<String> distanceInMile = request.queryParam("distanceInMile");

        log.info("calculateFare...");
        this.taxiFareCalculator.calculateFare(
                Boolean.valueOf(isNightSurcharge.get()),
                Long.valueOf(distanceInMile.get()));
        Mono<Long> response = Mono.just(0l);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, Long.class);
    }

    public Mono<ServerResponse> findByPlate(ServerRequest request) {

        String plate = request.pathVariable("plate");
        log.info("findByPlate: {}", plate);
        Mono<Vehicle> response =  this.taxiManageUseCase.getVehicle(plate);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, Vehicle.class);
    }
}
