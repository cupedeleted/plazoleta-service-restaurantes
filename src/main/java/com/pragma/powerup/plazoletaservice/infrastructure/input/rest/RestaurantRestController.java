package com.pragma.powerup.plazoletaservice.infrastructure.input.rest;

import com.pragma.powerup.plazoletaservice.application.dto.RestaurantResponseDto;
import com.pragma.powerup.plazoletaservice.application.dto.RestaurantRequestDto;
import com.pragma.powerup.plazoletaservice.application.handler.RestaurantHandler;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantRestController {

    private final RestaurantHandler restaurantHandler;

    public RestaurantRestController(RestaurantHandler restaurantHandler) {
        this.restaurantHandler = restaurantHandler;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDto>> getRestaurantsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(restaurantHandler.getRestaurantsPaginated(page, size));
    }

    @PostMapping
    public ResponseEntity<Void> saveRestaurant(@Valid @RequestBody RestaurantRequestDto dto) {
        restaurantHandler.saveRestaurant(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/owner/{ownerId}")
    public ResponseEntity<Boolean> isOwner(@PathVariable Long id, @PathVariable Long ownerId) {
        return ResponseEntity.ok(restaurantHandler.isOwnerOfRestaurant(id, ownerId));
    }
}