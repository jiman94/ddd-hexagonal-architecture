package com.seedotech.dddhexagonalarchitecture.application.ports.output;

import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;

import java.util.Optional;

public interface RestaurantPersistence {

    Restaurant saveRestaurant(Restaurant restaurant);

    Optional<Restaurant> getRestaurantById(Long id);

}
