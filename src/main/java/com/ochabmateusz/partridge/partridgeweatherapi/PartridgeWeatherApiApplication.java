package com.ochabmateusz.partridge.partridgeweatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PartridgeWeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartridgeWeatherApiApplication.class, args);
	}

}
