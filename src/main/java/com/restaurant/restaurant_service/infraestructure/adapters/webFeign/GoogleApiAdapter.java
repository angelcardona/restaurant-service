package com.restaurant.restaurant_service.infraestructure.adapters.webFeign;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.logging.Logger;

import com.restaurant.restaurant_service.application.ports.out.GoogleAuthPort;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.TokenResponseDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GoogleApiAdapter implements GoogleAuthPort {

    private final static Logger log= Logger.getLogger(GoogleApiAdapter.class.getName());

    private final GoogleTokenClient googleTokenClient;
    

    @Value("${google.client.id}")
    private String clientId;

    @Value("${google.client.secret}")
    private String clientSecret;

    @Value("${google.redirect.uri}")
    private String redirectUri;

    @Override
    public TokenResponseDto exchangeCodeForTokens(String code, String requestRedirectUri) {
        
   log.info("Exchanging code for tokens with: " +
                "grant_type=authorization_code, " +
                "client_id=" + this.clientId + ", " +
                "client_secret=" + this.clientSecret + ", " +
                "redirect_uri=" + this.redirectUri + ", " +
                "code=" + code);
        
        
        return googleTokenClient.exchangeCodeForTokens(
            code, 
            this.clientId,
            this.clientSecret, 
            this.redirectUri,
            "authorization_code" 
        );
    }

    @Override
    public TokenResponseDto refreshAccessToken(String refreshToken) {
        log.info("Refresh token access with: " +
                "grant_type=refresh_token, " +
                "client_id=" + this.clientId + ", " +
                "client_secret=" + this.clientSecret + ", " +
                "refresh_token=" + refreshToken);

        return googleTokenClient.refreshAccessToken(
            "refreshToken",
            this.clientId,
            this.clientSecret,
            refreshToken
        );
    }
}
