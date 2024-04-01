package com.powerup.java.immutable.model.parameter.validator;

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
