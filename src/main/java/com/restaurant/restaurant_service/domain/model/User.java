package com.restaurant.restaurant_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Long restaurantId;

    public void addRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

}
