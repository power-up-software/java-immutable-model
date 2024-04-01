package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class FloatLessThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new FloatLessThanEqualToBuilderValidator(PARAMETER_NAME, FloatLessThanEqualToBuilderValidatorTest::getValidValue,
                1.0F));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new FloatLessThanEqualToBuilderValidator(PARAMETER_NAME, null, 1.0F));
    }

    @Test
    public void testValidate_GreaterThan() {
        FloatLessThanEqualToBuilderValidator instance = new FloatLessThanEqualToBuilderValidator(PARAMETER_NAME,
                FloatLessThanEqualToBuilderValidatorTest::getValidValue, 0.0F);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 0.0), result);
    }

    @Test
    public void testValidate_Equal() {
        FloatLessThanEqualToBuilderValidator instance = new FloatLessThanEqualToBuilderValidator(PARAMETER_NAME,
                FloatLessThanEqualToBuilderValidatorTest::getValidValue, 1.0F);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        FloatLessThanEqualToBuilderValidator instance = new FloatLessThanEqualToBuilderValidator(PARAMETER_NAME,
                FloatLessThanEqualToBuilderValidatorTest::getValidValue, 2.0F);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Null() {
        FloatLessThanEqualToBuilderValidator instance = new FloatLessThanEqualToBuilderValidator(PARAMETER_NAME,
                FloatLessThanEqualToBuilderValidatorTest::getNullValue, 2.0F);
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