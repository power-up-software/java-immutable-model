package com.powerup.java.immutable.model.builder.validator;

import java.util.function.Supplier;

/**
 * A <code>MandatoryObjectValidator</code> is a validator that validates if a mandatory object is set. If there is a more specific validator for an
 * object such as a collection or string, those validators should be used instead.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryObjectBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the object parameter to validate that it is set.
     */
    private final Supplier<Object> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryObjectBuilderValidator(final String name, final Supplier<Object> valueSupplier) {
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
        if (valueSupplier.get() == null) {
            result = String.format(UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}
