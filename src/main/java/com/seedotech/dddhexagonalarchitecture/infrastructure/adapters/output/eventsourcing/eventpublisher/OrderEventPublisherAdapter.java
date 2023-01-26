package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.eventsourcing.eventpublisher;

import com.seedotech.dddhexagonalarchitecture.application.ports.output.eventsourcing.OrderEventPublisherPort;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.eventsourcing.eventpublisher.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class OrderEventPublisherAdapter implements OrderEventPublisherPort {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishOrderCreatedEvent(OrderCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
