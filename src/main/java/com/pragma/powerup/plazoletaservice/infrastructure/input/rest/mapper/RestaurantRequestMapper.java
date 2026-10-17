package com.pragma.powerup.plazoletaservice.infrastructure.input.rest.mapper;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import com.pragma.powerup.plazoletaservice.infrastructure.input.rest.dto.RestaurantRequestDto;

public class RestaurantRequestMapper {

    private RestaurantRequestMapper() {}

    // Método para convertir un DTO a un dominio
    public static Restaurant toDomain(RestaurantRequestDto dto) {
        if (dto == null) return null;
        Restaurant restaurant = new Restaurant();
        restaurant.setNombre(dto.getNombre());
        restaurant.setNit(dto.getNit());
        restaurant.setDireccion(dto.getDireccion());
        restaurant.setTelefono(dto.getTelefono());
        restaurant.setUrlLogo(dto.getUrlLogo());
        restaurant.setIdPropietario(dto.getIdPropietario());
        return restaurant;
    }
}