package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.graphql.data.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGraphQLInput {

    private String name;

    private String description;

    private int total;
}
