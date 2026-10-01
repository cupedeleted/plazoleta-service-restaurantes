package com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.repository;

import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}