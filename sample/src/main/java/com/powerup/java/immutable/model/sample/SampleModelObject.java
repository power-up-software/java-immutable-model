package com.powerup.java.immutable.model.sample;

import com.powerup.java.immutable.model.ModelObjectAbs;
import com.powerup.java.immutable.model.builder.validator.MandatoryIntBuilderValidator;
import com.powerup.java.immutable.model.builder.validator.MandatoryStringBuilderValidator;
import com.powerup.java.immutable.model.parameter.validator.SoftLengthRestrictionStringParameterValidator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A <code>SampleModelObject</code> is a sample model object designed to show how to use the Immutable model object functionality. It features use of
 * both build and parameter validators. For parameter validators it uses the soft length filter. See {@link SampleChildModelObject} for an example of
 * the hard length filter.
 *
 * <p>This object is immutable. To modify use the object's builder class. You can use the @{link Builder#copyValues} method
 * to initialize the builder to the original values.
 *
 * @author Chris Picard
 */
public final class SampleModelObject extends ModelObjectAbs {
    /**
     * The max length of the object.
     */
    public static final int NAME_MAX_LENGTH = 256;
    /**
     * The name of the object.
     */
    private final String name;
    /**
     * The email address of the user which is used to identify the user.
     */
    private final int order;

    /**
     * Base constructor that will populate the <code>User</code> with the values from the provided builder.
     * This method is private to ensure that the builder is used to instantiate the class to ensure that all the checks are validated.
     *
     * @param builder Fully populated builder that has been validated.
     */
    private SampleModelObject(final Builder builder) {
        super(builder);
        this.name = builder.name;
        this.order = builder.order;
    }

    /**
     * Accessor for the {@link #name} member variable.
     *
     * @return Current value of the {@link #name} member variable.
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor for the {@link #order} member variable.
     *
     * @return Current value of the {@link #order} member variable.
     */
    public int getOrder() {
        return order;
    }

    // BEGIN_GENERATED_CODE

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SampleModelObject that = (SampleModelObject) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .append(order, that.order)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(order)
                .toHashCode();
    }

    @SuppressWarnings("RedundantMethodOverride")
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    // END_GENERATED_CODE

    /**
     * The builder class provides the ability to populate all the values of a model object, validate if the model object content, and provide an
     * immutable version of the model object.
     */
    public static final class Builder extends ModelObjectAbs.Builder<SampleModelObject> {
        /**
         * Field name of the name field.
         */
        private static final String NAME_FIELD_NAME = "Name";
        /**
         * Builder representation of {@link SampleModelObject#name}.
         */
        private String name;
        /**
         * Builder representation of {@link SampleModelObject#order}.
         */
        private int order;
        /**
         * Soft length validator for the name parameter.
         */
        private final SoftLengthRestrictionStringParameterValidator nameParameterValidator;

        /**
         * Default constructor that will initialize the validators.
         */
        public Builder() {
            addValidator(new MandatoryStringBuilderValidator(NAME_FIELD_NAME, this::getName));
            addValidator(new MandatoryIntBuilderValidator("Order", this::getOrder));
            nameParameterValidator = new SoftLengthRestrictionStringParameterValidator(NAME_FIELD_NAME, NAME_MAX_LENGTH);
        }

        @Override
        public SampleModelObject build() {
            validate();
            return new SampleModelObject(this);
        }

        @Override
        public void reset() {
            super.reset();
            name = null;
            order = 0;
        }

        @Override
        public void copyValues(final SampleModelObject sampleModelObject) {
            super.copyValues(sampleModelObject);
            setValues(sampleModelObject);
        }

        @Override
        public void setValues(final SampleModelObject sampleModelObject) {
            super.setValues(sampleModelObject);
            this.name = sampleModelObject.getName();
            this.order = sampleModelObject.getOrder();
        }

        /**
         * Accessor for the {@link SampleModelObject#name} member variable.
         *
         * @return Current value of the {@link SampleModelObject#name} member variable.
         */
        public String getName() {
            return name;
        }

        /**
         * Mutator for the {@link SampleModelObject#name} member variable.
         *
         * @param name New value of the {@link SampleModelObject#name} member variable.
         */
        public void setName(final String name) {
            this.name = nameParameterValidator.validate(name);
        }

        /**
         * Accessor for the {@link SampleModelObject#order} member variable.
         *
         * @return Current value of the {@link SampleModelObject#order} member variable.
         */
        public int getOrder() {
            return order;
        }

        /**
         * Mutator for the {@link SampleModelObject#order} member variable.
         *
         * @param order New value of the {@link SampleModelObject#order} member variable.
         */
        public void setOrder(final int order) {
            this.order = order;
        }
    }
}
