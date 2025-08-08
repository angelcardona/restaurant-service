package com.restaurant.restaurant_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private Long id;
    private String name;
    private String address;
    private String cuisineType;
    private String opningHours;
    private String logUrl;
    private String primaryColor;
    private String fontFamily;
    private String layoutType;
    

}
