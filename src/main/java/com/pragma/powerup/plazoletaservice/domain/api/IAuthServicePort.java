package com.pragma.powerup.plazoletaservice.domain.api;

import com.pragma.powerup.plazoletaservice.application.dto.AuthResponseDto;

public interface IAuthServicePort {
    AuthResponseDto login(String correo, String clave);
}