package com.ochabmateusz.partridge.partridgeweatherapi.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor @ToString @NoArgsConstructor
public class Wind {

    private float speed;
    private int deg;
    private float gust;
}
