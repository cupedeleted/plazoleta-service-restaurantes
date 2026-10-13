package com.pragma.powerup.plazoletaservice.domain.spi;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import java.util.List;

public interface IRestaurantRepositoryPort {
    Restaurant saveRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurantsPaginated(int page, int pageSize);
}