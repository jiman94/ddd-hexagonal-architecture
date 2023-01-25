package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.persistence.mapper;

import com.seedotech.dddhexagonalarchitecture.domain.Restaurant;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.persistence.entity.RestaurantEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RestaurantPersistenceMapper {

    RestaurantEntity toRestaurantEntity(Restaurant restaurant);

    Restaurant toRestaurant(RestaurantEntity restaurantEntity);

}
