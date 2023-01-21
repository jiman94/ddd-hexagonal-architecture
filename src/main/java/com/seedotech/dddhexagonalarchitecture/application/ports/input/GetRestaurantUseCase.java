package com.seedotech.dddhexagonalarchitecture.application.ports.input;

import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;

public interface GetRestaurantUseCase {

    Restaurant getRestaurantById(Long id);

}
