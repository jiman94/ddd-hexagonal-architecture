package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.eventsourcing.eventpublisher.event;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent {

    private Long id;

    private LocalDateTime date;

    public OrderCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}

