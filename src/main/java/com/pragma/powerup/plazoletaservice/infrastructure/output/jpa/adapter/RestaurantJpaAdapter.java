package com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.adapter;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import com.pragma.powerup.plazoletaservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.entity.RestaurantEntity;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.mapper.RestaurantEntityMapper;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.repository.IRestaurantRepository;

import java.util.Optional;

public class RestaurantJpaAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;

    public RestaurantJpaAdapter(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        RestaurantEntity entity = RestaurantEntityMapper.toEntity(restaurant);
        restaurantRepository.save(entity);
    }

    @Override
    public Restaurant findById(Long id) {
        Optional<RestaurantEntity> entityOptional = restaurantRepository.findById(id);
        return entityOptional.map(RestaurantEntityMapper::toDomain).orElse(null);
    }
}