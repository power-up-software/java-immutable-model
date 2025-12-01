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

package com.powerupsoftwareengineering.java.immutable.model.parameter.validator;

import com.powerupsoftwareengineering.value.verification.util.StringVerificationUtil;

/**
 * A <code>ParameterValidatorAbs</code> is the common implementation used by all parameter validators that holds the name of the parameter being
 * validated.
 *
 * @param <T> The type of the parameter the validator is for.
 *
 * @author Chris Picard
 */
public abstract class ParameterValidatorAbs<T> implements ParameterValidator<T> {
    /**
     * The name of the parameter being validated.
     */
    private final String name;

    /**
     * Base constructor.
     *
     * @param name Value of {@link #name}.
     */
    protected ParameterValidatorAbs(final String name) {
        this.name = name;
    }

    /**
     * Utility method to validate of the parameter validator builder is correctly formed.
     *
     * @throws IllegalArgumentException The parameter validator builder is not formed correctly.
     */
    protected void validateBuilder() throws IllegalArgumentException {
        if (StringVerificationUtil.isEmpty(name)) {
            throw new IllegalArgumentException("Name must be set.");
        }
    }

    /**
     * Accessor for the {@link #name} member variable.
     *
     * @return Current value of the {@link #name} member variable.
     */
    protected String getName() {
        return name;
    }
}