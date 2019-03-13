package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter @AllArgsConstructor @ToString @NoArgsConstructor
public class Mainclass {

    //Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    @JsonProperty("temp")
    private float temp;
    // Atmospheric pressure hPa
    @JsonProperty("pressure")
    private int pressure;

    //humidity in percents
    @JsonProperty("humidity")
    private int humidity;


//    Minimum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises
//    geographically expanded (use these parameter optionally). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    @JsonProperty("temp_min")
    private float temp_min;


//    Maximum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises
//    geographically expanded(use these parameter optionally).Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    @JsonProperty("temp_max")
    private float temp_max;
}
