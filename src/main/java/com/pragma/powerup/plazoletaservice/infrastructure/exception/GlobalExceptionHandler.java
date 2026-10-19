package com.pragma.powerup.plazoletaservice.infrastructure.exception;

import java.util.Map;

import com.pragma.powerup.plazoletaservice.domain.exception.AccesoNoPermitido;
import com.pragma.powerup.plazoletaservice.domain.exception.DishNotFoundException;
import com.pragma.powerup.plazoletaservice.domain.exception.ServicioNoDisponible;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DishNotFoundException.class)
    public ResponseEntity<Map<String, String>> platoNoEncontrado(DishNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> datoInvalido(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensaje", ex.getMessage()));
    }

    @ExceptionHandler(AccesoNoPermitido.class)
    public ResponseEntity<Map<String, String>> noPermitido(AccesoNoPermitido ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("mensaje", ex.getMessage()));
    }

    @ExceptionHandler(ServicioNoDisponible.class)
    public ResponseEntity<Map<String, String>> servicioNoDisponible(ServicioNoDisponible ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of("mensaje", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validacion(MethodArgumentNotValidException ex) {
        String mensaje = ex.getBindingResult().getFieldErrors().stream()
            .map(e -> e.getDefaultMessage()).findFirst().orElse("Datos inválidos");
        return ResponseEntity.badRequest().body(Map.of("mensaje", mensaje));
    }
}