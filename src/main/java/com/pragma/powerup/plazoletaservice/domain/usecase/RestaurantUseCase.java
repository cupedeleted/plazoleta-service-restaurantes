package com.pragma.powerup.plazoletaservice.domain.usecase;

import com.pragma.powerup.plazoletaservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import com.pragma.powerup.plazoletaservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.plazoletaservice.domain.spi.IUserValidationPort;

public class RestaurantUseCase implements IRestaurantServicePort {

    // Atributos
    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IUserValidationPort userValidationPort;

    // Constructor para inicializar los atributos
    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort, IUserValidationPort userValidationPort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.userValidationPort = userValidationPort;
    }

    // Método para guardar un restaurante
    @Override
    public void saveRestaurant(Restaurant restaurant) {
        // Validar que el nombre no sea solo números
        if (restaurant.getNombre().matches("^[0-9]+$")) {
            throw new IllegalArgumentException("El nombre del restaurante no puede constar únicamente de números.");
        }

        // Validar que el NIT sea numérico
        if (!restaurant.getNit().matches("^[0-9]+$")) {
            throw new IllegalArgumentException("El NIT debe contener únicamente dígitos.");
        }

        // Validar formato de teléfono
        if (!restaurant.getTelefono().matches("^\\+?[0-9]{1,12}$")) {
            throw new IllegalArgumentException("El formato del teléfono es inválido.");
        }

        // Validar si el usuario existe y es Propietario
        if (!userValidationPort.isOwnerValid(restaurant.getIdPropietario())) {
            throw new IllegalArgumentException("El ID ingresado no corresponde a un propietario válido.");
        }

        this.restaurantPersistencePort.saveRestaurant(restaurant);
    }
}