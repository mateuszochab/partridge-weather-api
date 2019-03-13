package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CityWeather {

    //coordinates
    @JsonProperty("coord")
    private Coordinates coordinates;
    //weather
    @JsonProperty("weather")
    private List<Weather> weather;

    //Internal parameters of API provider
    @JsonProperty("base")
    private String base;

    //general informations about conditions
    @JsonProperty("main")
    private Mainclass main;

    //visibility in percents
    @JsonProperty("visibility")
    private int visibility;

    //info about wind
    @JsonProperty("wind")
    private Wind wind;

    //infos about rain
    @JsonProperty("rain")
    private Rain rain;

    @JsonProperty("snow")
    private Snow snow;
    //cloudines in meters
    @JsonProperty("clouds")
    private Clouds clouds;

    //internal parameters of API provider
    @JsonProperty("sys")
    private Sys sys;

    //city ID
    @JsonProperty("id")
    private int id;

    //City name
    @JsonProperty("name")
    private String name;

    //internal parameter
    @JsonProperty("cod")
    private int cod;



}
