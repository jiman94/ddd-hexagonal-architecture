package com.seedotech.dddhexagonalarchitecture.application.ports.output;

import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.eventsourcing.eventpublisher.event.OrderCreatedEvent;

public interface OrderEventPublisher {

    void publishOrderCreatedEvent(OrderCreatedEvent event);

}
