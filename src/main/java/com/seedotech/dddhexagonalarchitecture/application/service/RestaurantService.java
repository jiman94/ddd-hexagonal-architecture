package com.seedotech.dddhexagonalarchitecture.application.service;

import com.seedotech.dddhexagonalarchitecture.application.ports.input.usecase.CreateRestaurantUseCase;
import com.seedotech.dddhexagonalarchitecture.application.ports.input.usecase.GetRestaurantUseCase;
import com.seedotech.dddhexagonalarchitecture.application.ports.output.persistence.RestaurantPersistencePort;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.customizedexception.exception.RestaurantNotFound;
import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestaurantService implements CreateRestaurantUseCase, GetRestaurantUseCase {

    private final RestaurantPersistencePort restaurantPersistencePort;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurant = restaurantPersistencePort.saveRestaurant(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantPersistencePort.getRestaurantById(id).orElseThrow(() -> new RestaurantNotFound("Restaurant not found with id " + id));
    }

}