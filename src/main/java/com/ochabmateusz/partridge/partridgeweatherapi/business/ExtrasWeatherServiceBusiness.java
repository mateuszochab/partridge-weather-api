package com.ochabmateusz.partridge.partridgeweatherapi.business;

import com.ochabmateusz.partridge.partridgeweatherapi.entity.CityWeather;
import com.ochabmateusz.partridge.partridgeweatherapi.service.ExtrasWeatherService;
import com.ochabmateusz.partridge.partridgeweatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ExtrasWeatherServiceBusiness implements ExtrasWeatherService {

    private WeatherService weatherService;


    @Autowired
    public ExtrasWeatherServiceBusiness(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @Override
    public boolean canBeIceOnRoad(String cityName) {
      List<CityWeather> cityWeather= new ArrayList<>();

      cityWeather.add(this.weatherService.getCityByName(cityName));

     cityWeather.stream()
             .filter(g->g.getRain().getLasthour()>0.0||g.getRain().getLastThreeHours()>0.0)
             .filter(g->g.getMain().getTemp()<4);

cityWeather.forEach(System.out::println);

     return  cityWeather.isEmpty() ? true : false;
    }
}
