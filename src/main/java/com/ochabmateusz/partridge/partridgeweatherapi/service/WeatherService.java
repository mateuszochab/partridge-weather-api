package com.ochabmateusz.partridge.partridgeweatherapi.service;

import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WeatherService {


    CityWeather getCityByName(String url);


    CityWeather getCityByCoordinates(String... coordinates);


    CityWeather getCityByZipCode(String zipCode, String countryCode);

    List<CityWeather> getCitiesInRectArea(List<String> coordinates);

    List<CityWeather> getNumberOfCitiesInCircle(List<String> coordinates);
}
