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
class LongLessThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new LongLessThanEqualToBuilderValidator(PARAMETER_NAME, LongLessThanEqualToBuilderValidatorTest::getValidValue, 1L));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new LongLessThanEqualToBuilderValidator(PARAMETER_NAME, null, 1L));
    }

    @Test
    public void testValidate_GreaterThan() {
        LongLessThanEqualToBuilderValidator instance = new LongLessThanEqualToBuilderValidator(PARAMETER_NAME,
                LongLessThanEqualToBuilderValidatorTest::getValidValue, 0L);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 0), result);
    }

    @Test
    public void testValidate_Equal() {
        LongLessThanEqualToBuilderValidator instance = new LongLessThanEqualToBuilderValidator(PARAMETER_NAME,
                LongLessThanEqualToBuilderValidatorTest::getValidValue, 1L);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        LongLessThanEqualToBuilderValidator instance = new LongLessThanEqualToBuilderValidator(PARAMETER_NAME,
                LongLessThanEqualToBuilderValidatorTest::getValidValue, 2L);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Null() {
        LongLessThanEqualToBuilderValidator instance = new LongLessThanEqualToBuilderValidator(PARAMETER_NAME,
                LongLessThanEqualToBuilderValidatorTest::getNullValue, 2L);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Long getValidValue() {
        return 1L;
    }

    private static Long getNullValue() {
        return null;
    }
}