package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.graphql.mapper;

import com.seedotech.dddhexagonalarchitecture.domain.model.Order;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.graphql.data.request.OrderInput;
import org.mapstruct.Mapper;

@Mapper
public interface OrderGraphQLMapper {

    Order toOrder(OrderInput orderInput);
}
