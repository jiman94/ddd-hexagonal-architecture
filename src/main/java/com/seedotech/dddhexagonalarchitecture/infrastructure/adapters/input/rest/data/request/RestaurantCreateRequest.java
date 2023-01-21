package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest.data.request;

import com.seedotech.dddhexagonalarchitecture.common.Common;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantCreateRequest {

    @NotEmpty(message = Common.MSG_NAME_NOT_EMPTY)
    private String name;

    @NotEmpty(message = Common.MSG_DESCRIPTION_NOT_EMPTY)
    private String description;
}
