package com.restaurant.restaurant_service.infraestructure.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponseDto {

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
