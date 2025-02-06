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

import java.util.function.Supplier;

/**
 * A <code>DoubleLessThanEqualToValidator</code> is a validator that validates if a parameter is less than or equal to the provided value.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class DoubleLessThanEqualToBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the double parameter to validate that it is less than or equal to the max value.
     */
    private final Supplier<Double> valueSupplier;
    /**
     * The max value to validate if the parameter is less than or equal to.
     */
    private final double maxValue;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     * @param maxValue Value of {@link #maxValue}.
     */
    public DoubleLessThanEqualToBuilderValidator(final String name, final Supplier<Double> valueSupplier, final double maxValue) {
        super(name);
        validateBuilder();
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
        this.maxValue = maxValue;
    }

    @Override
    public String validate() {
        String result = "";
        Double value = valueSupplier.get();
        if (value != null && value > maxValue) {
            result = String.format(LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, getName(), maxValue);
        }
        return result;
    }
}