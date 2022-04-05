package com.gmail.robertosrjr.reactiveservice;

import com.gmail.robertosrjr.reactiveservice.domain.Taxi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveServiceApplication.class, args);
	}

	@Bean
	public Taxi taxi(){
		return new Taxi();
	}

}
