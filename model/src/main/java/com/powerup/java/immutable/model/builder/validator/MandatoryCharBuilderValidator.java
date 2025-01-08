package com.powerup.java.immutable.model.builder.validator;

import java.util.function.Supplier;

/**
 * A <code>MandatoryCharValidator</code> is a validator that validates if a mandatory char is set.
 * In this context set means not null and not equal to 0.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryCharBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the char parameter with will be checked to ensure it is set.
     */
    private final Supplier<Character> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryCharBuilderValidator(final String name, final Supplier<Character> valueSupplier) {
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
        Character value = valueSupplier.get();
        if (value == null || value == 0) {
            result = String.format(MandatoryObjectBuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}