package com.seedotech.dddhexagonalarchitecture.application.service;

import com.seedotech.dddhexagonalarchitecture.application.port.input.usecase.GetOrderUseCase;
import com.seedotech.dddhexagonalarchitecture.application.port.output.eventsourcing.OrderEventPublisherPort;
import com.seedotech.dddhexagonalarchitecture.application.port.output.persistence.OrderPersistencePort;
import com.seedotech.dddhexagonalarchitecture.common.Common;
import com.seedotech.dddhexagonalarchitecture.domain.validation.OrderValidator;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.eventsourcing.eventpublisher.event.OrderCreatedEvent;
import com.seedotech.dddhexagonalarchitecture.domain.exception.OrderNotFound;
import com.seedotech.dddhexagonalarchitecture.domain.model.Order;
import com.seedotech.dddhexagonalarchitecture.application.port.input.usecase.CreateOrderUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService implements CreateOrderUseCase, GetOrderUseCase {

    private final OrderPersistencePort orderPersistencePort;

    private final OrderEventPublisherPort orderEventPublisherPort;

    @Override
    public Order createOrder(Order order) throws Exception {
        // Validate order constraints/rules
        OrderValidator.validateOrder(order);
        // Check the application-specific business rules of the order
        checkIfNameIsExisting(order.getName());
        // Save the order to the database
        order = orderPersistencePort.saveOrder(order);
        // Publish the order created event
        orderEventPublisherPort.publishOrderCreatedEvent(new OrderCreatedEvent(order.getId()));
        // Return the order with all information (e.g. includes the generated id)
        return order;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderPersistencePort.getOrderById(id).orElseThrow(() -> new OrderNotFound("Order not found with id " + id));
    }

    private void checkIfNameIsExisting(final String name) throws Exception {
        if (orderPersistencePort.existsByName(name))
            throw new Exception(Common.MSG_NAME_IS_EXISTING);
    }
}
