package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow {

    //value in mm
    @JsonProperty("1h")
    private float lasthour=0f;


    //value in mm
    @JsonProperty("3h")
    private float lastThreeHours=0f;


}