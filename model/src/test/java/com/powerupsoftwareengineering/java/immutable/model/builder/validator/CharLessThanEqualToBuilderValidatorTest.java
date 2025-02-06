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
class CharLessThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new CharLessThanEqualToBuilderValidator(PARAMETER_NAME, CharLessThanEqualToBuilderValidatorTest::getValidValue,
                'b'));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new CharLessThanEqualToBuilderValidator(PARAMETER_NAME, null, 'b'));
    }

    @Test
    public void testValidate_GreaterThan() {
        CharLessThanEqualToBuilderValidator instance = new CharLessThanEqualToBuilderValidator(PARAMETER_NAME,
                CharLessThanEqualToBuilderValidatorTest::getValidValue, 'a');
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 'a'), result);
    }

    @Test
    public void testValidate_Equal() {
        CharLessThanEqualToBuilderValidator instance = new CharLessThanEqualToBuilderValidator(PARAMETER_NAME,
                CharLessThanEqualToBuilderValidatorTest::getValidValue, 'b');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        CharLessThanEqualToBuilderValidator instance = new CharLessThanEqualToBuilderValidator(PARAMETER_NAME,
                CharLessThanEqualToBuilderValidatorTest::getValidValue, 'c');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Null() {
        CharLessThanEqualToBuilderValidator instance = new CharLessThanEqualToBuilderValidator(PARAMETER_NAME,
                CharLessThanEqualToBuilderValidatorTest::getNullValue, 'c');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Character getValidValue() {
        return 'b';
    }

    private static Character getNullValue() {
        return null;
    }
}