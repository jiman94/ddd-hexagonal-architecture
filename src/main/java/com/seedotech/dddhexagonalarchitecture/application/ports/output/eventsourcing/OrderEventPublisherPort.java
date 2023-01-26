package com.seedotech.dddhexagonalarchitecture.application.ports.output.eventsourcing;

import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.eventsourcing.eventpublisher.event.OrderCreatedEvent;

public interface OrderEventPublisherPort {

    void publishOrderCreatedEvent(OrderCreatedEvent event);

}
