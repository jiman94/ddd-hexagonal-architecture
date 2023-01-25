package com.seedotech.dddhexagonalarchitecture.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private String name;

    private String description;

    private int total;

}
