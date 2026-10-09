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

    public static Restaurant toDomain(RestaurantEntity entity) {
        if (entity == null) return null;
        Restaurant domain = new Restaurant();
        domain.setId(entity.getId());
        domain.setNombre(entity.getNombre());
        domain.setNit(entity.getNit());
        domain.setDireccion(entity.getDireccion());
        domain.setTelefono(entity.getTelefono());
        domain.setUrlLogo(entity.getUrlLogo());
        domain.setIdPropietario(entity.getIdPropietario());
        return domain;
    }
}