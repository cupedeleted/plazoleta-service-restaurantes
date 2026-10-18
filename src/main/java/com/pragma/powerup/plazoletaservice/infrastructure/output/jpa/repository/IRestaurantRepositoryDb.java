package com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.repository;

import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.entity.RestaurantEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRestaurantRepositoryDb extends JpaRepository<RestaurantEntity, Long> {
    //Método para obtener los restaurantes paginados
    List<RestaurantEntity> findAllByOrderByNombreAsc(Pageable pageable);
}