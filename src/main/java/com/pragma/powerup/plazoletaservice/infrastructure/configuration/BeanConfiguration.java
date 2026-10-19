package com.pragma.powerup.plazoletaservice.infrastructure.configuration;

import com.pragma.powerup.plazoletaservice.application.usecase.DishUseCase;
import com.pragma.powerup.plazoletaservice.application.usecase.RestaurantUseCase;
import com.pragma.powerup.plazoletaservice.domain.api.IDishServicePort;
import com.pragma.powerup.plazoletaservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.plazoletaservice.domain.spi.IDishPersistencePort;
import com.pragma.powerup.plazoletaservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.plazoletaservice.domain.spi.IRestaurantRepositoryPort;
import com.pragma.powerup.plazoletaservice.domain.spi.IUserValidationPort;
import com.pragma.powerup.plazoletaservice.infrastructure.output.client.UsuariosHttpAdapter;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.adapter.DishJpaAdapter;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.adapter.RestaurantJpaAdapter;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.adapter.RestaurantRepositoryAdapter;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.repository.IDishRepository;
import com.pragma.powerup.plazoletaservice.infrastructure.output.jpa.repository.IRestaurantRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final IRestaurantRepository restaurantRepository;
    private final IDishRepository dishRepository;

    public BeanConfiguration(IRestaurantRepository restaurantRepository, IDishRepository dishRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

    @Bean
    public IUserValidationPort userValidationPort(@Value("${usuarios.service.url}") String usuariosServiceUrl) {
        return new UsuariosHttpAdapter(usuariosServiceUrl);
    }

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantJpaAdapter(restaurantRepository);
    }

    @Bean
    public IDishPersistencePort dishPersistencePort() {
        return new DishJpaAdapter(dishRepository);
    }

    @Bean
    public IRestaurantRepositoryPort restaurantRepositoryPort() {
        return new RestaurantRepositoryAdapter(restaurantRepository);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort(IUserValidationPort userValidationPort) {
        return new RestaurantUseCase(restaurantPersistencePort(), userValidationPort, restaurantRepositoryPort());
    }

    @Bean
    public IDishServicePort dishServicePort() {
        return new DishUseCase(dishPersistencePort(), restaurantPersistencePort());
    }
}