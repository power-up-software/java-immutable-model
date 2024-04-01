package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class ShortLessThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new ShortLessThanEqualToBuilderValidator(PARAMETER_NAME, ShortLessThanEqualToBuilderValidatorTest::getValidValue,
                (short) 1));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new ShortLessThanEqualToBuilderValidator(PARAMETER_NAME, null, (short) 1));
    }

    @Test
    public void testValidate_GreaterThan() {
        ShortLessThanEqualToBuilderValidator instance = new ShortLessThanEqualToBuilderValidator(PARAMETER_NAME,
                ShortLessThanEqualToBuilderValidatorTest::getValidValue, (short) 0);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 0), result);
    }

    @Test
    public void testValidate_Equal() {
        ShortLessThanEqualToBuilderValidator instance = new ShortLessThanEqualToBuilderValidator(PARAMETER_NAME,
                ShortLessThanEqualToBuilderValidatorTest::getValidValue, (short) 1);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        ShortLessThanEqualToBuilderValidator instance = new ShortLessThanEqualToBuilderValidator(PARAMETER_NAME,
                ShortLessThanEqualToBuilderValidatorTest::getValidValue, (short) 2);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Null() {
        ShortLessThanEqualToBuilderValidator instance = new ShortLessThanEqualToBuilderValidator(PARAMETER_NAME,
                ShortLessThanEqualToBuilderValidatorTest::getNullValue, (short) 2);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Short getValidValue() {
        return (short) 1;
    }

    private static Short getNullValue() {
        return null;
    }
}