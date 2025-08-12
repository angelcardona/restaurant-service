package com.restaurant.restaurant_service.infraestructure.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {
    private Long id;
    private String username;
    private String email;
    private Long restaurantId;



}
