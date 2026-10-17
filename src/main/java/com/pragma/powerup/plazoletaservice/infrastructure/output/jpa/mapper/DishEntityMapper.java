package com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.mapper;

import com.pragma.powerup.plazoletaservice.domain.model.Dish;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.entity.DishEntity;

public class DishEntityMapper {

    private DishEntityMapper() {}

    public static DishEntity toEntity(Dish domain) {
        if (domain == null) return null;
        DishEntity entity = new DishEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setIdCategoria(domain.getIdCategoria());
        entity.setDescripcion(domain.getDescripcion());
        entity.setPrecio(domain.getPrecio());
        entity.setIdRestaurante(domain.getIdRestaurante());
        entity.setUrlImagen(domain.getUrlImagen());
        entity.setActivo(domain.getActivo());
        return entity;
    }
}