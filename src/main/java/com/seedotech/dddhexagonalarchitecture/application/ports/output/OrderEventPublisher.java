package com.seedotech.dddhexagonalarchitecture.application.ports.output;

import com.seedotech.dddhexagonalarchitecture.domain.event.OrderCreatedEvent;

public interface OrderEventPublisher {

    void publishOrderCreatedEvent(OrderCreatedEvent event);

}
