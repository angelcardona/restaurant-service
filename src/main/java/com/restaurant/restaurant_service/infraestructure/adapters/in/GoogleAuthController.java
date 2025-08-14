package com.restaurant.restaurant_service.infraestructure.adapters.in;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.restaurant.restaurant_service.application.ports.in.GoogleAuthUsesCasesPort;
import com.restaurant.restaurant_service.domain.model.Restaurant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RequiredArgsConstructor
@RestController
@RequestMapping("restaurants/auth/google")
public class GoogleAuthController {

    private final GoogleAuthUsesCasesPort googleAuthUsesCasesPort;
    
    @Value("${google.client.id}")
    private String clientId;

    @Value("${google.redirect.uri}")
    private String redirectUri;

    @Value("${google.scope}")
    private String scope;

    @GetMapping
    public RedirectView initiateAuth(@RequestParam Long restaurantId){
        String authUrl="https://accounts.google.com/o/oauth2/v2/auth?" +
            "client_id=" + this.clientId +
            "&redirect_uri=" + this.redirectUri +
            "&response_type=code"+
            "&scope=" + this.scope +
            "&state=" + restaurantId;
        log.info("Iniciando la autenticación para el restaurante con ID: {}", restaurantId);
        return new RedirectView(authUrl);
    }
    
    @GetMapping("/callback")
    public RedirectView handleCallback(@RequestParam String code, @RequestParam String state){
        try {
            
            log.info("Recibido el código de autorización y el estado. Código: {}, Estado: {}", code, state);
            
           
            String[] stateParts = state.split("=");
            String restaurantId = stateParts[1];
            log.info("Restaurant ID extraído del estado: {}", restaurantId);
            
            
            Restaurant updatedRestaurant = googleAuthUsesCasesPort.handleCallback(code, System.getenv("GOOGLE_REDIRECT_URI"), restaurantId);
            
            log.info("El restaurante con ID {} se ha actualizado con las credenciales de Google.", updatedRestaurant.getId());
            
            
            return new RedirectView("http://localhost:5173/dashboard?status=success");

        } catch (Exception e) {
            
            log.error("Error al manejar el callback de Google: {}", e.getMessage());
            e.printStackTrace();
            return new RedirectView("http://localhost:5173/dashboard?status=error");
        }
    }
}
