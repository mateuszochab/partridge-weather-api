package com.ochabmateusz.partridge.partridgeweatherapi.service;

import org.springframework.stereotype.Component;

@Component
public interface ExtrasWeatherService {


    boolean canBeIceOnRoad(String cityName);


}
