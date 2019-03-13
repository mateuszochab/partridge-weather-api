package com.ochabmateusz.partridge.partridgeweatherapi.service;

import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WeatherService {


    CityWeather getCityByName(String url);


    CityWeather getCityByCoordinates(float lat, float lon);


    CityWeather getCityByZipCode(String zipCode, String countryCode);

    List<CityWeather> getCitiesInRectArea(float lonLeft, float latBottom, float lonRight, float latTop, int zoom);
}
