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