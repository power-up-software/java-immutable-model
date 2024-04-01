package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class MandatoryStringBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new MandatoryStringBuilderValidator(PARAMETER_NAME, MandatoryStringBuilderValidatorTest::getValidValue));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new MandatoryStringBuilderValidator(PARAMETER_NAME, null));
    }

    @Test
    public void testValidate_Valid() {
        MandatoryStringBuilderValidator instance = new MandatoryStringBuilderValidator(PARAMETER_NAME,
                MandatoryStringBuilderValidatorTest::getValidValue);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_NotValid() {
        MandatoryStringBuilderValidator instance = new MandatoryStringBuilderValidator(PARAMETER_NAME,
                MandatoryStringBuilderValidatorTest::getInvalidValue);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    @Test
    public void testValidate_Null() {
        MandatoryStringBuilderValidator instance = new MandatoryStringBuilderValidator(PARAMETER_NAME,
                MandatoryStringBuilderValidatorTest::getNullValue);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    private static String getValidValue() {
        return "set";
    }

    private static String getInvalidValue() {
        return "";
    }

    private static String getNullValue() {
        return null;
    }
}