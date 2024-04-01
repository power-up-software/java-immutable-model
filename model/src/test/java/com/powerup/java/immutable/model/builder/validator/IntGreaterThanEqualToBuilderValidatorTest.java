package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class IntGreaterThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new IntGreaterThanEqualToBuilderValidator(PARAMETER_NAME, IntGreaterThanEqualToBuilderValidatorTest::getValidValue,
                1));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new IntGreaterThanEqualToBuilderValidator(PARAMETER_NAME, null, 1));
    }

    @Test
    public void testValidate_GreaterThan() {
        IntGreaterThanEqualToBuilderValidator instance = new IntGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                IntGreaterThanEqualToBuilderValidatorTest::getValidValue, 0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        IntGreaterThanEqualToBuilderValidator instance = new IntGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                IntGreaterThanEqualToBuilderValidatorTest::getValidValue, 1);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        IntGreaterThanEqualToBuilderValidator instance = new IntGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                IntGreaterThanEqualToBuilderValidatorTest::getValidValue, 2);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 2), result);
    }

    @Test
    public void testValidate_Null() {
        IntGreaterThanEqualToBuilderValidator instance = new IntGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                IntGreaterThanEqualToBuilderValidatorTest::getNullValue, 2);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Integer getValidValue() {
        return 1;
    }

    private static Integer getNullValue() {
        return null;
    }
}