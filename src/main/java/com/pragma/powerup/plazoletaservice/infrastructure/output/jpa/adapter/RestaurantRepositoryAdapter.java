package com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.adapter;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import com.pragma.powerup.plazoletaservice.domain.spi.IRestaurantRepositoryPort;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.entity.RestaurantEntity;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.mapper.RestaurantEntityMapper;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.repository.IRestaurantRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class RestaurantRepositoryAdapter implements IRestaurantRepositoryPort {

    private final IRestaurantRepository restaurantRepository;

    public RestaurantRepositoryAdapter(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        RestaurantEntity saved = restaurantRepository.save(RestaurantEntityMapper.toEntity(restaurant));
        return RestaurantEntityMapper.toDomain(saved);
    }

    @Override
    public List<Restaurant> getRestaurantsPaginated(int page, int pageSize) {
        return restaurantRepository.findAll(PageRequest.of(page, pageSize, Sort.by("nombre").ascending()))
                .map(RestaurantEntityMapper::toDomain)
                .getContent();
    }
}
