package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.mapper;

import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.entity.RestaurantEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RestaurantPersistenceMapper {

    RestaurantEntity toRestaurantEntity(Restaurant restaurant);

    Restaurant toRestaurant(RestaurantEntity restaurantEntity);

}
