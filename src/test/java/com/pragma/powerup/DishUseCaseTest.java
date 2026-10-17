package com.pragma.powerup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pragma.powerup.plazoletaservice.application.usecase.DishUseCase;
import com.pragma.powerup.plazoletaservice.domain.exception.DishNotFoundException;
import com.pragma.powerup.plazoletaservice.domain.model.Dish;
import com.pragma.powerup.plazoletaservice.domain.spi.IDishPersistencePort;
import com.pragma.powerup.plazoletaservice.domain.spi.IRestaurantPersistencePort;

@ExtendWith(MockitoExtension.class)
class DishUseCaseTest {

    @Mock
    private IDishPersistencePort dishPersistencePort;

    @Mock
    private IRestaurantPersistencePort restaurantPersistencePort;

    @InjectMocks
    private DishUseCase dishUseCase;

    private Dish platoExistente() {
        return new Dish(1L, "Bandeja paisa", 2L, "Plato tradicional", 25000, 3L, "http://img/bandeja.png", true);
    }

    @Test
    void modificaSoloPrecioYDescripcion() {
        when(dishPersistencePort.findById(1L)).thenReturn(platoExistente());

        dishUseCase.updateDish(1L, 30000, "Con chicharrón y arepa");

        ArgumentCaptor<Dish> captor = ArgumentCaptor.forClass(Dish.class);
        verify(dishPersistencePort).saveDish(captor.capture());
        Dish guardado = captor.getValue();

        // Lo que cambia
        assertEquals(30000, guardado.getPrecio());
        assertEquals("Con chicharrón y arepa", guardado.getDescripcion());

        // Lo que NO debe cambiar
        assertEquals(1L, guardado.getId());
        assertEquals("Bandeja paisa", guardado.getNombre());
        assertEquals(2L, guardado.getIdCategoria());
        assertEquals(3L, guardado.getIdRestaurante());
        assertEquals("http://img/bandeja.png", guardado.getUrlImagen());
        assertTrue(guardado.getActivo());
    }

    @Test
    void platoNoExiste() {
        when(dishPersistencePort.findById(99L)).thenReturn(null);

        assertThrows(DishNotFoundException.class, () -> dishUseCase.updateDish(99L, 30000, "Nueva descripción"));

        verify(dishPersistencePort, never()).saveDish(org.mockito.ArgumentMatchers.any());
    }

    @Test
    void precioCero() {
        assertThrows(IllegalArgumentException.class, () -> dishUseCase.updateDish(1L, 0, "Nueva descripción"));

        verifyNoInteractions(dishPersistencePort);
    }

    @Test
    void precioNulo() {
        assertThrows(IllegalArgumentException.class, () -> dishUseCase.updateDish(1L, null, "Nueva descripción"));

        verifyNoInteractions(dishPersistencePort);
    }

    @Test
    void descripcionVacia() {
        assertThrows(IllegalArgumentException.class, () -> dishUseCase.updateDish(1L, 30000, "  "));

        verifyNoInteractions(dishPersistencePort);
    }
}