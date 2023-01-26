package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.graphql.data.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInput {

    private String name;

    private String description;

    private int total;
}
