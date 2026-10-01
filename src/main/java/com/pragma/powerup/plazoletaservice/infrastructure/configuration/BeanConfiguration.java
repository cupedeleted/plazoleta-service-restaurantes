package com.pragma.powerup.plazoletaservice.infrastructure.configuration;

import com.pragma.powerup.plazoletaservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.plazoletaservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.plazoletaservice.domain.spi.IUserValidationPort;
import com.pragma.powerup.plazoletaservice.domain.usecase.RestaurantUseCase;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.adapter.RestaurantJpaAdapter;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.repository.IRestaurantRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final IRestaurantRepository restaurantRepository;
    private final IUserValidationPort userValidationPort;

    public BeanConfiguration(IRestaurantRepository restaurantRepository, IUserValidationPort userValidationPort) {
        this.restaurantRepository = restaurantRepository;
        this.userValidationPort = userValidationPort;
    }

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantJpaAdapter(restaurantRepository);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort(), userValidationPort);
    }
}