package com.seedotech.dddhexagonalarchitecture.application.ports.input.usecase;

import com.seedotech.dddhexagonalarchitecture.domain.model.Order;

public interface CreateOrderUseCase {

    Order createOrder(Order order) throws Exception;

}
