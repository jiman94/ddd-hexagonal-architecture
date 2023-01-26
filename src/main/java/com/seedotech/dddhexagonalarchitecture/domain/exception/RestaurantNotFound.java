package com.seedotech.dddhexagonalarchitecture.domain.exception;

public class RestaurantNotFound extends RuntimeException {

    public RestaurantNotFound(String message) {
        super(message);
    }

}