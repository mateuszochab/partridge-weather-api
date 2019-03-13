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



}
