package com.pragma.powerup.plazoletaservice.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RestaurantRequestDto {
    // Atributos
    @NotBlank @NotNull private String nombre;
    @NotBlank @NotNull private String nit;
    @NotBlank @NotNull private String direccion;
    @NotBlank @NotNull private String telefono;
    @NotBlank @NotNull private String urlLogo;
    @NotBlank @NotNull private Long idPropietario;

    // Constructor por defecto
    public RestaurantRequestDto() {}

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getUrlLogo() { return urlLogo; }
    public void setUrlLogo(String urlLogo) { this.urlLogo = urlLogo; }
    public Long getIdPropietario() { return idPropietario; }
    public void setIdPropietario(Long idPropietario) { this.idPropietario = idPropietario; }
}