package com.pragma.powerup.plazoletaservice.infrastructure.input.rest;

import com.pragma.powerup.plazoletaservice.application.dto.DishRequestDto;
import com.pragma.powerup.plazoletaservice.application.dto.DishStatusRequestDto;
import com.pragma.powerup.plazoletaservice.application.dto.DishUpdateRequestDto;
import com.pragma.powerup.plazoletaservice.application.handler.DishHandler;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dish")
public class DishRestController {

    private final DishHandler dishHandler;

    public DishRestController(DishHandler dishHandler) {
        this.dishHandler = dishHandler;
    }

    @PostMapping
    @PreAuthorize("hasRole('PROPIETARIO')")
    public ResponseEntity<Void> saveDish(@Valid @RequestBody DishRequestDto dishRequestDto) {
        dishHandler.saveDish(dishRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('PROPIETARIO')")
    public ResponseEntity<Void> updateDish(@PathVariable Long id, @Valid @RequestBody DishUpdateRequestDto dishUpdateDto) {
        dishHandler.updateDish(id, dishUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> changeDishStatus(
            @PathVariable Long id,
            @RequestBody DishStatusRequestDto dto) {

        dishHandler.changeDishStatus(id, dto.getActivo(), dto.getIdPropietarioSolicitante());
        return ResponseEntity.ok().build();
    }
}
