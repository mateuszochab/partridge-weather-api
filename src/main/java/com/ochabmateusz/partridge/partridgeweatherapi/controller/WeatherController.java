package com.ochabmateusz.partridge.partridgeweatherapi.controller;


import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import com.ochabmateusz.partridge.partridgeweatherapi.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.List;

@RestController
public class WeatherController {



    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);


    @GetMapping("/getCityByName/{cityName}")
    public CityWeather GetWeatherByCityName(@PathVariable("cityName") String cityName) throws MalformedURLException {



        return this.weatherService.getCityByName(cityName);
    }

    @GetMapping("/getByCityCoordinates/{lat}/{lon}")
    public CityWeather GetCityByCoordinates(@PathVariable("lat") float lat, @PathVariable("lon") float lon){

        return this.weatherService.getCityByCoordinates(lat,lon);

    }


    @GetMapping("/getByCityZipCode/{zipCode}/{countryCode}")
    public CityWeather GetCityByZIPCode(@PathVariable("zipCode") String zipCode,
    @PathVariable("countryCode") String countryCode){


        return this.weatherService.getCityByZipCode(zipCode,countryCode);

    }

    @GetMapping("getCitiesInRectArea/{lonLeft}/{latBottom}/{lonRight}/{latTop}/{zoom}")
    public List<CityWeather> GetCitiesInRectangleArea(@PathVariable("lonLeft") float lonLeft,
                                                      @PathVariable("latBottom") float latBottom,
                                                      @PathVariable("lonRight") float lonRight,
                                                      @PathVariable("latTop") float latTop,
                                                      @PathVariable("zoom") int zoom){

        return this.weatherService.getCitiesInRectArea(lonLeft,latBottom,lonRight,latTop,zoom);
    }




//
//
//    public List<CityWeather> GetCitiesInCircleArea(){
//
//
//
//    }
}
