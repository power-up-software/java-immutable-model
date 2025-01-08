package com.powerup.java.immutable.model.builder.validator;

import java.util.function.Supplier;

/**
 * A <code>MandatoryDoubleValidator</code> is a validator that validates if a mandatory double is set.
 * In this context set means not null and not equal to 0.0.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryDoubleBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the double parameter to validate that it is set.
     */
    private final Supplier<Double> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryDoubleBuilderValidator(final String name, final Supplier<Double> valueSupplier) {
        super(name);
        validateBuilder();
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
    }

    @Override
    public String validate() {
        String result = "";
        Double value = valueSupplier.get();
        if (value == null || value == 0.0) {
            result = String.format(MandatoryObjectBuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}