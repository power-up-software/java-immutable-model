package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class DoubleLessThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new DoubleLessThanEqualToBuilderValidator(PARAMETER_NAME, DoubleLessThanEqualToBuilderValidatorTest::getValidValue,
                1.0));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new DoubleLessThanEqualToBuilderValidator(PARAMETER_NAME, null, 1.0));
    }

    @Test
    public void testValidate_GreaterThan() {
        DoubleLessThanEqualToBuilderValidator instance = new DoubleLessThanEqualToBuilderValidator(PARAMETER_NAME,
                DoubleLessThanEqualToBuilderValidatorTest::getValidValue, 0.0);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 0.0), result);
    }

    @Test
    public void testValidate_Equal() {
        DoubleLessThanEqualToBuilderValidator instance = new DoubleLessThanEqualToBuilderValidator(PARAMETER_NAME,
                DoubleLessThanEqualToBuilderValidatorTest::getValidValue, 1.0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        DoubleLessThanEqualToBuilderValidator instance = new DoubleLessThanEqualToBuilderValidator(PARAMETER_NAME,
                DoubleLessThanEqualToBuilderValidatorTest::getValidValue, 2.0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Null() {
        DoubleLessThanEqualToBuilderValidator instance = new DoubleLessThanEqualToBuilderValidator(PARAMETER_NAME,
                DoubleLessThanEqualToBuilderValidatorTest::getNullValue, 2.0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Double getValidValue() {
        return 1.0;
    }

    private static Double getNullValue() {
        return null;
    }
}