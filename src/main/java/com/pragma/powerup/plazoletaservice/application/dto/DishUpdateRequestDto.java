package com.pragma.powerup.plazoletaservice.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DishUpdateRequestDto {
    @NotNull @Positive private Integer precio;
    @NotBlank private String descripcion;

    public DishUpdateRequestDto() {}

    public Integer getPrecio() { return precio; }
    public void setPrecio(Integer precio) { this.precio = precio; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}