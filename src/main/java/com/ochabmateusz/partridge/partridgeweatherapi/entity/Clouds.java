package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor @ToString @NoArgsConstructor
public class Clouds {


    //includes cloudiness in Percents
    @JsonProperty("all")
    private int cloudinessInPercents;


}
