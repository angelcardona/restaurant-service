package com.restaurant.restaurant_service.infraestructure.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.restaurant_service.infraestructure.adapters.out.entity.UserEntity;

public interface IUserJpaRepository extends JpaRepository<UserEntity,Long> {

}
