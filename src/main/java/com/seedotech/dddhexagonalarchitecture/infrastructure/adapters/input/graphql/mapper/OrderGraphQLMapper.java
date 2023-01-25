package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.graphql.mapper;

import com.seedotech.dddhexagonalarchitecture.domain.Order;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.graphql.data.request.OrderInput;
import org.mapstruct.Mapper;

@Mapper
public interface OrderGraphQLMapper {

    Order toOrder(OrderInput orderInput);
}
