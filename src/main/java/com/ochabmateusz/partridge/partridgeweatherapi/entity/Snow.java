package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Snow {

    //value in mm
    @JsonProperty("1h")
    private float lastHour=0f;


    //value in mm
    @JsonProperty("3h")
    private float lastThreeHours=0f;


}