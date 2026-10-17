package com.pragma.powerup.plazoletaservice.infrastructure.input.rest.dto;

public class DishUpdateRequestDto {
    private Integer precio;
    private String descripcion;

    public DishUpdateRequestDto() {}

    public Integer getPrecio() { return precio; }
    public void setPrecio(Integer precio) { this.precio = precio; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}