package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {

    @JsonProperty("lon")
    private float lon;
    @JsonProperty("lat")
    private float lat;


    //version for list request because there is a "typo" in providers api
    @JsonProperty("Lon")
    private float lonforlist;
    @JsonProperty("Lat")
    private float latforlist;



}
