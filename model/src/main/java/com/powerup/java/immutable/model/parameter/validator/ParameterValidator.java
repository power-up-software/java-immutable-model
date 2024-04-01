package com.powerup.java.immutable.model.parameter.validator;

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
