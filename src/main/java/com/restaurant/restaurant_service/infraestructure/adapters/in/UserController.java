package com.restaurant.restaurant_service.infraestructure.adapters.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurant_service.application.ports.in.IUserUsesCases;
import com.restaurant.restaurant_service.domain.model.User;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.UserDtoRequest;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.UserDtoResponse;
import com.restaurant.restaurant_service.infraestructure.adapters.mapper.IUserMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RequiredArgsConstructor
@RestController
@RequestMapping("user")
@CrossOrigin("*")

public class UserController {

    private final IUserUsesCases useCase;
    private final IUserMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<UserDtoResponse> createUser(@Valid @RequestBody UserDtoRequest requestDto){
        User user = mapper.toDomainDto(requestDto);
        User createdUser= useCase.createUser(user);
        UserDtoResponse responseDto = mapper.toDtoResponse(createdUser);
        return ResponseEntity.ok(responseDto);

    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDtoResponse> getUserById(@PathVariable Long userId){
        return useCase.getById(userId)
                        .map(mapper::toDtoResponse)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUsers(){
        List<User> users = useCase.getAllUsers();
        List<UserDtoResponse> responses= mapper.toDtoResponseList(users);
        return ResponseEntity.ok(responses);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDtoResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserDtoRequest requestDto){
        User user = mapper.toDomainDto(requestDto);
        User updatedUser = useCase.updateUser(id, user);
        UserDtoResponse responseDto = mapper.toDtoResponse(updatedUser);
        return ResponseEntity.ok(responseDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        useCase.deleteUser(id);
        return ResponseEntity.noContent().build();
    }




}
