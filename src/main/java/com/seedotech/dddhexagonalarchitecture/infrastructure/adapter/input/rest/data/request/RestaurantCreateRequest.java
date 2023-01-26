package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.request;

import com.seedotech.dddhexagonalarchitecture.common.Common;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantCreateRequest {

    @NotEmpty(message = Common.MSG_NAME_NOT_EMPTY)
    @Size(
        min = 5,
        max = 20,
        message = "The name '${validatedValue}' must be between {min} and {max} characters long"
    )
    private String name;

    @NotEmpty(message = Common.MSG_DESCRIPTION_NOT_EMPTY)
    private String description;
}
