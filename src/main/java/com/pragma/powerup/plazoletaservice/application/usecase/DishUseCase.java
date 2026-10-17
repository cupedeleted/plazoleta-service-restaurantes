package com.pragma.powerup.plazoletaservice.application.usecase;

import com.pragma.powerup.plazoletaservice.domain.api.IDishServicePort;
import com.pragma.powerup.plazoletaservice.domain.exception.DishNotFoundException;
import com.pragma.powerup.plazoletaservice.domain.model.Dish;
import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import com.pragma.powerup.plazoletaservice.domain.spi.IDishPersistencePort;
import com.pragma.powerup.plazoletaservice.domain.spi.IRestaurantPersistencePort;

public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort, IRestaurantPersistencePort restaurantPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveDish(Dish dish, Long idPropietarioSolicitante) {
        // Validar que el precio sea mayor a 0
        if (dish.getPrecio() == null || dish.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser un valor numérico mayor a 0.");
        }

        // Consultar existencia del restaurante
        Restaurant restaurant = restaurantPersistencePort.findById(dish.getIdRestaurante());
        if (restaurant == null) {
            throw new IllegalArgumentException("El restaurante especificado no existe.");
        }

        // Validar que quien intenta crear el plato sea el verdadero propietario del
        // restaurante
        if (!restaurant.getIdPropietario().equals(idPropietarioSolicitante)) {
            throw new IllegalArgumentException("Solo el propietario del restaurante puede crear platos en él.");
        }

        // Estado activo por defecto
        dish.setActivo(true);

        this.dishPersistencePort.saveDish(dish);
    }

    @Override
    public void updateDish(Long id, Integer precio, String descripcion) {
        if (precio == null || precio <= 0) {

            throw new IllegalArgumentException("El precio debe ser un valor numérico mayor a 0.");
        }
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descprcion no debe estar vacia.");
        }
        Dish dish = dishPersistencePort.findById(id);
        if(dish == null ){
            throw new DishNotFoundException(id);
    }
    dish.setPrecio(precio);
    dish.setDescripcion(descripcion);

    this.dishPersistencePort.saveDish(dish);
}
}
