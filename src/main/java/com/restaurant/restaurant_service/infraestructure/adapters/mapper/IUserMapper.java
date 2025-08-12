package com.restaurant.restaurant_service.infraestructure.adapters.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.restaurant.restaurant_service.domain.model.User;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.UserDtoRequest;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.UserDtoResponse;
import com.restaurant.restaurant_service.infraestructure.adapters.out.entity.UserEntity;

@Component
public class IUserMapper {

    public User toDomain(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());

        return user;

    }
    public UserEntity toEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());

        return userEntity;
    }
    public List<User> toDomainList(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }


    public UserDtoResponse toDtoResponse(User user){
        UserDtoResponse dto= new UserDtoResponse();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRestaurantId(user.getRestaurantId());
        return dto;
    }
    public User toDomainDto(UserDtoRequest dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setRestaurantId(dto.getRestaurantId());
        return user;
    }
    public List<UserDtoResponse> toDtoResponseList(List<User> users) {
        return users.stream()
                .map(this::toDtoResponse)
                .collect(Collectors.toList());
    }
}
