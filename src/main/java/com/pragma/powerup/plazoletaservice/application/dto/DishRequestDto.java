package com.pragma.powerup.plazoletaservice.application.dto;

public class DishRequestDto {
    @NotBlank private String nombre;
    @NotNull  private Long idCategoria;
    @NotBlank private String descripcin;
    @NotNull  @Positive private Integer precio;
    @NotNull private Long idRestaurante;
    @NotBlank private String urlImagen;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Long getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Long idCategoria) { this.idCategoria = idCategoria; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Integer getPrecio() { return precio; }
    public void setPrecio(Integer precio) { this.precio = precio; }
    public Long getIdRestaurante() { return idRestaurante; }
    public void setIdRestaurante(Long idRestaurante) { this.idRestaurante = idRestaurante; }
    public String getUrlImagen() { return urlImagen; }
    public void setUrlImagen(String urlImagen) { this.urlImagen = urlImagen; }
    public Long getIdPropietario() { return idPropietario; }
    public void setIdPropietario(Long idPropietario) { this.idPropietario = idPropietario; }
}