package com.seedotech.dddhexagonalarchitecture.application.ports.input;

import com.seedotech.dddhexagonalarchitecture.domain.Order;

public interface CreateOrderUseCase {

    Order createOrder(Order order);

}
