package com.restaurant.restaurant_service.infraestructure.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRequest {
    
    private String username;
    private String password;
    private String email;
    private Long restaurantId;

    

}
