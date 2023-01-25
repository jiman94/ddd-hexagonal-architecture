package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.persistence.mapper;

import com.seedotech.dddhexagonalarchitecture.domain.Order;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OrderPersistenceMapper {

    OrderEntity toOrderEntity(Order order);

    Order toOrder(OrderEntity orderEntity);

}
