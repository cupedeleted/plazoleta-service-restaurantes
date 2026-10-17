package com.pragma.powerup.plazoletaservice.application.usecase;

import com.pragma.powerup.plazoletaservice.application.dto.AuthResponseDto;
import com.pragma.powerup.plazoletaservice.domain.api.IAuthServicePort;
import com.pragma.powerup.plazoletaservice.domain.spi.ITokenServicePort; // O el puerto correspondiente para autenticar

public class AuthUseCase implements IAuthServicePort {

    private final ITokenServicePort tokenServicePort; // O el adaptador de seguridad/usuario

    public AuthUseCase(ITokenServicePort tokenServicePort) {
        this.tokenServicePort = tokenServicePort;
    }

    @Override
    public AuthResponseDto login(String correo, String clave) {
        // Lógica de validación de credenciales y generación de token
        // ...
        return new AuthResponseDto("jwt-token-generado");
    }
}