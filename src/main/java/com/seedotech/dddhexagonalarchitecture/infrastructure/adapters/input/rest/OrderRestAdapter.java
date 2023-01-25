package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest;

import com.seedotech.dddhexagonalarchitecture.application.ports.input.GetOrderUseCase;
import com.seedotech.dddhexagonalarchitecture.domain.Order;
import com.seedotech.dddhexagonalarchitecture.application.ports.input.CreateOrderUseCase;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest.data.request.OrderCreateRequest;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest.data.response.OrderCreateResponse;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest.data.response.OrderQueryResponse;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.input.rest.mapper.OrderRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0")
@RequiredArgsConstructor
public class OrderRestAdapter {

    private final CreateOrderUseCase createOrderUseCase;

    private final GetOrderUseCase getOrderUseCase;

    private final OrderRestMapper orderRestMapper;

    @PostMapping(value = "/orders")
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody @Valid OrderCreateRequest orderCreateRequest){
        // Request to domain
        Order order = orderRestMapper.toOrder(orderCreateRequest);

        order = createOrderUseCase.createOrder(order);

        // Domain to response
        return new ResponseEntity<>(orderRestMapper.toOrderCreateResponse(order), HttpStatus.CREATED);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<OrderQueryResponse> getOrder(@PathVariable Long id){
        Order order = getOrderUseCase.getOrderById(id);
        return new ResponseEntity<>(orderRestMapper.toOrderQueryResponse(order), HttpStatus.OK);
    }

}
