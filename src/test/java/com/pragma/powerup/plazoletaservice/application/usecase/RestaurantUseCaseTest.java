package com.pragma.powerup.plazoletaservice.application.usecase;

import com.pragma.powerup.plazoletaservice.domain.model.Restaurant;
import com.pragma.powerup.plazoletaservice.domain.spi.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RestaurantUseCaseTest {

    private IRestaurantPersistencePort persistencePort;
    private RestaurantUseCase restaurantUseCase;
    private IUserValidationPort userport;
    private IRestaurantRepositoryPort restrepo;

    @BeforeEach
    void setUp() {
        // Creamos un mock del puerto de persistencia para aislar el dominio de la base de datos
        persistencePort = Mockito.mock(IRestaurantPersistencePort.class);
        userport = Mockito.mock(IUserValidationPort.class);
        
        // Inicializamos el caso de uso inyectándole el mock
        restaurantUseCase = new RestaurantUseCase(persistencePort, userport, restrepo);
    }

    @Test
    void debeGuardarRestauranteExitosamente() {
        // Arrange: Creamos un restaurante que pase todas las validaciones de las regex
        Restaurant restaurant = new Restaurant();
        restaurant.setNombre("Restaurante Central"); // No es solo números
        restaurant.setNit("123456789");              // Solo dígitos
        restaurant.setTelefono("+573001234567");       // Cumple formato de la regex ^\+?[0-9]{1,12}$
        restaurant.setUrlLogo("http://logo.com/img.png");
        restaurant.setIdPropietario(1L);

        // Simulamos que el microservicio de usuarios responde que el propietario SÍ es válido
        when(userport.isOwnerValid(1L)).thenReturn(true);

        // Act
        restaurantUseCase.saveRestaurant(restaurant);

        // Assert: Verificamos que se intentó guardar en la persistencia
        verify(persistencePort, times(1)).saveRestaurant(any(Restaurant.class));
    }
}
