package com.pragma.powerup.plazoletaservice.application.handler;

import com.pragma.powerup.plazoletaservice.application.dto.DishRequestDto;
import com.pragma.powerup.plazoletaservice.application.dto.DishUpdateRequestDto;
import com.pragma.powerup.plazoletaservice.application.mapper.DishRequestMapper;
import com.pragma.powerup.plazoletaservice.domain.api.IDishServicePort;
import com.pragma.powerup.plazoletaservice.domain.model.Dish;

import org.springframework.stereotype.Service;

@Service
public class DishHandler {

    private final IDishServicePort dishServicePort;

    public DishHandler(IDishServicePort dishServicePort) {
        this.dishServicePort = dishServicePort;
    }

    public void saveDish(DishRequestDto dishRequestDto) {
        Dish dish = DishRequestMapper.toDomain(dishRequestDto);
        dishServicePort.saveDish(dish, dishRequestDto.getIdPropietario());
    }

    public void updateDish(Long id, DishUpdateRequestDto dto) {
        dishServicePort.updateDish(id, dto.getPrecio(), dto.getDescripcion());
    }
    public void changeDishStatus(Long id, Boolean activo, Long idPropietarioSolicitante){
        dishServicePort.changeDishStatus(id, activo, idPropietarioSolicitante);
}
}