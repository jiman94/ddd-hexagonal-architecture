package com.seedotech.dddhexagonalarchitecture.application.service;

import com.seedotech.dddhexagonalarchitecture.application.ports.input.GetOrderUseCase;
import com.seedotech.dddhexagonalarchitecture.application.ports.output.OrderEventPublisher;
import com.seedotech.dddhexagonalarchitecture.application.ports.output.OrderPersistence;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.eventsourcing.eventpublisher.event.OrderCreatedEvent;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.customizedexception.exception.OrderNotFound;
import com.seedotech.dddhexagonalarchitecture.domain.Order;
import com.seedotech.dddhexagonalarchitecture.application.ports.input.CreateOrderUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService implements CreateOrderUseCase, GetOrderUseCase {

    private final OrderPersistence orderPersistence;

    private final OrderEventPublisher orderEventPublisher;

    @Override
    public Order createOrder(Order order) {
        order = orderPersistence.saveOrder(order);
        orderEventPublisher.publishOrderCreatedEvent(new OrderCreatedEvent(order.getId()));
        return order;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderPersistence.getOrderById(id).orElseThrow(() -> new OrderNotFound("Order not found with id " + id));
    }

}
