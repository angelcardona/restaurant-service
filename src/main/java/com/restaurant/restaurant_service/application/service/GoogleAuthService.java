package com.restaurant.restaurant_service.application.service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.restaurant.restaurant_service.application.ports.in.GoogleAuthUsesCasesPort;
import com.restaurant.restaurant_service.application.ports.out.GoogleAuthPort;

import com.restaurant.restaurant_service.domain.model.Restaurant;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.TokenResponseDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class GoogleAuthService implements GoogleAuthUsesCasesPort {

    private final GoogleAuthPort googleAuthPort;
    private final RestaurantService restaurantService;
    private final Logger log= Logger.getLogger(GoogleAuthService.class.getName());

    @Override
    public Restaurant handleCallback(String code, String redirectUri, String restaurantId) {
       
        try {
            log.info("Iniciando flujo de callback de google para restaurant Id"+ restaurantId);
            TokenResponseDto tokenResponseDto= googleAuthPort.exchangeCodeForTokens(code, redirectUri);

            Restaurant updateRestaurant= restaurantService.updateCredentials(
                Long.valueOf(restaurantId),
                tokenResponseDto.getAccessToken(),
                tokenResponseDto.getRefreshToken(),
                tokenResponseDto.getExpiresIn().longValue()
            );
            log.info("Restaurant con id" + updateRestaurant.getId() + "actualizado con exito");
            log.info("Estado de conexion de Google"+ updateRestaurant.getIsGoogleConnected());
            return updateRestaurant;

        } catch (Exception e) {
            log.severe("Error en el flujo de callback de google Rollback de la transaccion");
            log.severe("causa del error" + e.getMessage());
            throw new RuntimeException("Error durante el callback de google", e);
            
        }
    }
}