package com.restaurant.restaurant_service.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.restaurant.restaurant_service.domain.model.Restaurant;

public interface IRestaurantUseCases {

    Restaurant createRestaurant(Restaurant restaurant);
    Optional<Restaurant> findRestaurantById(Long id);
    List<Restaurant> findAll();
    Restaurant updateRestaurant(Long id ,Restaurant restaurant);
    void delete(Long id);

}
