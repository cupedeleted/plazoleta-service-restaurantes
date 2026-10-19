package com.pragma.powerup.plazoletaservice.domain.exception;

public class AccesoNoPermitido extends RuntimeException {
    public AccesoNoPermitido(String mensaje) {
        super(mensaje);
    }
}