package com.restaurant.restaurant_service.infraestructure.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.restaurant_service.infraestructure.adapters.out.entity.RestaurantEntity;

public interface IRestaurantJpaRepository extends JpaRepository<RestaurantEntity,Long>{

}
