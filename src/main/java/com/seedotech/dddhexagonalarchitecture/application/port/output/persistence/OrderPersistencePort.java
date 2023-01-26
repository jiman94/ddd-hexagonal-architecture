package com.seedotech.dddhexagonalarchitecture.application.port.output.persistence;

import com.seedotech.dddhexagonalarchitecture.domain.model.Order;

import java.util.Optional;

public interface OrderPersistencePort {

    Order saveOrder(Order order);

    Optional<Order> getOrderById(Long id);

    /**
     * Returns the found order entry by using its name as search criteria.
     * If no order entry is found, this method returns null
     */
    Optional<Order> getOrderByName(String name);

    /**
     * Returns true if found the order with the given name, false otherwise
     */
    boolean existsByName(String name);
}
