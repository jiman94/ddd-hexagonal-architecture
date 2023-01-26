package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantCreateResponse {

    private Long id;

    private String name;

    private String description;
}
