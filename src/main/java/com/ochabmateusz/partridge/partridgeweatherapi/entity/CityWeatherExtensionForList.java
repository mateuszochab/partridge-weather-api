package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CityWeatherExtensionForList {
    @JsonProperty("cod")
    private String cod;
    @JsonProperty("calctime")
    private float calctime;
    @JsonProperty("cnt")
    private int cnt;
    @JsonProperty("list")
    private List<CityWeather> listOfCityWeather;







}
