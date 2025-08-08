package com.restaurant.restaurant_service.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.restaurant.restaurant_service.domain.model.Restaurant;

public interface IRestaurantRepositoryPort {

    Restaurant save(Restaurant restaurant);
    Optional<Restaurant> findById(Long id);
    List<Restaurant> findAll();
    void delete(Long id);

}
