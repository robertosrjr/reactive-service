package com.gmail.robertosrjr.reactiveservice.application.port.in;

import com.gmail.robertosrjr.reactiveservice.application.usecase.TaxiManageUseCase;
import com.gmail.robertosrjr.reactiveservice.domain.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TaxiManagePortIn implements TaxiManageUseCase {

    @Override
    @Cacheable(value = "vehicle", key = "#plate")
    public Mono<Vehicle> getVehicle(String plate) {
        return Mono.just(new Vehicle(plate));
    }

    @Override
    @CacheEvict(value = "vehicle", allEntries = true)
    public Mono<Vehicle> saveVehicle(Vehicle vehicle) {
        return Mono.just(vehicle);
    }
}
