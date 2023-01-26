package com.seedotech.dddhexagonalarchitecture.application.port.output.persistence;

import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;

import java.util.Optional;

public interface RestaurantPersistencePort {

    Restaurant saveRestaurant(Restaurant restaurant);

    Optional<Restaurant> getRestaurantById(Long id);

}
