package com.seedotech.dddhexagonalarchitecture.application.ports.output.persistence;

import com.seedotech.dddhexagonalarchitecture.domain.model.Order;

import java.util.Optional;

public interface OrderPersistencePort {

    Order saveOrder(Order order);

    Optional<Order> getOrderById(Long id);
}
