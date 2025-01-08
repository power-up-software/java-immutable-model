package com.powerup.java.immutable.model.builder.validator;

import java.util.function.Supplier;

/**
 * A <code>IntGreaterThanEqualToValidator</code> is a validator that validates if a parameter is greater than or equal to the provided value.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class IntGreaterThanEqualToBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the int parameter to validate that it is greater than or equal to the min value.
     */
    private final Supplier<Integer> valueSupplier;
    /**
     * The min value to validate if the parameter is greater than or equal to.
     */
    private final int minValue;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     * @param minValue Value of {@link #minValue}.
     */
    public IntGreaterThanEqualToBuilderValidator(final String name, final Supplier<Integer> valueSupplier, final int minValue) {
        super(name);
        validateBuilder();
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
        this.minValue = minValue;
    }

    @Override
    public String validate() {
        String result = "";
        Integer value = valueSupplier.get();
        if (value != null && value < minValue) {
            result = String.format(GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, getName(), minValue);
        }
        return result;
    }
}