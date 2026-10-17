package com.pragma.powerup.plazoletaservice.application.handler;

import com.pragma.powerup.plazoletaservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import com.pragma.powerup.plazoletaservice.infrastructure.input.rest.dto.RestaurantRequestDto;
import com.pragma.powerup.plazoletaservice.infrastructure.input.rest.mapper.RestaurantRequestMapper;

import org.springframework.stereotype.Service;

@Service
public class RestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;

    // Constructor para inicializar el atributo
    public RestaurantHandler(IRestaurantServicePort restaurantServicePort) {
        this.restaurantServicePort = restaurantServicePort;
    }

    // Método para guardar un restaurante
    public void saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = RestaurantRequestMapper.toDomain(restaurantRequestDto);
        restaurantServicePort.saveRestaurant(restaurant);
    }
}