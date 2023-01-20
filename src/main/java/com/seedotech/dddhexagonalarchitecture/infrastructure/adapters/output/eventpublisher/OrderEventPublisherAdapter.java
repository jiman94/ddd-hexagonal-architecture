package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.eventpublisher;

import com.seedotech.dddhexagonalarchitecture.application.ports.output.OrderEventPublisher;
import com.seedotech.dddhexagonalarchitecture.domain.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class OrderEventPublisherAdapter implements OrderEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishOrderCreatedEvent(OrderCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
