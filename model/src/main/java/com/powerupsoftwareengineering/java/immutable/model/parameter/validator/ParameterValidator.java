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
 * A <code>ParameterValidator</code> is a utility that will perform a validation check on a parameter of a model object during the set operation. They
 * are used when there are constraints on not just if a value is set or not, but restrictions on the value itself.
 *
 * @param <T> The type of the parameter the validator is for.
 *
 * @author Chris Picard
 */
@SuppressWarnings("unused")
public interface ParameterValidator<T> {
    /**
     * Error message representing that a length restriction on a value is exceeded.
     */
    String LENGTH_EXCEEDED_ERROR_MESSAGE = "%s can not exceed %d %s";

    /**
     * Performs a validation check on the parameter the validator is for during a set operation.
     *
     * @param value The parameter value to validate.
     *
     * @return Valid version of the provided parameter.
     *
     * @throws IllegalArgumentException Provided parameter is not valid.
     */
    T validate(T value) throws IllegalArgumentException;
}