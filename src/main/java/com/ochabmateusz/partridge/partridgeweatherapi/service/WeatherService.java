package com.ochabmateusz.partridge.partridgeweatherapi.service;

import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import org.springframework.stereotype.Component;

@Component
public interface WeatherService {


    CityWeather getCityByName(String cityName,String url);


}
