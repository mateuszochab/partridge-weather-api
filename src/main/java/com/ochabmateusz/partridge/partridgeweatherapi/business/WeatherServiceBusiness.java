package com.ochabmateusz.partridge.partridgeweatherapi.business;

import com.ochabmateusz.partridge.partridgeweatherapi.controller.WeatherController;
import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import com.ochabmateusz.partridge.partridgeweatherapi.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceBusiness implements WeatherService {


    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);


    @Override
    public CityWeather getCityByName(String cityName, String url) {
        RestTemplate restTemplate = new RestTemplate();
        CityWeather cityWeather = restTemplate.getForObject(url, CityWeather.class);
        return cityWeather;
    }
}
