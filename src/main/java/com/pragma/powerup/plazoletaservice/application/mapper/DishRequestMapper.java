package com.pragma.powerup.plazoletaservice.application.mapper;

import com.pragma.powerup.plazoletaservice.application.dto.DishRequestDto;
import com.pragma.powerup.plazoletaservice.domain.model.Dish;

public class DishRequestMapper {

    private DishRequestMapper() {}

    public static Dish toDomain(DishRequestDto dto) {
        if (dto == null) return null;
        Dish dish = new Dish();
        dish.setNombre(dto.getNombre());
        dish.setIdCategoria(dto.getIdCategoria());
        dish.setDescripcion(dto.getDescripcion());
        dish.setPrecio(dto.getPrecio());
        dish.setIdRestaurante(dto.getIdRestaurante());
        dish.setUrlImagen(dto.getUrlImagen());
        return dish;
    }
}