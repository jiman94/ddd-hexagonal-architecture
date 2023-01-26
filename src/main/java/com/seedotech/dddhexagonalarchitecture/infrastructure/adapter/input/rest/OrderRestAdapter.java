package com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest;

import com.seedotech.dddhexagonalarchitecture.application.port.input.usecase.GetOrderUseCase;
import com.seedotech.dddhexagonalarchitecture.domain.model.Order;
import com.seedotech.dddhexagonalarchitecture.application.port.input.usecase.CreateOrderUseCase;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.request.OrderCreateRequest;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response.OrderCreateResponse;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.data.response.OrderQueryResponse;
import com.seedotech.dddhexagonalarchitecture.infrastructure.adapter.input.rest.mapper.OrderRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0")
@RequiredArgsConstructor
@Slf4j
public class OrderRestAdapter {

    private final CreateOrderUseCase createOrderUseCase;

    private final GetOrderUseCase getOrderUseCase;

    private final OrderRestMapper orderRestMapper;

    @PostMapping(value = "/orders")
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody @Valid OrderCreateRequest orderCreateRequest) {
        // Request to domain
        Order order = orderRestMapper.toOrder(orderCreateRequest);

        try {
            order = createOrderUseCase.createOrder(order);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

        // Domain to response
        return new ResponseEntity<>(orderRestMapper.toOrderCreateResponse(order), HttpStatus.CREATED);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<OrderQueryResponse> getOrder(@PathVariable Long id){
        Order order = getOrderUseCase.getOrderById(id);
        return new ResponseEntity<>(orderRestMapper.toOrderQueryResponse(order), HttpStatus.OK);
    }

}
