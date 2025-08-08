package com.restaurant.restaurant_service.infraestructure.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDto {

    private String name;
    private String address;
    private String cuisineType;
    private String opningHours;
    private String logUrl;
    private String primaryColor;
    private String fontFamily;
    private String layoutType;

}
