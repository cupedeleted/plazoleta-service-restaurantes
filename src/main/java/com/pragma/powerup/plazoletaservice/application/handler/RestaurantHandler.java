package com.pragma.powerup.plazoletaservice.application.handler;

import com.pragma.powerup.plazoletaservice.application.dto.RestaurantRequestDto;
import com.pragma.powerup.plazoletaservice.application.dto.RestaurantResponseDto;
import com.pragma.powerup.plazoletaservice.application.mapper.RestaurantRequestMapper;
import com.pragma.powerup.plazoletaservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;

import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<RestaurantResponseDto> getRestaurantsPaginated(int page, int size) {
        return restaurantServicePort.getRestaurantsPaginated(page, size)
                .stream()
                .map(RestaurantRequestMapper::toResponseDto)
                .toList();
    }
}