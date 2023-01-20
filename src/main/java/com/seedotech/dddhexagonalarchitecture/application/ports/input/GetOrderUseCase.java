package com.seedotech.dddhexagonalarchitecture.application.ports.input;

import com.seedotech.dddhexagonalarchitecture.domain.model.Order;

public interface GetOrderUseCase {

    Order getOrderById(Long id);

}
