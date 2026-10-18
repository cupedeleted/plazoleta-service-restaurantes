package com.pragma.powerup.plazoletaservice.infrastructure.input.rest;

import com.pragma.powerup.plazoletaservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.plazoletaservice.application.dto.RestaurantResponseDto;
import com.pragma.powerup.plazoletaservice.application.dto.RestaurantRequestDto;
import com.pragma.powerup.plazoletaservice.application.handler.RestaurantHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantRestController {

    private final RestaurantHandler restaurantHandler;

    public RestaurantRestController(RestaurantHandler restaurantHandler, IRestaurantServicePort restaurantServicePort) {
        this.restaurantHandler = restaurantHandler;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDto>> getRestaurantsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        List<RestaurantResponseDto> response = restaurantHandler.getRestaurantsPaginated(page, size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<Void> saveRestaurant(@Valid @RequestBody RestaurantRequestDto restaurantRequestDto) {
        restaurantHandler.saveRestaurant(restaurantRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}