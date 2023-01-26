package com.seedotech.dddhexagonalarchitecture.application.ports.input.usecase;

import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;

public interface CreateRestaurantUseCase {

    Restaurant createRestaurant(Restaurant restaurant);

}
