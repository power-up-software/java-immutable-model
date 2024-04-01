package com.powerup.java.immutable.model.builder.validator;

import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;

/**
 * A <code>MandatoryStringValidator</code> is a validator that validates if a mandatory string is set. In this context a set string is one that is not
 * null and is not empty.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryStringBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the string parameter to validate that it is set.
     */
    private final Supplier<String> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryStringBuilderValidator(final String name, final Supplier<String> valueSupplier) {
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
        if (StringUtils.isEmpty(valueSupplier.get())) {
            result = String.format(MandatoryObjectBuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}
