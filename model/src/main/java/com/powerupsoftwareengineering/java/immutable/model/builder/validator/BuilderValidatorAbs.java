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

import com.powerupsoftwareengineering.value.verification.util.StringVerificationUtil;
import java.io.Serial;
import java.io.Serializable;

/**
 * A <code>BuilderValidatorAbs</code> is the common implementation used by all builder validators that holds the name of the parameter being
 * validated.
 *
 * @author Chris Picard
 */
public abstract class BuilderValidatorAbs implements BuilderValidator, Serializable {
    /**
     * The version ID of the serializable object.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * The name of the parameter being validated.
     */
    private final String name;

    /**
     * Base constructor.
     *
     * @param name Value of {@link #name}.
     */
    protected BuilderValidatorAbs(final String name) {
        this.name = name;
    }

    /**
     * Accessor for the {@link #name} member variable.
     *
     * @return Current value of the {@link #name} member variable.
     */
    protected String getName() {
        return name;
    }

    /**
     * Utility method to validate of the validator builder is correctly formed.
     *
     * @throws IllegalArgumentException The validator builder is not formed correctly.
     */
    protected void validateBuilder() throws IllegalArgumentException {
        if (StringVerificationUtil.isEmpty(name)) {
            throw new IllegalArgumentException("Name must be set.");
        }
    }
}