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

/**
 * A <code>SoftLengthRestrictionStringParameterValidator</code> is a validator that validates that a string is less than equal to a specific length.
 * If it exceeds that length, it will trim the value down.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class SoftLengthRestrictionStringParameterValidator extends ParameterValidatorAbs<String> {
    /**
     * The maximum length that the string parameter is allowed to be.
     */
    private final int maxLength;

    /**
     * Base constructor.
     *
     * @param name Value of {@link ParameterValidatorAbs#name}.
     * @param maxLength Value of {@link #maxLength}.
     */
    public SoftLengthRestrictionStringParameterValidator(final String name, final int maxLength) {
        super(name);
        validateBuilder();
        this.maxLength = maxLength;
    }

    @Override
    public String validate(final String value) {
        if (value == null || value.length() <= maxLength) {
            return value;
        } else {
            return value.substring(0, maxLength);
        }
    }
}