package com.restaurant.restaurant_service.infraestructure.adapters.webFeign;

import org.springframework.http.MediaType;



import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.TokenResponseDto;

@FeignClient(name="google-token-client", url="https://oauth2.googleapis.com")
public interface GoogleTokenClient {

    @PostMapping(value="/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenResponseDto exchangeCodeForTokens(
        @RequestParam("code") String code,
        @RequestParam("client_id") String clientId,
        @RequestParam("client_secret") String clientSecret,
        @RequestParam("redirect_uri") String redirectUri,
        @RequestParam("grant_type") String grantType
    );
    @PostMapping(value="/token",consumes = "application/x-www-form-urlencoded")
    TokenResponseDto refreshAccessToken(
        @RequestParam("grant_type") String grantType,
        @RequestParam("refresh_token") String refreshToken,
        @RequestParam("client_id") String clientId,
        @RequestParam("client_secret") String clientSecret
    );
}
