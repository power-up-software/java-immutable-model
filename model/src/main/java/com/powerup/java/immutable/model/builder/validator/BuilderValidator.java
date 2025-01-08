package com.powerup.java.immutable.model.builder.validator;

/**
 * A <code>BuilderValidator</code> is a utility that will perform a validation check on a parameter of a model object builder to ensure that the
 * content is valid. This ensures that the immutable form of a model object is always valid.
 *
 * @author Chris Picard
 */
public interface BuilderValidator {
    /**
     * Format used to generate an unset error message. Unset errors occur when a mandatory value is not set.
     */
    String UNSET_ERROR_MESSAGE_FORMAT = "%s must be set";
    /**
     * Format used to generate an "is set" error message.
     * "Is set" errors occur when a value is set when it should not be unset.
     */
    String IS_SET_ERROR_MESSAGE_FORMAT = "%s must not be set";
    /**
     * Format used to generate a "greater than equal to" error message.
     * Greater than equal to errors occur what a value is not greater than or equal to a provided value.
     */
    String GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT = "%s must be greater than equal to %s";
    /**
     * Format used to generate a "less than equal to" error message.
     * Less than equal to errors occur what a value is not less than or equal to a provided value.
     */
    String LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT = "%s must be less than equal to %s";

    /**
     * Performs the validation check on the builder parameter the validator is for.
     *
     * @return Empty string if valid, error message if invalid.
     */
    String validate();
}