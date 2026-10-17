package com.pragma.powerup.plazoletaservice.domain.model;

public class Dish {
    private Long id;
    private String nombre;
    private Long idCategoria;
    private String descripcion;
    private Integer precio;
    private Long idRestaurante;
    private String urlImagen;
    private Boolean activo;

    public Dish() {}

    public Dish(Long id, String nombre, Long idCategoria, String descripcion, Integer precio, Long idRestaurante, String urlImagen, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idRestaurante = idRestaurante;
        this.urlImagen = urlImagen;
        this.activo = activo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}