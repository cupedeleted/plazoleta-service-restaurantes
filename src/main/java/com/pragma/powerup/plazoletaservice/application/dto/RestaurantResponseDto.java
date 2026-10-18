package com.pragma.powerup.plazoletaservice.application.dto;

public class RestaurantResponseDto {

    private String name;
    private String urlLogo;

    public RestaurantResponseDto() {
    }

    public RestaurantResponseDto(String name, String urlLogo) {
        this.name = name;
        this.urlLogo = urlLogo;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
}