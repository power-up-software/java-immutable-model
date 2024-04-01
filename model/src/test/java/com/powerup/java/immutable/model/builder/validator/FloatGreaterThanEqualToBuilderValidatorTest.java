package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class FloatGreaterThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new FloatGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                FloatGreaterThanEqualToBuilderValidatorTest::getValidValue, 1.0F));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new FloatGreaterThanEqualToBuilderValidator(PARAMETER_NAME, null, 1.0F));
    }

    @Test
    public void testValidate_GreaterThan() {
        FloatGreaterThanEqualToBuilderValidator instance = new FloatGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                FloatGreaterThanEqualToBuilderValidatorTest::getValidValue, 0.0F);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        FloatGreaterThanEqualToBuilderValidator instance = new FloatGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                FloatGreaterThanEqualToBuilderValidatorTest::getValidValue, 1.0F);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        FloatGreaterThanEqualToBuilderValidator instance = new FloatGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                FloatGreaterThanEqualToBuilderValidatorTest::getValidValue, 2.0F);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 2.0F), result);
    }

    @Test
    public void testValidate_Null() {
        FloatGreaterThanEqualToBuilderValidator instance = new FloatGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                FloatGreaterThanEqualToBuilderValidatorTest::getNullValue, 2.0F);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Float getValidValue() {
        return 1.0F;
    }

    private static Float getNullValue() {
        return null;
    }
}