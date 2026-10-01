package com.pragma.powerup.plazoletaservice.domain.api;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;

public interface IRestaurantServicePort {
    // Métodos
    void saveRestaurant(Restaurant restaurant);
}