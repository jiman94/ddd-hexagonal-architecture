package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.config;

import com.seedotech.dddhexagonalarchitecture.application.service.OrderService;
import com.seedotech.dddhexagonalarchitecture.application.service.RestaurantService;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.eventsourcing.eventpublisher.OrderEventPublisherAdapter;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.OrderPersistenceAdapter;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.RestaurantPersistenceAdapter;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.mapper.OrderPersistenceMapper;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.mapper.RestaurantPersistenceMapper;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.repository.OrderRepository;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.repository.RestaurantRepository;
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
    public RestaurantPersistenceAdapter restaurantPersistenceAdapter(RestaurantRepository restaurantRepository, RestaurantPersistenceMapper restaurantPersistenceMapper) {
        return new RestaurantPersistenceAdapter(restaurantRepository, restaurantPersistenceMapper);
    }

    @Bean
    public OrderEventPublisherAdapter orderEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new OrderEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public OrderService orderService(OrderPersistenceAdapter orderPersistenceAdapter, OrderEventPublisherAdapter orderEventPublisherAdapter) {
        return new OrderService(orderPersistenceAdapter, orderEventPublisherAdapter);
    }

    @Bean
    public RestaurantService restaurantService(RestaurantPersistenceAdapter restaurantPersistenceAdapter) {
        return new RestaurantService(restaurantPersistenceAdapter);
    }
}
