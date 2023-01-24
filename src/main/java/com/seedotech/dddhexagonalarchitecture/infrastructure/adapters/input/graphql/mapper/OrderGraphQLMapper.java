package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.graphql.mapper;

import com.seedotech.dddhexagonalarchitecture.domain.model.Order;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.graphql.data.request.OrderGraphQLInput;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest.data.request.OrderCreateRequest;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest.data.response.OrderCreateResponse;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest.data.response.OrderQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface OrderGraphQLMapper {

    Order toOrder(OrderGraphQLInput orderGraphQLInput);
}
