package com.powerup.java.immutable.model.parameter.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SuppressWarnings({"ConstantConditions", "RedundantSuppression"})
class SoftLengthRestrictionStringParameterBuilderValidatorTest {
    private static final String PARAMETER_NAME = "name";
    private static final int MAX_LENGTH = 2;

    @Test
    public void testValidate_LessThan() {
        String parameterValue = "a";
        SoftLengthRestrictionStringParameterValidator instance = new SoftLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(parameterValue);
        assertEquals(parameterValue, result);
    }

    @Test
    public void testValidate_Equal() {
        String parameterValue = "ab";
        SoftLengthRestrictionStringParameterValidator instance = new SoftLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(parameterValue);
        assertEquals(parameterValue, result);
    }

    @Test
    public void testValidate_GreaterThan() {
        String parameterValue = "abc";
        SoftLengthRestrictionStringParameterValidator instance = new SoftLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(parameterValue);
        assertEquals(parameterValue.substring(0, MAX_LENGTH), result);
    }

    @Test
    public void testValidate_Null() {
        SoftLengthRestrictionStringParameterValidator instance = new SoftLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(null);
        assertNull(result);
    }
}