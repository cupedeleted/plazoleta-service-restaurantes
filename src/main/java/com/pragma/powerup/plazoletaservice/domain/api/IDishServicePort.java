package com.pragma.powerup.plazoletaservice.domain.api;

import com.pragma.powerup.plazoletaservice.domain.model.Dish;

public interface IDishServicePort {
    void saveDish(Dish dish, Long idPropietarioSolicitante);
    void  updateDish(Long id, Integer precio,String descripcion);
    void changeDishStatus(Long id, Boolean activo, Long idPropietarioSolicitante);
}