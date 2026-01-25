/*
 * Copyright (c) Power Up Software Engineering LLC 2026.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package com.powerupsoftwareengineering.java.immutable.model.sample;

import java.util.UUID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SampleChildModelObjectTest {
    private static final String NAME = "Name";
    private static final String TYPE = "Type";

    @Test
    public void testBuild_NominalCase() {
        SampleChildModelObject.Builder instance = new SampleChildModelObject.Builder();
        instance.setName(NAME);
        instance.setType(TYPE);
        SampleChildModelObject result = instance.build();
        assertEquals(NAME, result.getName());
        assertEquals(TYPE, result.getType());
    }

    @Test
    public void testBuild_NoName() {
        SampleChildModelObject.Builder instance = new SampleChildModelObject.Builder();
        instance.setType(TYPE);
        assertThrows(IllegalStateException.class, instance::build);
    }

    @Test
    public void testBuild_NoOrder() {
        SampleChildModelObject.Builder instance = new SampleChildModelObject.Builder();
        instance.setName(NAME);
        assertThrows(IllegalStateException.class, instance::build);
    }

    @Test
    public void testCopyValues_NominalCase() {
        SampleChildModelObject.Builder builder = new SampleChildModelObject.Builder();
        builder.setName(NAME);
        builder.setType(TYPE);
        SampleChildModelObject sampleModelObject = builder.build();
        SampleChildModelObject.Builder instance = new SampleChildModelObject.Builder();
        instance.copyValues(sampleModelObject);
        SampleChildModelObject result = instance.build();
        assertEquals(sampleModelObject, result);
        assertEquals(sampleModelObject.getName(), result.getName());
        assertEquals(sampleModelObject.getType(), result.getType());
        assertEquals(sampleModelObject.getId(), result.getId());
    }

    @Test
    public void testSetValues_NominalCase() {
        SampleChildModelObject.Builder builder = new SampleChildModelObject.Builder();
        builder.setName(NAME);
        builder.setType(TYPE);
        SampleChildModelObject sampleModelObject = builder.build();
        SampleChildModelObject.Builder instance = new SampleChildModelObject.Builder();
        instance.setValues(sampleModelObject);
        SampleChildModelObject result = instance.build();
        assertEquals(sampleModelObject, result);
        assertEquals(sampleModelObject.getName(), result.getName());
        assertEquals(sampleModelObject.getType(), result.getType());
        assertNotEquals(sampleModelObject.getId(), result.getId());
    }

    @Test
    public void testReset_NominalCase() {
        SampleChildModelObject.Builder instance = new SampleChildModelObject.Builder();
        instance.setId(UUID.randomUUID());
        instance.setName(NAME);
        instance.setType(TYPE);
        instance.reset();
        assertNull(instance.getId());
        assertNull(instance.getName());
        assertNull(instance.getType());
    }
}