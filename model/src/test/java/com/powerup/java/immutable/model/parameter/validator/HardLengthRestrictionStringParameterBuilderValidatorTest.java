package com.powerup.java.immutable.model.parameter.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings({"ConstantConditions", "RedundantSuppression"})
class HardLengthRestrictionStringParameterBuilderValidatorTest {
    private static final String PARAMETER_NAME = "name";
    private static final int MAX_LENGTH = 2;

    @Test
    public void testValidate_LessThan() {
        String parameterValue = "a";
        HardLengthRestrictionStringParameterValidator instance = new HardLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(parameterValue);
        assertEquals(parameterValue, result);
    }

    @Test
    public void testValidate_Equal() {
        String parameterValue = "ab";
        HardLengthRestrictionStringParameterValidator instance = new HardLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(parameterValue);
        assertEquals(parameterValue, result);
    }

    @Test
    public void testValidate_GreaterThan() {
        String parameterValue = "abc";
        HardLengthRestrictionStringParameterValidator instance = new HardLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        assertThrows(IllegalArgumentException.class, () -> instance.validate(parameterValue));
    }

    @Test
    public void testValidate_Null() {
        HardLengthRestrictionStringParameterValidator instance = new HardLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(null);
        assertNull(result);
    }
}