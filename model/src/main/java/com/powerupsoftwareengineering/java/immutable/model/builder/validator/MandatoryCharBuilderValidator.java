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
 * A <code>MandatoryCharValidator</code> is a validator that validates if a mandatory char is set.
 * In this context set means not null and not equal to 0.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryCharBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the char parameter with will be checked to ensure it is set.
     */
    private final Supplier<Character> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryCharBuilderValidator(final String name, final Supplier<Character> valueSupplier) {
        super(name);
        validateBuilder();
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
    }

    @Override
    public String validate() {
        String result = "";
        Character value = valueSupplier.get();
        if (value == null || value == 0) {
            result = String.format(UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}