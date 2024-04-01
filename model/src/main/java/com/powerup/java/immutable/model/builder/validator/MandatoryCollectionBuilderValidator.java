package com.powerup.java.immutable.model.builder.validator;

import java.util.Collection;
import java.util.function.Supplier;
import org.apache.commons.collections4.CollectionUtils;

/**
 * A <code>MandatoryCollectionValidator</code> is a validator that validates if a mandatory collection is set. In this context a set collection is a
 * collection that has at least one value.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryCollectionBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the collection parameter to validate that it is set.
     */
    private final Supplier<Collection<?>> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryCollectionBuilderValidator(final String name, final Supplier<Collection<?>> valueSupplier) {
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
        if (CollectionUtils.isEmpty(valueSupplier.get())) {
            result = String.format(MandatoryObjectBuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}
