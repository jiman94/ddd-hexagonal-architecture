package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantQueryResponse {

    private Long id;

    private String name;

    private String description;
}
