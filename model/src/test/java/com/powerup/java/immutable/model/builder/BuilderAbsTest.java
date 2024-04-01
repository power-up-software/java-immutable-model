package com.powerup.java.immutable.model.builder;

import com.powerup.java.immutable.model.builder.validator.BuilderValidator;
import com.powerup.java.immutable.model.builder.validator.MandatoryObjectBuilderValidator;
import com.powerup.java.immutable.model.builder.validator.MandatoryStringBuilderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
public class BuilderAbsTest {
    private static final String FAILING_PARAMETER_NAME = "test2";
    private static final MandatoryStringBuilderValidator PASSING_VALIDATOR = new MandatoryStringBuilderValidator("test1", BuilderAbsTest::getValue);
    private static final MandatoryObjectBuilderValidator FAILING_VALIDATOR = new MandatoryObjectBuilderValidator(FAILING_PARAMETER_NAME,
            BuilderAbsTest::getNullValue);

    private FakeBuilder instance;

    @BeforeEach
    public void before() {
        instance = new FakeBuilder();
    }

    @Test
    public void testValidate_Valid() {
        instance.addValidator(PASSING_VALIDATOR);
        assertDoesNotThrow(() -> instance.validate());
    }

    @Test
    public void testValidate_NotValid() {
        instance.addValidator(FAILING_VALIDATOR);
        assertThrows(IllegalStateException.class, () -> instance.validate());
    }

    @Test
    public void testIsValid_Valid() {
        instance.addValidator(PASSING_VALIDATOR);
        assertTrue(instance.isValid());
    }

    @Test
    public void testIsValid_NotValid() {
        instance.addValidator(FAILING_VALIDATOR);
        assertFalse(instance.isValid());
    }

    @Test
    public void getValidationErrors_Valid() {
        instance.addValidator(PASSING_VALIDATOR);
        String result = instance.getValidationErrors();
        assertTrue(result.isEmpty(), "Validation errors string should be empty");
    }

    @Test
    public void getValidationErrors_NotValid() {
        instance.addValidator(FAILING_VALIDATOR);
        String result = instance.getValidationErrors();
        assertEquals(String.format(BuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, FAILING_PARAMETER_NAME), result);
    }

    private static String getValue() {
        return "testValue";
    }

    private static String getNullValue() {
        return null;
    }
}