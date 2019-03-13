package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter @AllArgsConstructor @ToString @NoArgsConstructor
public class Rain {
//value in mm
   @JsonProperty("1h")
    private float lasthour=0f;


 //value in mm
   @JsonProperty("3h")
    private float lastThreeHours=0f;


}
