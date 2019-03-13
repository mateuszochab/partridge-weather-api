package com.ochabmateusz.partridge.partridgeweatherapi.controller;


import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import com.ochabmateusz.partridge.partridgeweatherapi.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
public class WeatherController {


    @Value("${weather.APPID}")
    private String API_ID;
    @Value("${weather.BASEURL}")
    private String baseUrl;
    @Value("${weather.VERSION}")
    private String version;

    @Value("${weather.UNITS}")
    private String units;

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);


    @GetMapping("/getByCityName/{cityName}")
    public CityWeather GetWeatherByCityName(@PathVariable("cityName") String cityName) throws MalformedURLException {


        String url = baseUrl + version + "/weather?q=" + cityName + "&units=" + units + "&appid=" + API_ID;
        log.info(url);
        return this.weatherService.getCityByName(cityName, url);
    }
//
//
//    public CityWeather GetCityByCoordinates(float lat, float lon){
//
//
//
//    }
//
//
//
//    public CityWeather GetCityByZIPCode(int zipCode){
//
//
//
//
//    }
//
//    public List<CityWeather> GetCitiesInRectangleArea(){
//
//
//
//    }
//
//
//    public List<CityWeather> GetCitiesInCircleArea(){
//
//
//
//    }
}
