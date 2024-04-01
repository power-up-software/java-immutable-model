package com.powerup.java.immutable.model.builder.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MandatoryCollectionBuilderValidatorTest {

    public static final String PARAMETER_NAME = "test";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new MandatoryCollectionBuilderValidator(PARAMETER_NAME, MandatoryCollectionBuilderValidatorTest::getValidValue));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new MandatoryCollectionBuilderValidator(PARAMETER_NAME, null));
    }

    @Test
    public void testValidate_Valid() {
        MandatoryCollectionBuilderValidator instance = new MandatoryCollectionBuilderValidator(PARAMETER_NAME,
                MandatoryCollectionBuilderValidatorTest::getValidValue);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_NotValid() {
        MandatoryCollectionBuilderValidator instance = new MandatoryCollectionBuilderValidator(PARAMETER_NAME,
                MandatoryCollectionBuilderValidatorTest::getInvalidValue);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    @Test
    public void testValidate_Null() {
        MandatoryCollectionBuilderValidator instance = new MandatoryCollectionBuilderValidator(PARAMETER_NAME,
                MandatoryCollectionBuilderValidatorTest::getNullValue);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    private static List<String> getValidValue() {
        return Collections.singletonList("set");
    }

    private static List<String> getInvalidValue() {
        return new ArrayList<>();
    }

    @SuppressWarnings("SameReturnValue")
    private static List<String> getNullValue() {
        return null;
    }
}