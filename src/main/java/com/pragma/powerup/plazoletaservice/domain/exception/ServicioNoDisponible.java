package com.pragma.powerup.plazoletaservice.domain.exception;

public class ServicioNoDisponible extends RuntimeException{
    public ServicioNoDisponible(String mensaje){
        super(mensaje);
    }
}
