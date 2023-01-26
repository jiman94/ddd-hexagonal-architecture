package com.seedotech.dddhexagonalarchitecture.application.port.output.eventsourcing;

import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.eventsourcing.eventpublisher.event.OrderCreatedEvent;

public interface OrderEventPublisherPort {

    void publishOrderCreatedEvent(OrderCreatedEvent event);

}
