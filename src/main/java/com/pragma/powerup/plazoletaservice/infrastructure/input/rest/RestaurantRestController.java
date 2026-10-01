package com.pragma.powerup.plazoletaservice.infrastructure.input.rest;

import com.pragma.powerup.plazoletaservice.application.dto.RestaurantRequestDto;
import com.pragma.powerup.plazoletaservice.application.handler.RestaurantHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantRestController {

    private final RestaurantHandler restaurantHandler;

    public RestaurantRestController(RestaurantHandler restaurantHandler) {
        this.restaurantHandler = restaurantHandler;
    }

    @PostMapping
    public ResponseEntity<Void> saveRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        restaurantHandler.saveRestaurant(restaurantRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}