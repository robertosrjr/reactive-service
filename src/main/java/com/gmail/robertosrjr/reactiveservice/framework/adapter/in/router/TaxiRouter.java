package com.gmail.robertosrjr.reactiveservice.framework.adapter.in.router;

import com.gmail.robertosrjr.reactiveservice.framework.adapter.in.handler.TaxiHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Slf4j
@Configuration
public class TaxiRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TaxiHandler handler){

        log.info("TaxiRouter...");
        return RouterFunctions
                .route(GET("/calculateFare")
                        .and(accept(MediaType.APPLICATION_JSON)), handler::calculateFare)
                .andRoute(GET("/{plate}")
                        .and(accept(MediaType.APPLICATION_JSON)), handler::findByPlate)
                ;
    }
}
