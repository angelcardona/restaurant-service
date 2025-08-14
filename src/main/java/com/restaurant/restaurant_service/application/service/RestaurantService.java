package com.restaurant.restaurant_service.application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.restaurant.restaurant_service.application.ports.in.IRestaurantUseCases;
import com.restaurant.restaurant_service.application.ports.out.IRestaurantRepositoryPort;
import com.restaurant.restaurant_service.domain.model.Restaurant;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantService implements IRestaurantUseCases{
    private final static Logger log= Logger.getLogger(RestaurantService.class.getName());
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
        return repositoryPort.findById(id).map(existingRestaurant -> {
            existingRestaurant.setName(restaurant.getName());
            existingRestaurant.setAddress(restaurant.getAddress());
            existingRestaurant.setCuisineType(restaurant.getCuisineType());
            existingRestaurant.setOpeningHours(restaurant.getOpeningHours());
            return repositoryPort.save(existingRestaurant);
        }).orElseThrow(() -> new IllegalArgumentException("Restaurant not Found"));
    }
    public Restaurant updateCredentials(
        Long restaurantId,
        String accesToken,
        String refreshToke,
        Long expiresIn){
            log.info("Buscando Restaurante con Id" + restaurantId + " para actualizar credenciales");

            Restaurant restaurant = repositoryPort.findById(restaurantId)
                                    .orElseThrow(() -> new IllegalArgumentException("Restaurant not Found"));

            restaurant.setGoogleAccesToken(accesToken);
            restaurant.setGoogleRefreshToken(refreshToke);
            restaurant.setGoogleTokenExpiryDate(LocalDateTime.now().plusSeconds(expiresIn));
            restaurant.setGoogleBusinessProfileId("some-business-profile-id");
            restaurant.setIsGoogleConnected(true);
            
            log.info("Actualizando campos de google, guardando en la base de datos");
            return repositoryPort.save(restaurant);
        
        }


}
