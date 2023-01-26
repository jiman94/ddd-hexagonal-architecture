package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.mapper;

import com.seedotech.dddhexagonalarchitecture.domain.model.Order;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OrderPersistenceMapper {

    OrderEntity toOrderEntity(Order order);

    Order toOrder(OrderEntity orderEntity);

}
