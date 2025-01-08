package com.powerup.java.immutable.model.parameter.validator;

import org.apache.commons.lang3.StringUtils;

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
        if (StringUtils.isEmpty(name)) {
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