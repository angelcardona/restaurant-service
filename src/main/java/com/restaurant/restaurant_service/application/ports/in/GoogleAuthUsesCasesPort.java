package com.restaurant.restaurant_service.application.ports.in;

import com.restaurant.restaurant_service.domain.model.Restaurant;

public interface GoogleAuthUsesCasesPort {

    Restaurant handleCallback(String code,String redirectUri,String restaurantId);

}
