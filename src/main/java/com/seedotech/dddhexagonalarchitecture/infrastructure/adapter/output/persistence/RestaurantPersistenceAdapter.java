package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence;

import com.seedotech.dddhexagonalarchitecture.application.port.output.persistence.RestaurantPersistencePort;
import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.entity.RestaurantEntity;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.mapper.RestaurantPersistenceMapper;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.output.persistence.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RestaurantPersistenceAdapter implements RestaurantPersistencePort {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantPersistenceMapper restaurantPersistenceMapper;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        RestaurantEntity restaurantEntity = restaurantPersistenceMapper.toRestaurantEntity(restaurant);
        restaurantEntity = restaurantRepository.save(restaurantEntity);
        return restaurantPersistenceMapper.toRestaurant(restaurantEntity);
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long id) {
        Optional<RestaurantEntity> restaurantEntity = restaurantRepository.findById(id);

        if(restaurantEntity.isEmpty()) {
            return Optional.empty();
        }

        Restaurant restaurant = restaurantPersistenceMapper.toRestaurant(restaurantEntity.get());
        return Optional.of(restaurant);
    }

}
