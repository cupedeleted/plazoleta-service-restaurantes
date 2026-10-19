package com.pragma.powerup.plazoletaservice.infrastructure.input.rest;

import com.pragma.powerup.plazoletaservice.application.dto.DishRequestDto;
import com.pragma.powerup.plazoletaservice.application.dto.DishStatusRequestDto;
import com.pragma.powerup.plazoletaservice.application.dto.DishUpdateRequestDto;
import com.pragma.powerup.plazoletaservice.application.handler.DishHandler;
import com.pragma.powerup.plazoletaservice.infrastructure.configuration.security.UsuarioAutenticado;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dish")
public class DishRestController {

    private final DishHandler dishHandler;

    public DishRestController(DishHandler dishHandler) {
        this.dishHandler = dishHandler;
    }

    @PostMapping
    public ResponseEntity<Void> saveDish(@Valid @RequestBody DishRequestDto dto,
        @AuthenticationPrincipal UsuarioAutenticado usuario) {
        dishHandler.saveDish(dto, usuario.id());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDish(@PathVariable Long id, @Valid @RequestBody DishUpdateRequestDto dto,
        @AuthenticationPrincipal UsuarioAutenticado usuario) {
        dishHandler.updateDish(id, dto, usuario.id());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> changeDishStatus(@PathVariable Long id,
        @Valid @RequestBody DishStatusRequestDto dto,
        @AuthenticationPrincipal UsuarioAutenticado usuario) {
        dishHandler.changeDishStatus(id, dto.getActivo(), usuario.id());
        return ResponseEntity.ok().build();
    }
}
