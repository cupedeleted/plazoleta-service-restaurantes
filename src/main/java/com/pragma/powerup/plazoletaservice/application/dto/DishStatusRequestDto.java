package com.pragma.powerup.plazoletaservice.application.dto;

import jakarta.validation.constraints.NotNull;

public class DishStatusRequestDto {
    @NotNull  private Boolean activo;
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
}
