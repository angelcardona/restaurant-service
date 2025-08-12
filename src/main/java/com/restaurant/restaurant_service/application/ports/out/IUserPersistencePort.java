package com.restaurant.restaurant_service.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.restaurant.restaurant_service.domain.model.User;

public interface IUserPersistencePort {

    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void delete(Long id);

}
