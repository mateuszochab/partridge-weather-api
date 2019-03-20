package com.ochabmateusz.partridge.partridgeweatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class PartridgeWeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartridgeWeatherApiApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}


//TODO add unit and integration tests
//TODO add caching management
//TODO add controller and service for historical information (probably new microservice for that)
//TODO BUG-doesnt clear cache