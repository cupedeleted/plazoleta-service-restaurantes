package com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.mapper;

import com.pragma.powerup.plazoletaservice.domain.model.Dish;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.entity.DishEntity;

public class DishEntityMapper {

    private DishEntityMapper() {
    }

    public static DishEntity toEntity(Dish domain) {
        if (domain == null)
            return null;
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

    public static Dish toDomain(DishEntity entity) {
        if (entity == null)
            return null;
        return new Dish(entity.getId(),
                entity.getNombre(),
                entity.getIdCategoria(),
                entity.getDescripcion(),
                entity.getPrecio(),
                entity.getIdRestaurante(),
                entity.getUrlImagen(),
                entity.getActivo());

    }
}
