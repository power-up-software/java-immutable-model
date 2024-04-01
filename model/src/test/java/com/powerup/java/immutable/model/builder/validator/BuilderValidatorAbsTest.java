package com.powerup.java.immutable.model.builder.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BuilderValidatorAbsTest {

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new FakeBuilderValidator("test"));
    }

    @Test
    public void testConstructor_NullName() {
        assertThrows(IllegalArgumentException.class, () -> new FakeBuilderValidator(null).validateBuilder());
    }
}