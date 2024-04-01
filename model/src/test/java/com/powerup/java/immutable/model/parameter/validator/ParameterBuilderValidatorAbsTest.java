package com.powerup.java.immutable.model.parameter.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParameterBuilderValidatorAbsTest {

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new FakeParameterValidator("test"));
    }

    @Test
    public void testConstructor_NullName() {
        assertThrows(IllegalArgumentException.class, () -> new FakeParameterValidator(null).validateBuilder());
    }
}