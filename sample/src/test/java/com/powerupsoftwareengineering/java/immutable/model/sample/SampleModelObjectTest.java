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

class SampleModelObjectTest {
    private static final String NAME = "Name";
    private static final int ORDER = 2;

    @Test
    public void testBuild_NominalCase() {
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.setName(NAME);
        instance.setOrder(ORDER);
        SampleModelObject result = instance.build();
        assertEquals(NAME, result.getName());
        assertEquals(ORDER, result.getOrder());
    }

    @Test
    public void testBuild_NoName() {
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.setOrder(ORDER);
        assertThrows(IllegalStateException.class, instance::build);
    }

    @Test
    public void testBuild_NoOrder() {
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.setName(NAME);
        assertThrows(IllegalStateException.class, instance::build);
    }

    @Test
    public void testCopyValues_NominalCase() {
        SampleModelObject.Builder builder = new SampleModelObject.Builder();
        builder.setName(NAME);
        builder.setOrder(ORDER);
        SampleModelObject sampleModelObject = builder.build();
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.copyValues(sampleModelObject);
        SampleModelObject result = instance.build();
        assertEquals(sampleModelObject, result);
        assertEquals(sampleModelObject.getName(), result.getName());
        assertEquals(sampleModelObject.getOrder(), result.getOrder());
        assertEquals(sampleModelObject.getId(), result.getId());
    }

    @Test
    public void testSetValues_NominalCase() {
        SampleModelObject.Builder builder = new SampleModelObject.Builder();
        builder.setName(NAME);
        builder.setOrder(ORDER);
        SampleModelObject sampleModelObject = builder.build();
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.setValues(sampleModelObject);
        SampleModelObject result = instance.build();
        assertEquals(sampleModelObject, result);
        assertEquals(sampleModelObject.getName(), result.getName());
        assertEquals(sampleModelObject.getOrder(), result.getOrder());
        assertNotEquals(sampleModelObject.getId(), result.getId());
    }

    @Test
    public void testReset_NominalCase() {
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.setId(UUID.randomUUID());
        instance.setName(NAME);
        instance.setOrder(ORDER);
        instance.reset();
        assertNull(instance.getId());
        assertNull(instance.getName());
        assertEquals(0, instance.getOrder());
    }
}