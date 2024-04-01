package com.powerup.java.immutable.model;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SimplifiableAssertion")
public class ModelObjectAbsTest {

    private FakeModelObjectBuilder instance;

    @BeforeEach
    public void before() {
        instance = new FakeModelObjectBuilder();
    }

    @Test
    public void testBuilder() {
        UUID id = UUID.randomUUID();
        instance.setId(id);
        FakeModelObject result = instance.build();
        assertEquals(id, result.getId());
    }

    @Test
    public void testBuilder_NoId() {
        FakeModelObject result = instance.build();
        assertNotNull(result.getId());
    }

    @Test
    public void testReset() {
        UUID id = UUID.randomUUID();
        instance.setId(id);
        instance.reset();
        FakeModelObject result = instance.build();
        assertNotEquals(id, result.getId());
    }

    @Test
    public void testCopyValues() {
        UUID id = UUID.randomUUID();
        instance.setId(id);
        FakeModelObject result = instance.build();
        instance.reset();
        instance.copyValues(result);
        result = instance.build();
        assertEquals(id, result.getId());
    }

    @Test
    public void testSetValues() {
        UUID id = UUID.randomUUID();
        instance.setId(id);
        FakeModelObject result = instance.build();
        instance.reset();
        instance.setValues(result);
        result = instance.build();
        assertNotEquals(id, result.getId());
    }

    @Test
    public void testToString() {
        FakeModelObject result = instance.build();
        assertTrue(result.toString().contains("id="));
    }

    @Test
    public void testEquals_Nominal() {
        FakeModelObject result = instance.build();
        FakeModelObject result2 = instance.build();
        assertTrue(result.equals(result2));
    }

    @SuppressWarnings("EqualsWithItself")
    @Test
    public void testEquals_SameObject() {
        FakeModelObject result = instance.build();
        assertTrue(result.equals(result));
    }

    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @Test
    public void testEquals_DifferentClass() {
        FakeModelObject result = instance.build();
        assertFalse(result.equals(""));
    }

    @SuppressWarnings({"ConstantConditions", "RedundantSuppression"})
    @Test
    public void testEquals_Null() {
        FakeModelObject result = instance.build();
        assertFalse(result.equals(null));
    }
}