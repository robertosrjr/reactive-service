package com.gmail.robertosrjr.reactiveservice.application.usecase;

import com.gmail.robertosrjr.reactiveservice.domain.model.Vehicle;
import reactor.core.publisher.Mono;

public interface TaxiManageUseCase {

    Mono<Vehicle> getVehicle(String plate);
    Mono<Vehicle> saveVehicle(Vehicle vehicle);
}
