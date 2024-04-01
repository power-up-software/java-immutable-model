package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class CharGreaterThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new CharGreaterThanEqualToBuilderValidator(PARAMETER_NAME, CharGreaterThanEqualToBuilderValidatorTest::getValidValue,
                'a'));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new CharGreaterThanEqualToBuilderValidator(PARAMETER_NAME, null, 'a'));
    }

    @Test
    public void testValidate_GreaterThan() {
        CharGreaterThanEqualToBuilderValidator instance = new CharGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                CharGreaterThanEqualToBuilderValidatorTest::getValidValue, 'a');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        CharGreaterThanEqualToBuilderValidator instance = new CharGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                CharGreaterThanEqualToBuilderValidatorTest::getValidValue, 'b');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        CharGreaterThanEqualToBuilderValidator instance = new CharGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                CharGreaterThanEqualToBuilderValidatorTest::getValidValue, 'c');
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 'c'), result);
    }

    @Test
    public void testValidate_Null() {
        CharGreaterThanEqualToBuilderValidator instance = new CharGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                CharGreaterThanEqualToBuilderValidatorTest::getNullValue, 'c');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Character getValidValue() {
        return 'b';
    }

    private static Character getNullValue() {
        return null;
    }
}