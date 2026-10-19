package com.pragma.powerup.plazoletaservice.application.usecase;

import com.pragma.powerup.plazoletaservice.domain.api.IDishServicePort;
import com.pragma.powerup.plazoletaservice.domain.exception.DishNotFoundException;
import com.pragma.powerup.plazoletaservice.domain.model.Dish;
import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import com.pragma.powerup.plazoletaservice.domain.spi.IDishPersistencePort;
import com.pragma.powerup.plazoletaservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.plazoletaservice.domain.exception.AccesoNoPermitido;

public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort,
            IRestaurantPersistencePort restaurantPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveDish(Dish dish, Long idPropietarioSolicitante) {
        validarPrecio(dish.getPrecio());
        Restaurant restaurant = obtenerRestaurante(dish.getIdRestaurante());
        validarPropietario(restaurant, idPropietarioSolicitante);
        dish.setActivo(true);
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public void updateDish(Long id, Integer precio, String descripcion, Long idPropietarioSolicitante) {
        Dish dish = obtenerPlato(id);
        validarPropietario(obtenerRestaurante(dish.getIdRestaurante()), idPropietarioSolicitante);
        validarPrecio(precio);
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripción no debe estar vacía.");
        }
        dish.setPrecio(precio);
        dish.setDescripcion(descripcion);
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public void changeDishStatus(Long id, Boolean activo, Long idPropietarioSolicitante) {
        Dish dish = obtenerPlato(id);
        validarPropietario(obtenerRestaurante(dish.getIdRestaurante()), idPropietarioSolicitante);
        if (activo == null) {
            throw new IllegalArgumentException("El estado del plato no puede estar vacío.");
        }
        dish.setActivo(activo);
        dishPersistencePort.saveDish(dish);
    }

    private void validarPrecio(Integer precio) {
        if (precio == null || precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser un valor numérico mayor a 0.");
        }
    }

    private Dish obtenerPlato(Long id) {
        Dish dish = dishPersistencePort.findById(id);
        if (dish == null) throw new DishNotFoundException(id);
        return dish;
    }

    private Restaurant obtenerRestaurante(Long id) {
        Restaurant restaurant = restaurantPersistencePort.findById(id);
        if (restaurant == null) throw new IllegalArgumentException("El restaurante especificado no existe.");
        return restaurant;
    }

    private void validarPropietario(Restaurant restaurant, Long idSolicitante) {
        if (restaurant.getIdPropietario() == null || !restaurant.getIdPropietario().equals(idSolicitante)) {
            throw new AccesoNoPermitido("Solo el propietario del restaurante puede gestionar sus platos.");
        }
    }
}