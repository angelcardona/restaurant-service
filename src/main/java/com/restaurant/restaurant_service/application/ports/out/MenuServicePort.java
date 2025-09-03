package com.restaurant.restaurant_service.application.ports.out;

import java.util.Optional;

import com.restaurant.restaurant_service.domain.model.Menu;

public interface MenuServicePort {

    Optional<Menu> findMenuByRestaurantId(Long restaurantId);

}
