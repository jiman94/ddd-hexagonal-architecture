package com.seedotech.dddhexagonalarchitecture.application.port.input.usecase;

import com.seedotech.dddhexagonalarchitecture.domain.model.Order;

public interface GetOrderUseCase {

    Order getOrderById(Long id);

}
