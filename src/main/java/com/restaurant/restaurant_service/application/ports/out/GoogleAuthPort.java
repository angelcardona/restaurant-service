package com.restaurant.restaurant_service.application.ports.out;

import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.TokenResponseDto;

public interface GoogleAuthPort {

    TokenResponseDto exchangeCodeForTokens(String code, String redirectUri);

}
