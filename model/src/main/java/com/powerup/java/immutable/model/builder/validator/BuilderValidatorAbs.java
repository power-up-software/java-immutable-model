package com.powerup.java.immutable.model.builder.validator;

import java.io.Serial;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

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

    protected void validateBuilder() throws IllegalArgumentException {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Name must be set.");
        }
    }
}
