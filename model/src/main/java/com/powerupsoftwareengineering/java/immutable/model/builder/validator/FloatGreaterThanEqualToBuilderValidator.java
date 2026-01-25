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

import java.util.function.Supplier;

/**
 * A <code>FloatGreaterThanEqualToValidator</code> is a validator that validates if a parameter is greater than or equal to the provided value.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class FloatGreaterThanEqualToBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the float parameter to validate that it is greater than or equal to the min value.
     */
    private final Supplier<Float> valueSupplier;
    /**
     * The min value to validate if the parameter is greater than or equal to.
     */
    private final float minValue;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     * @param minValue Value of {@link #minValue}.
     */
    public FloatGreaterThanEqualToBuilderValidator(final String name, final Supplier<Float> valueSupplier, final float minValue) {
        super(name);
        validateBuilder();
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
        this.minValue = minValue;
    }

    @Override
    public String validate() {
        String result = "";
        Float value = valueSupplier.get();
        if (value != null && value < minValue) {
            result = String.format(GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, getName(), minValue);
        }
        return result;
    }
}