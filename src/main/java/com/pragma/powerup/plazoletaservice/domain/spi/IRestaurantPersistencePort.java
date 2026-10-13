package com.pragma.powerup.plazoletaservice.domain.spi;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;

public interface IRestaurantPersistencePort {
    void saveRestaurant(Restaurant restaurant);
    Restaurant findById(Long id);
}