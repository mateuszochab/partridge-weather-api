package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor @ToString@NoArgsConstructor
public class Sys {


    private int type;
    private int id;
    private float message;
    private String country;
    private int sunrise;
    private int sunset;

}
