package com.restaurant.restaurant_service.domain.model;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private Long id;
    private String name;
    private String address;
    private String cuisineType;
    private String openingHours;

    private String googleBusinessProfileId;
    private String googleAccesToken;
    private String googleRefreshToken;
    private LocalDateTime googleTokenExpiryDate;
    private Boolean isGoogleConnected;


}
