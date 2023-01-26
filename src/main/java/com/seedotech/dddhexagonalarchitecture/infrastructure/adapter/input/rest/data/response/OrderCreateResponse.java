package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateResponse {

    private Long id;

    private String name;

    private String description;

    private int total;
}
