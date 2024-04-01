package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class IntLessThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new IntLessThanEqualToBuilderValidator(PARAMETER_NAME, IntLessThanEqualToBuilderValidatorTest::getValidValue, 1));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new IntLessThanEqualToBuilderValidator(PARAMETER_NAME, null, 1));
    }

    @Test
    public void testValidate_GreaterThan() {
        IntLessThanEqualToBuilderValidator instance = new IntLessThanEqualToBuilderValidator(PARAMETER_NAME,
                IntLessThanEqualToBuilderValidatorTest::getValidValue, 0);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 0), result);
    }

    @Test
    public void testValidate_Equal() {
        IntLessThanEqualToBuilderValidator instance = new IntLessThanEqualToBuilderValidator(PARAMETER_NAME,
                IntLessThanEqualToBuilderValidatorTest::getValidValue, 1);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        IntLessThanEqualToBuilderValidator instance = new IntLessThanEqualToBuilderValidator(PARAMETER_NAME,
                IntLessThanEqualToBuilderValidatorTest::getValidValue, 2);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Null() {
        IntLessThanEqualToBuilderValidator instance = new IntLessThanEqualToBuilderValidator(PARAMETER_NAME,
                IntLessThanEqualToBuilderValidatorTest::getNullValue, 2);
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