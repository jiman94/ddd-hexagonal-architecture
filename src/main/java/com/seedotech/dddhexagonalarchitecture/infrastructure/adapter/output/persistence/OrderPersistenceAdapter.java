package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence;

import com.seedotech.dddhexagonalarchitecture.application.port.output.persistence.OrderPersistencePort;
import com.seedotech.dddhexagonalarchitecture.domain.model.Order;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.entity.OrderEntity;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.mapper.OrderPersistenceMapper;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderRepository orderRepository;

    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = orderPersistenceMapper.toOrderEntity(order);
        orderEntity = orderRepository.save(orderEntity);
        return orderPersistenceMapper.toOrder(orderEntity);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);

        if(orderEntity.isEmpty()) {
            return Optional.empty();
        }

        Order order = orderPersistenceMapper.toOrder(orderEntity.get());
        return Optional.of(order);
    }

    @Override
    public Optional<Order> getOrderByName(String name) {
        Optional<OrderEntity> orderEntity = orderRepository.findByName(name);

        if(orderEntity.isEmpty()) {
            return Optional.empty();
        }

        Order order = orderPersistenceMapper.toOrder(orderEntity.get());
        return Optional.of(order);
    }

    @Override
    public boolean existsByName(String name) {
        return orderRepository.existsByName(name);
    }
}
