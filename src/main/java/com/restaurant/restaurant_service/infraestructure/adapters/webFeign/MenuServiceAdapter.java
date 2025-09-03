package com.restaurant.restaurant_service.infraestructure.adapters.webFeign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.restaurant.restaurant_service.application.ports.out.MenuServicePort;
import com.restaurant.restaurant_service.domain.model.Menu;
@FeignClient(name="menu-client",url="http://localhost:8081/menus")
public class MenuServiceAdapter implements MenuServicePort{

    @Override
    @GetMapping("/restaurant/{restaurantId}")
    public Optional<Menu> findMenuByRestaurantId(Long restaurantId) {
        Lis
        
    }

}
