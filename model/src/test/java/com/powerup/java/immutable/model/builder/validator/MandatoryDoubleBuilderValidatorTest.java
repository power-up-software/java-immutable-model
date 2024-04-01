package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class MandatoryDoubleBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new MandatoryDoubleBuilderValidator(PARAMETER_NAME, MandatoryDoubleBuilderValidatorTest::getValidValue));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new MandatoryDoubleBuilderValidator(PARAMETER_NAME, null));
    }

    @Test
    public void testValidate_Valid() {
        MandatoryDoubleBuilderValidator instance = new MandatoryDoubleBuilderValidator(PARAMETER_NAME,
                MandatoryDoubleBuilderValidatorTest::getValidValue);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_NotValid() {
        MandatoryDoubleBuilderValidator instance = new MandatoryDoubleBuilderValidator(PARAMETER_NAME,
                MandatoryDoubleBuilderValidatorTest::getInvalidValue);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    @Test
    public void testValidate_Null() {
        MandatoryDoubleBuilderValidator instance = new MandatoryDoubleBuilderValidator(PARAMETER_NAME,
                MandatoryDoubleBuilderValidatorTest::getNullValue);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    private static Double getValidValue() {
        return 1.0;
    }

    private static Double getInvalidValue() {
        return 0.0;
    }

    private static Double getNullValue() {
        return null;
    }
}