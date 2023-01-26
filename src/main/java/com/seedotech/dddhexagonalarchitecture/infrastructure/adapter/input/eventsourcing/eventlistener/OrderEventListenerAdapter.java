package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.eventsourcing.eventlistener;

import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.eventsourcing.eventpublisher.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderEventListenerAdapter {

    @EventListener
    public void handle(OrderCreatedEvent event){
        log.info("Order created with id " + event.getId() + " at " + event.getDate());
    }

}
