package com.seedotech.dddhexagonalarchitecture.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    private Long id;

    private String name;

    private String description;
}