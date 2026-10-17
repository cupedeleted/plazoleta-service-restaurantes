package com.pragma.powerup.plazoletaservice.application.handler;

import com.pragma.powerup.plazoletaservice.application.dto.AuthRequestDto;
import com.pragma.powerup.plazoletaservice.application.dto.AuthResponseDto;
import com.pragma.powerup.plazoletaservice.domain.api.IAuthServicePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthHandler {

    private final IAuthServicePort authServicePort;

    public AuthHandler(IAuthServicePort authServicePort) {
        this.authServicePort = authServicePort;
    }

    public AuthResponseDto login(AuthRequestDto authRequestDto) {
        return authServicePort.login(authRequestDto.getCorreo(), authRequestDto.getClave());
    }
}