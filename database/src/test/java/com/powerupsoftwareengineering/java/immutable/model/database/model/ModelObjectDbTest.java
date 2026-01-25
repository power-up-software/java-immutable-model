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

package com.powerupsoftwareengineering.java.immutable.model.database.model;

import com.powerupsoftwareengineering.java.immutable.model.ModelObjectAbs;
import java.util.UUID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ModelObjectDbTest {

    private final ModelObjectAbs mockModelObjectAbs = mock(ModelObjectAbs.class);

    private final ModelObjectAbs.Builder<?> mockModelObjectAbsBuilder = mock(ModelObjectAbs.Builder.class);

    @Test
    public void testConstructor() {
        UUID id = UUID.randomUUID();
        when(mockModelObjectAbs.getId()).thenReturn(id);

        ModelObjectDb result = new FakeModelObjectDb(mockModelObjectAbs);

        assertEquals(id, result.getId());
    }

    @Test
    public void testPopulateModelObjectValues() {
        UUID id = UUID.randomUUID();
        ModelObjectDb instance = new FakeModelObjectDb();
        instance.setId(id);

        instance.populateModelObjectValues(mockModelObjectAbsBuilder);

        verify(mockModelObjectAbsBuilder, times(1)).setId(id);
    }
}