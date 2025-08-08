package com.restaurant.restaurant_service.infraestructure.adapters.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.restaurant.restaurant_service.application.ports.out.IRestaurantRepositoryPort;
import com.restaurant.restaurant_service.domain.model.Restaurant;
import com.restaurant.restaurant_service.infraestructure.adapters.mapper.RestaurantMapper;

import com.restaurant.restaurant_service.infraestructure.adapters.out.repository.IRestaurantJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RestaurantPersistenceAdapter implements IRestaurantRepositoryPort{

    private final IRestaurantJpaRepository repository;
    private final RestaurantMapper mapper;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return mapper.toDomain(repository.save(mapper.toEntity(restaurant)));
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
                
    }

    @Override
    public List<Restaurant> findAll() {
        return mapper.toDomainList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
