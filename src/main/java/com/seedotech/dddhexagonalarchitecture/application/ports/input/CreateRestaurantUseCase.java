package com.seedotech.dddhexagonalarchitecture.application.ports.input;

import com.seedotech.dddhexagonalarchitecture.domain.Restaurant;

public interface CreateRestaurantUseCase {

    Restaurant createRestaurant(Restaurant restaurant);

}
