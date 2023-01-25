package com.seedotech.dddhexagonalarchitecture.infrastructure.adapters.output.customizedexception.exception;

public class OrderNotFound extends RuntimeException {

    public OrderNotFound(String message) {
        super(message);
    }

}
