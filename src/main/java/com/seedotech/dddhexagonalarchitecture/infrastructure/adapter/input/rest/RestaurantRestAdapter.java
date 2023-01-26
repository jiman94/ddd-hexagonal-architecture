package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest;

import com.seedotech.dddhexagonalarchitecture.application.port.input.usecase.CreateRestaurantUseCase;
import com.seedotech.dddhexagonalarchitecture.application.port.input.usecase.GetRestaurantUseCase;
import com.seedotech.dddhexagonalarchitecture.domain.model.Restaurant;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.request.RestaurantCreateRequest;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response.RestaurantCreateResponse;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response.RestaurantQueryResponse;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.mapper.RestaurantRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0")
@RequiredArgsConstructor
public class RestaurantRestAdapter {

    private final CreateRestaurantUseCase createRestaurantUseCase;

    private final GetRestaurantUseCase getRestaurantUseCase;

    private final RestaurantRestMapper restaurantRestMapper;

    @PostMapping(value = "/restaurants")
    public ResponseEntity<RestaurantCreateResponse> createRestaurant(@RequestBody @Valid RestaurantCreateRequest restaurantCreateRequest){
        // Request to domain
        Restaurant restaurant = restaurantRestMapper.toRestaurant(restaurantCreateRequest);

        restaurant = createRestaurantUseCase.createRestaurant(restaurant);

        // Domain to response
        return new ResponseEntity<>(restaurantRestMapper.toRestaurantCreateResponse(restaurant), HttpStatus.CREATED);
    }

    @GetMapping(value = "/restaurants/{id}")
    public ResponseEntity<RestaurantQueryResponse> getRestaurant(@PathVariable Long id){
        Restaurant restaurant = getRestaurantUseCase.getRestaurantById(id);
        return new ResponseEntity<>(restaurantRestMapper.toRestaurantQueryResponse(restaurant), HttpStatus.OK);
    }

}
