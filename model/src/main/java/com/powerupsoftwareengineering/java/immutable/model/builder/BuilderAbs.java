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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.powerupsoftwareengineering.java.immutable.model.builder;

import com.powerup.value.verification.util.CollectionVerificationUtil;
import com.powerup.value.verification.util.StringVerificationUtil;
import com.powerupsoftwareengineering.java.immutable.model.builder.validator.BuilderValidator;
import java.util.ArrayList;
import java.util.List;

/**
 * A <code>BuilderAbs</code> represents the common components of the Builder Pattern implementation used for generating immutable model objects. It
 * Contains useful validation methods to determine if the contents of the builder are valid. All immutable objects need to be fully valid to allow for
 * construction. This helps ensure data integrity.
 *
 * @param <T> Type of class the builder will be creating.
 *
 * @author Chris Picard
 */
@SuppressWarnings({"SameParameterValue", "unused"})
public abstract class BuilderAbs<T> {
    /**
     * The delimiter used to seperated different error messages when they are combined.
     */
    public static final String ERROR_MESSAGE_DELIMITER = ", ";
    /**
     * A List of validators that will validate that the content of the builder is valid. They help to ensure that only valid objects are constructed.
     */
    private final List<BuilderValidator> builderValidators;

    /**
     * Default Constructor.
     */
    public BuilderAbs() {
        builderValidators = new ArrayList<>();
    }

    /**
     * The build method will construct the immutable object that the builder is for. It will only construct valid objects that conform to the
     * validation rules for the object.
     *
     * @return Constructed immutable object.
     *
     * @throws IllegalStateException Missing or invalid content is present in the builder.
     */
    public abstract T build() throws IllegalStateException;

    /**
     * Utility method that will reset all the values in the builder to the java standard defaults.
     */
    public abstract void reset();

    /**
     * Copies the values from the provided object into the builder. This includes the items that are unique to each object such as ID or creation
     * time. If you do not wish for those values to be copied use th {@link #setValues(Object)} method.
     *
     * @param object Object to populate builder values with.
     */
    public abstract void copyValues(T object);

    /**
     * Set the values from the provided object into the builder. This does not include object unique values such as ID or creation time. If you want
     * those values to be populated use the {@link #copyValues(Object)} method.
     *
     * @param object Object to populate builder values with.
     */
    public abstract void setValues(T object);

    /**
     * Adds the provided validator to the set of validators that are used to validate the content of the builder.
     *
     * @param builderValidator Validator to add to validation set.
     */
    protected void addValidator(final BuilderValidator builderValidator) {
        builderValidators.add(builderValidator);
    }

    /**
     * Utility method that will check that all the validation constraints on the object the builder is to build pass. If one or more constraint fails,
     * it will generate an <code>IllegalStateException</code>.
     *
     * @throws IllegalStateException The content of the builder failed validation
     */
    public void validate() throws IllegalStateException {
        List<String> errorMessages = performValidation();
        if (CollectionVerificationUtil.isNotEmpty(errorMessages)) {
            throw new IllegalStateException(String.join(ERROR_MESSAGE_DELIMITER, errorMessages));
        }
    }

    /**
     * Utility method that will check if the current state of the builder is valid.
     *
     * @return True if the content is valid, false if it is not.
     */
    public boolean isValid() {
        return CollectionVerificationUtil.isEmpty(performValidation());
    }

    /**
     * Utility to get all the current validation errors present in the content of the builder.
     *
     * @return String of all the current validation errors present in the builder.
     */
    public String getValidationErrors() {
        return String.join(ERROR_MESSAGE_DELIMITER, performValidation());
    }

    /**
     * Utility method that will perform the validation checks.
     *
     * @return List of validation error messages, or empty list if builder content is valid.
     */
    private List<String> performValidation() {
        List<String> errorMessages = new ArrayList<>();
        for (BuilderValidator builderValidator : builderValidators) {
            String validationResult = builderValidator.validate();
            if (StringVerificationUtil.isNotEmpty(validationResult)) {
                errorMessages.add(validationResult);
            }
        }
        return errorMessages;
    }
}