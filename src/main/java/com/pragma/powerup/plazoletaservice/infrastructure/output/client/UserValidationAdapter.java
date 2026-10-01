package com.pragma.powerup.plazoletaservice.infrastructure.output.client;

import com.pragma.powerup.plazoletaservice.domain.spi.IUserValidationPort;
import org.springframework.stereotype.Component;

@Component
public class UserValidationAdapter implements IUserValidationPort {

    @Override
    public boolean isOwnerValid(Long idPropietario) {
        // En fases posteriores se reemplaza por Feign Client o RestTemplate
        return idPropietario != null && idPropietario > 0;
    }
}

// Simulación temporal para habilitar las pruebas antes de interconectar Feign Client con el microservicio de Usuarios