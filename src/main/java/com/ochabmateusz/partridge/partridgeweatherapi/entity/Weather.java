package com.ochabmateusz.partridge.partridgeweatherapi.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor @ToString @NoArgsConstructor
public class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;


}
