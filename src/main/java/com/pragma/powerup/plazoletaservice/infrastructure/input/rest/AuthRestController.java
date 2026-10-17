package com.pragma.powerup.plazoletaservice.infrastructure.input.rest;

import com.pragma.powerup.plazoletaservice.application.dto.AuthRequestDto;
import com.pragma.powerup.plazoletaservice.application.dto.AuthResponseDto;
import com.pragma.powerup.plazoletaservice.application.handler.AuthHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestController {

    private final AuthHandler authHandler;

    public AuthRestController(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody AuthRequestDto authRequestDto) {
        AuthResponseDto responseDto = authHandler.login(authRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}