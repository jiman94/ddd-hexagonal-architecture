package com.seedotech.dddhexagonalarchitecture.domain.service;

import com.seedotech.dddhexagonalarchitecture.application.ports.input.CreateRestaurantUseCase;
import com.seedotech.dddhexagonalarchitecture.application.ports.input.GetRestaurantUseCase;
import com.seedotech.dddhexagonalarchitecture.application.ports.output.RestaurantPersistence;
import com.seedotech.dddhexagonalarchitecture.domain.exception.RestaurantNotFound;
import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestaurantService implements CreateRestaurantUseCase, GetRestaurantUseCase {

    private final RestaurantPersistence restaurantPersistence;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurant = restaurantPersistence.saveRestaurant(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantPersistence.getRestaurantById(id).orElseThrow(() -> new RestaurantNotFound("Restaurant not found with id " + id));
    }

}