package com.pragma.powerup.plazoletaservice.infrastructure.input.rest;

import com.pragma.powerup.plazoletaservice.application.handler.DishHandler;
import com.pragma.powerup.plazoletaservice.infrastructure.input.rest.dto.DishRequestDto;
import com.pragma.powerup.plazoletaservice.infrastructure.input.rest.dto.DishStatusRequestDto;
import com.pragma.powerup.plazoletaservice.infrastructure.input.rest.dto.DishUpdateRequestDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dish")
public class DishRestController {

    private final DishHandler dishHandler;

    public DishRestController(DishHandler dishHandler) {
        this.dishHandler = dishHandler;
    }

    @PostMapping
    public ResponseEntity<Void> saveDish(@RequestBody DishRequestDto dishRequestDto) {
        dishHandler.saveDish(dishRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDish(@PathVariable Long id,
            @RequestBody DishUpdateRequestDto dto) {
        dishHandler.updateDish(id, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> changeDishStatus(
            @PathVariable Long id,
            @RequestBody DishStatusRequestDto dto) {

        dishHandler.changeDishStatus(id, dto.getActivo(), dto.getIdPropietarioSolicitante());
        return ResponseEntity.ok().build();
    }
}
