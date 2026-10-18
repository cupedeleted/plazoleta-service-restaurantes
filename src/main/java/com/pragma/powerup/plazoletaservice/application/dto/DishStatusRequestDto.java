package com.pragma.powerup.plazoletaservice.application.dto;

public class DishStatusRequestDto {
    private Boolean activo;
    private Long idPropietarioSolicitante;
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    public Long getIdPropietarioSolicitante() {
        return idPropietarioSolicitante;
    }
    public void setIdPropietarioSolicitante(Long idPropietarioSolicitante) {
        this.idPropietarioSolicitante = idPropietarioSolicitante;
    }
    
}
