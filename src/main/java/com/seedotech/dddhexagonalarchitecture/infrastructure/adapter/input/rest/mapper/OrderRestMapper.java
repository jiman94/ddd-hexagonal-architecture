package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.mapper;

import com.seedotech.dddhexagonalarchitecture.domain.model.Order;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response.OrderQueryResponse;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.request.OrderCreateRequest;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response.OrderCreateResponse;
import org.mapstruct.Mapper;

@Mapper
public interface OrderRestMapper {

    Order toOrder(OrderCreateRequest orderCreateRequest);

    OrderCreateResponse toOrderCreateResponse(Order order);

    OrderQueryResponse toOrderQueryResponse(Order order);

}
