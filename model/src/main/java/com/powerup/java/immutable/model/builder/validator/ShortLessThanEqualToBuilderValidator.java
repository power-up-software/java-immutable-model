package com.powerup.java.immutable.model.builder.validator;

import java.util.function.Supplier;

/**
 * A <code>ShortLessThanEqualToValidator</code> is a validator that validates if a parameter is less than or equal to the provided value.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class ShortLessThanEqualToBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the short parameter to validate that it is less than or equal to the max value.
     */
    private final Supplier<Short> valueSupplier;
    /**
     * The max value to validate if the parameter is less than or equal to.
     */
    private final short maxValue;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     * @param maxValue Value of {@link #maxValue}.
     */
    public ShortLessThanEqualToBuilderValidator(final String name, final Supplier<Short> valueSupplier, final short maxValue) {
        super(name);
        validateBuilder();
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
        this.maxValue = maxValue;
    }

    @Override
    public String validate() {
        String result = "";
        Short value = valueSupplier.get();
        if (value != null && value > maxValue) {
            result = String.format(LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, getName(), maxValue);
        }
        return result;
    }
}
