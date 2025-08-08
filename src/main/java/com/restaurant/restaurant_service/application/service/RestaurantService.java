package com.restaurant.restaurant_service.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restaurant.restaurant_service.application.ports.in.IRestaurantUseCases;
import com.restaurant.restaurant_service.application.ports.out.IRestaurantRepositoryPort;
import com.restaurant.restaurant_service.domain.model.Restaurant;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantService implements IRestaurantUseCases{
    private final IRestaurantRepositoryPort repositoryPort;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return repositoryPort.save(restaurant);
    }

    @Override
    public Optional<Restaurant> findRestaurantById(Long id) {
        return repositoryPort.findById(id);
    }

    @Override
    public List<Restaurant> findAll() {
        return repositoryPort.findAll();
    }

    @Override
    public void delete(Long id) {
        repositoryPort.delete(id);
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        return repositoryPort.findById(id).map(existingProduct -> {
            existingProduct.setName(restaurant.getName());
            existingProduct.setAddress(restaurant.getAddress());
            existingProduct.setCuisineType(restaurant.getCuisineType());
            existingProduct.setOpningHours(restaurant.getOpningHours());
            return repositoryPort.save(existingProduct);
        }).orElseThrow(() -> new IllegalArgumentException("Restaurant not Found"));
    }
    


}
