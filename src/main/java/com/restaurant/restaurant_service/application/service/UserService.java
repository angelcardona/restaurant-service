package com.restaurant.restaurant_service.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restaurant.restaurant_service.application.ports.in.IUserUsesCases;
import com.restaurant.restaurant_service.application.ports.out.IUserPersistencePort;
import com.restaurant.restaurant_service.domain.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserUsesCases{
    
    private final IUserPersistencePort persistencePort;
    
    @Override
    public User createUser(User user) {
        return persistencePort.save(user);
    }

    @Override
    public Optional<User> getById(Long id) {
        return persistencePort.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return persistencePort.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User>existingUser=persistencePort.findById(id);
        if(existingUser.isPresent()){
            User updateUser=existingUser.get();
            updateUser.setUsername(user.getUsername());
            updateUser.setPassword(user.getPassword());
            updateUser.setEmail(user.getEmail());
            return persistencePort.save(updateUser);
        
        }
        else{
            throw new IllegalArgumentException("User with id"+ id + " not found");
        }
    }

    @Override
    public void deleteUser(Long id) {
        persistencePort.delete(id);
    }

}
