package com.ochabmateusz.partridge.partridgeweatherapi.controller;


import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import com.ochabmateusz.partridge.partridgeweatherapi.service.ExtrasWeatherService;
import com.ochabmateusz.partridge.partridgeweatherapi.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.List;

@RestController
public class WeatherController {



    private final WeatherService weatherService;
    private final ExtrasWeatherService extrasWeatherService;

    @Autowired
    public WeatherController(WeatherService weatherService,ExtrasWeatherService extrasWeatherService) {
        this.weatherService = weatherService;
        this.extrasWeatherService=extrasWeatherService;
    }

    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);


    @GetMapping("/getCityByName/{cityName}")
    public CityWeather GetWeatherByCityName(@PathVariable("cityName") String cityName) throws MalformedURLException {



        return this.weatherService.getCityByName(cityName);
    }

    @GetMapping("/getByCityCoordinates")
    public CityWeather GetCityByCoordinates(@RequestParam String[] coordinates){



        return this.weatherService.getCityByCoordinates(coordinates);

    }


    @GetMapping("/getByCityZipCode/{zipCode}/{countryCode}")
    public CityWeather GetCityByZIPCode(@PathVariable("zipCode") String zipCode,
    @PathVariable("countryCode") String countryCode){


        return this.weatherService.getCityByZipCode(zipCode,countryCode);

    }

    @GetMapping("getCitiesInRectArea")
    public List<CityWeather> GetCitiesInRectangleArea(@RequestParam("coordinates") List<String> coordinates){

        return this.weatherService.getCitiesInRectArea(coordinates);
    }






    @GetMapping("getCitiesInCircleArea")
    public List<CityWeather> GetCitiesInCircleArea(@RequestParam("coordinates") List<String> coordinates){

        return this.weatherService.getNumberOfCitiesInCircle(coordinates);
    }


    @GetMapping("canBeIceOnRoad/{cityName}")
    public boolean CanBeIceOnRoad(@PathVariable("cityName") String cityName){

        return this.extrasWeatherService.canBeIceOnRoad(cityName);
    }
}
