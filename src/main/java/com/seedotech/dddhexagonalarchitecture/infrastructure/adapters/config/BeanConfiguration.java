package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.config;

import com.seedotech.dddhexagonalarchitecture.domain.service.OrderService;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.eventpublisher.OrderEventPublisherAdapter;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.persistence.OrderPersistenceAdapter;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.persistence.mapper.OrderPersistenceMapper;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.persistence.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OrderPersistenceAdapter orderPersistenceAdapter(OrderRepository orderRepository, OrderPersistenceMapper orderPersistenceMapper) {
        return new OrderPersistenceAdapter(orderRepository, orderPersistenceMapper);
    }

    @Bean
    public OrderEventPublisherAdapter orderEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new OrderEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public OrderService orderService(OrderPersistenceAdapter orderPersistenceAdapter, OrderEventPublisherAdapter orderEventPublisherAdapter) {
        return new OrderService(orderPersistenceAdapter, orderEventPublisherAdapter);
    }
}
