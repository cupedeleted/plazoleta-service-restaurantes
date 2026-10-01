package com.pragma.powerup.plazoletaservice.domain.spi;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;

public interface IRestaurantPersistencePort {
    // Métodos
    void saveRestaurant(Restaurant restaurant);
}