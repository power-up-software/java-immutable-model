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

package com.powerupsoftwareengineering.java.immutable.model.parameter.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SuppressWarnings({"ConstantConditions", "RedundantSuppression"})
class SoftLengthRestrictionStringParameterBuilderValidatorTest {
    private static final String PARAMETER_NAME = "name";
    private static final int MAX_LENGTH = 2;

    @Test
    public void testValidate_LessThan() {
        String parameterValue = "a";
        SoftLengthRestrictionStringParameterValidator instance = new SoftLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(parameterValue);
        assertEquals(parameterValue, result);
    }

    @Test
    public void testValidate_Equal() {
        String parameterValue = "ab";
        SoftLengthRestrictionStringParameterValidator instance = new SoftLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(parameterValue);
        assertEquals(parameterValue, result);
    }

    @Test
    public void testValidate_GreaterThan() {
        String parameterValue = "abc";
        SoftLengthRestrictionStringParameterValidator instance = new SoftLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(parameterValue);
        assertEquals(parameterValue.substring(0, MAX_LENGTH), result);
    }

    @Test
    public void testValidate_Null() {
        SoftLengthRestrictionStringParameterValidator instance = new SoftLengthRestrictionStringParameterValidator(PARAMETER_NAME, MAX_LENGTH);
        String result = instance.validate(null);
        assertNull(result);
    }
}