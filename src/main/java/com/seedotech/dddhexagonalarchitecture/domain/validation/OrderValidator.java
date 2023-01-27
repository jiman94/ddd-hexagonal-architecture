package com.seedotech.dddhexagonalarchitecture.domain.validation;

import com.seedotech.dddhexagonalarchitecture.common.Common;
import com.seedotech.dddhexagonalarchitecture.domain.model.Order;

/**
 * Validates constraints/rules of the order
 */
public class OrderValidator {
    public static void validateOrder(final Order order) throws Exception {
        // Validate the order attributes
        checkIfNameStartWithSpecialCharacter(order.getName());
    }

    private static void checkIfNameStartWithSpecialCharacter(final String name) throws Exception {
        String firstChar = name.substring(0, 1);
        if (firstChar.equals("*"))
            throw new Exception(Common.MSG_NAME_START_WITH_SPECIAL_CHARACTER);
    }
}
