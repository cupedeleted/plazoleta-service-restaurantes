package com.pragma.powerup.plazoletaservice.domain.api;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import java.util.List;

public interface IRestaurantServicePort {
    // Métodos
    void saveRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurantsPaginated(int page, int pageSize);
}