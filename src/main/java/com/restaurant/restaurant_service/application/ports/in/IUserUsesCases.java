package com.restaurant.restaurant_service.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.restaurant.restaurant_service.domain.model.User;

public interface IUserUsesCases {

    User createUser(User user);
    Optional<User> getById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id,User user);
    void deleteUser(Long id);

}
