package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.mapper;

import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.request.RestaurantCreateRequest;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response.RestaurantCreateResponse;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response.RestaurantQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface RestaurantRestMapper {

    Restaurant toRestaurant(RestaurantCreateRequest restaurantCreateRequest);

    RestaurantCreateResponse toRestaurantCreateResponse(Restaurant restaurant);

    RestaurantQueryResponse toRestaurantQueryResponse(Restaurant restaurant);

}
