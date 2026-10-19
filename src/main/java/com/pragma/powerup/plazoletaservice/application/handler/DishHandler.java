package com.pragma.powerup.plazoletaservice.application.handler;

import com.pragma.powerup.plazoletaservice.application.dto.DishRequestDto;
import com.pragma.powerup.plazoletaservice.application.dto.DishUpdateRequestDto;
import com.pragma.powerup.plazoletaservice.application.mapper.DishRequestMapper;
import com.pragma.powerup.plazoletaservice.domain.api.IDishServicePort;

public class DishHandler {

    private final IDishServicePort dishServicePort;

    public DishHandler(IDishServicePort dishServicePort) {
        this.dishServicePort = dishServicePort;
    }

    public void saveDish(DishRequestDto dto, Long idPropietario) {
        dishServicePort.saveDish(DishRequestMapper.toDomain(dto), idPropietario);
    }
    public void updateDish(Long id, DishUpdateRequestDto dto, Long idPropietario) {
        dishServicePort.updateDish(id, dto.getPrecio(), dto.getDescripcion(), idPropietario);
    }
    public void changeDishStatus(Long id, Boolean activo, Long idPropietario) {
        dishServicePort.changeDishStatus(id, activo, idPropietario);
    }
}