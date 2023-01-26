package com.seedotech.dddhexagonalarchitecture.application.service;

import com.seedotech.dddhexagonalarchitecture.application.ports.input.usecase.GetOrderUseCase;
import com.seedotech.dddhexagonalarchitecture.application.ports.output.eventsourcing.OrderEventPublisherPort;
import com.seedotech.dddhexagonalarchitecture.application.ports.output.persistence.OrderPersistencePort;
import com.seedotech.dddhexagonalarchitecture.domain.validation.OrderValidator;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.eventsourcing.eventpublisher.event.OrderCreatedEvent;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.customizedexception.exception.OrderNotFound;
import com.seedotech.dddhexagonalarchitecture.domain.model.Order;
import com.seedotech.dddhexagonalarchitecture.application.ports.input.usecase.CreateOrderUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService implements CreateOrderUseCase, GetOrderUseCase {

    private final OrderPersistencePort orderPersistencePort;

    private final OrderEventPublisherPort orderEventPublisherPort;

    @Override
    public Order createOrder(Order order) throws Exception {
        OrderValidator.validateOrder(order);
        order = orderPersistencePort.saveOrder(order);
        orderEventPublisherPort.publishOrderCreatedEvent(new OrderCreatedEvent(order.getId()));
        return order;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderPersistencePort.getOrderById(id).orElseThrow(() -> new OrderNotFound("Order not found with id " + id));
    }

}
