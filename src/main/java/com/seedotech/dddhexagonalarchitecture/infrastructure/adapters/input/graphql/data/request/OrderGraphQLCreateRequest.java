package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.graphql.data.request;

import com.seedotech.dddhexagonalarchitecture.common.Common;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderGraphQLCreateRequest {

    @NotEmpty(message = Common.MSG_NAME_NOT_EMPTY)
    private String name;

    @NotEmpty(message = Common.MSG_DESCRIPTION_NOT_EMPTY)
    private String description;

    @NotNull(message = Common.MSG_TOTAL_NOT_NULL)
    private int total;
}
