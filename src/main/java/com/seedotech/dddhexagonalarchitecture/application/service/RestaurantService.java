package com.seedotech.dddhexagonalarchitecture.application.service;

import com.seedotech.dddhexagonalarchitecture.application.port.input.usecase.CreateRestaurantUseCase;
import com.seedotech.dddhexagonalarchitecture.application.port.input.usecase.GetRestaurantUseCase;
import com.seedotech.dddhexagonalarchitecture.application.port.output.persistence.RestaurantPersistencePort;
import com.seedotech.dddhexagonalarchitecture.domain.exception.RestaurantNotFound;
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