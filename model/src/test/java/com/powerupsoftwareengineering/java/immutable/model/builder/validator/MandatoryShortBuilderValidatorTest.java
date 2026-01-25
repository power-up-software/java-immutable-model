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

package com.powerupsoftwareengineering.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class MandatoryShortBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new MandatoryShortBuilderValidator(PARAMETER_NAME, MandatoryShortBuilderValidatorTest::getValidValue));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new MandatoryShortBuilderValidator(PARAMETER_NAME, null));
    }

    @Test
    public void testValidate_Valid() {
        MandatoryShortBuilderValidator instance = new MandatoryShortBuilderValidator(PARAMETER_NAME,
                MandatoryShortBuilderValidatorTest::getValidValue);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_NotValid() {
        MandatoryShortBuilderValidator instance = new MandatoryShortBuilderValidator(PARAMETER_NAME,
                MandatoryShortBuilderValidatorTest::getInvalidValue);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    @Test
    public void testValidate_Null() {
        MandatoryShortBuilderValidator instance = new MandatoryShortBuilderValidator(PARAMETER_NAME,
                MandatoryShortBuilderValidatorTest::getNullValue);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    private static Short getValidValue() {
        return 1;
    }

    private static Short getInvalidValue() {
        return 0;
    }

    private static Short getNullValue() {
        return null;
    }
}