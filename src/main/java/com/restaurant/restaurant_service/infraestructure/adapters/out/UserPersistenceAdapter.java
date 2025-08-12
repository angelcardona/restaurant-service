package com.restaurant.restaurant_service.infraestructure.adapters.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.restaurant.restaurant_service.application.ports.out.IUserPersistencePort;
import com.restaurant.restaurant_service.domain.model.User;
import com.restaurant.restaurant_service.infraestructure.adapters.mapper.IUserMapper;
import com.restaurant.restaurant_service.infraestructure.adapters.out.repository.IUserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements IUserPersistencePort{

    private final IUserJpaRepository repository;
    private final IUserMapper mapper;

    @Override
    public User save(User user) {
        return mapper.toDomain(repository.save(mapper.toEntity(user)));
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return mapper.toDomainList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
