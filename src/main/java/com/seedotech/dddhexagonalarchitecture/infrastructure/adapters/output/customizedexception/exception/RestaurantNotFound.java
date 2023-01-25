package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.customizedexception.exception;

public class RestaurantNotFound extends RuntimeException {

    public RestaurantNotFound(String message) {
        super(message);
    }

}