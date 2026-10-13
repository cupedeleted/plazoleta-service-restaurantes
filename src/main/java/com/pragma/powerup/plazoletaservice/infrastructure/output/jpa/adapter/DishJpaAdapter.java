package com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.adapter;

import com.pragma.powerup.plazoletaservice.domain.model.Dish;
import com.pragma.powerup.plazoletaservice.domain.spi.IDishPersistencePort;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.entity.DishEntity;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.mapper.DishEntityMapper;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.repository.IDishRepository;

public class DishJpaAdapter implements IDishPersistencePort {

    private final IDishRepository dishRepository;

    public DishJpaAdapter(IDishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public void saveDish(Dish dish) {
        DishEntity entity = DishEntityMapper.toEntity(dish);
        dishRepository.save(entity);
    }
}