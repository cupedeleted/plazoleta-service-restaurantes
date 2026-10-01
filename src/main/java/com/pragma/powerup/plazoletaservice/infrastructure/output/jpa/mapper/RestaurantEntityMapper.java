package com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.mapper;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.entity.RestaurantEntity;

public class RestaurantEntityMapper {

    private RestaurantEntityMapper() {}

    public static RestaurantEntity toEntity(Restaurant domain) {
        if (domain == null) return null;
        RestaurantEntity entity = new RestaurantEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setNit(domain.getNit());
        entity.setDireccion(domain.getDireccion());
        entity.setTelefono(domain.getTelefono());
        entity.setUrlLogo(domain.getUrlLogo());
        entity.setIdPropietario(domain.getIdPropietario());
        return entity;
    }
}