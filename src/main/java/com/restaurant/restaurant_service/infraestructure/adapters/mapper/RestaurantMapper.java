package com.restaurant.restaurant_service.infraestructure.adapters.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.restaurant.restaurant_service.domain.model.Restaurant;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.RestaurantRequestDto;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.RestaurantResponseDto;
import com.restaurant.restaurant_service.infraestructure.adapters.out.entity.RestaurantEntity;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    //Entity -- Domain
    
    Restaurant toDomain(RestaurantEntity restaurantEntity);
    RestaurantEntity toEntity(Restaurant restaurant);
    List<Restaurant>toDomainList(List<RestaurantEntity> restaurantEntities);

    //Web -- Domain

    Restaurant toDomain(RestaurantRequestDto dto);
    RestaurantResponseDto toResponseDto(Restaurant restaurant);
    List<RestaurantResponseDto> toResponseDtoList(List<Restaurant> restaurants);

}
