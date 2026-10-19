package com.pragma.powerup.plazoletaservice.infrastructure.output.client;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import com.pragma.powerup.plazoletaservice.domain.exception.ServicioNoDisponible;
import com.pragma.powerup.plazoletaservice.domain.spi.IUserValidationPort;
import com.pragma.powerup.plazoletaservice.infrastructure.configuration.security.TokenContext;

public class UsuariosHttpAdapter implements IUserValidationPort {
    private static final String ROL_PROPIETARIO = "PROPIETARIO";
    private final RestClient restClient;

    public UsuariosHttpAdapter(String usuariosServiceUrl) {
        this.restClient = RestClient.builder().baseUrl(usuariosServiceUrl).build();
    }

    @Override
    public boolean isOwnerValid(Long idPropietario) {
        if (idPropietario == null) return false;
        try {
            RolResponse respuesta = restClient.get()
                    .uri("/usuarios/{id}/rol", idPropietario)
                    .headers(h -> TokenContext.actual().ifPresent(h::setBearerAuth))
                    .retrieve()
                    .body(RolResponse.class);
            return respuesta != null && ROL_PROPIETARIO.equals(respuesta.rol());
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        } catch (RestClientException e) {
            throw new ServicioNoDisponible("No fue posible validar al propietario en el servicio de usuarios");
        }
    }

    record RolResponse(String rol) {}
}