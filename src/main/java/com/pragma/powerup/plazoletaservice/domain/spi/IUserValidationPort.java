package com.pragma.powerup.plazoletaservice.domain.spi;

public interface IUserValidationPort {
    // Métodos
    boolean isOwnerValid(Long idPropietario);
}