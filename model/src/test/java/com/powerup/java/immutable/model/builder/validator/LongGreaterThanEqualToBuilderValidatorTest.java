package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class LongGreaterThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new LongGreaterThanEqualToBuilderValidator(PARAMETER_NAME, LongGreaterThanEqualToBuilderValidatorTest::getValidValue,
                1L));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new LongGreaterThanEqualToBuilderValidator(PARAMETER_NAME, null, 1L));
    }

    @Test
    public void testValidate_GreaterThan() {
        LongGreaterThanEqualToBuilderValidator instance = new LongGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                LongGreaterThanEqualToBuilderValidatorTest::getValidValue, 0L);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        LongGreaterThanEqualToBuilderValidator instance = new LongGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                LongGreaterThanEqualToBuilderValidatorTest::getValidValue, 1L);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        LongGreaterThanEqualToBuilderValidator instance = new LongGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                LongGreaterThanEqualToBuilderValidatorTest::getValidValue, 2L);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 2L), result);
    }

    @Test
    public void testValidate_Null() {
        LongGreaterThanEqualToBuilderValidator instance = new LongGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                LongGreaterThanEqualToBuilderValidatorTest::getNullValue, 2L);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Long getValidValue() {
        return 1L;
    }

    private static Long getNullValue() {
        return null;
    }
}