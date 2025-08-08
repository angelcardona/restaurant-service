package com.restaurant.restaurant_service.infraestructure.adapters.in;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurant_service.application.ports.in.IRestaurantUseCases;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.RestaurantRequestDto;
import com.restaurant.restaurant_service.infraestructure.adapters.in.dto.RestaurantResponseDto;
import com.restaurant.restaurant_service.infraestructure.adapters.mapper.RestaurantMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@CrossOrigin("*")
@RestController
@RequestMapping("restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final IRestaurantUseCases useCase;
    private final RestaurantMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> getRestaurantById(@PathVariable Long id){
        return useCase.findRestaurantById(id)
                .map(mapper::toResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<RestaurantResponseDto>> getAllResturant(){
        return ResponseEntity.ok(mapper.toResponseDtoList(useCase.findAll()));
    }
    @PostMapping()
    public ResponseEntity<RestaurantResponseDto> createRestaurant(@Valid@RequestBody RestaurantRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
               .body(mapper.toResponseDto(useCase.createRestaurant(mapper.toDomain(requestDto))));

    }
    @PutMapping("{id}")
    public ResponseEntity<RestaurantResponseDto> updateRestaurant(@PathVariable Long id, @Valid @RequestBody RestaurantRequestDto requestDto){
        return ResponseEntity.ok(
            mapper.toResponseDto(
                useCase.updateRestaurant(id, mapper.toDomain(requestDto))
            )
        );
    }
    @DeleteMapping
    public void deleteRestaurant(Long id){
        useCase.delete(id);
    }
    
    

}
