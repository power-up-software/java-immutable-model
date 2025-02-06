/*
 * Copyright (c) Power Up Software Engineering LLC 2025.
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
class ShortGreaterThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new ShortGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ShortGreaterThanEqualToBuilderValidatorTest::getValidValue, (short) 1));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new ShortGreaterThanEqualToBuilderValidator(PARAMETER_NAME, null, (short) 1));
    }

    @Test
    public void testValidate_GreaterThan() {
        ShortGreaterThanEqualToBuilderValidator instance = new ShortGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ShortGreaterThanEqualToBuilderValidatorTest::getValidValue, (short) 0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        ShortGreaterThanEqualToBuilderValidator instance = new ShortGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ShortGreaterThanEqualToBuilderValidatorTest::getValidValue, (short) 1);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        ShortGreaterThanEqualToBuilderValidator instance = new ShortGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ShortGreaterThanEqualToBuilderValidatorTest::getValidValue, (short) 2);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 2), result);
    }

    @Test
    public void testValidate_Null() {
        ShortGreaterThanEqualToBuilderValidator instance = new ShortGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ShortGreaterThanEqualToBuilderValidatorTest::getNullValue, (short) 2);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Short getValidValue() {
        return 1;
    }

    private static Short getNullValue() {
        return null;
    }
}