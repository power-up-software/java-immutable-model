/*
 * Copyright (c) Power Up Software Engineering LLC 2026.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package com.powerupsoftwareengineering.java.immutable.model.sample;

import com.powerupsoftwareengineering.java.immutable.model.ModelObjectAbs;
import com.powerupsoftwareengineering.java.immutable.model.builder.validator.MandatoryStringBuilderValidator;
import com.powerupsoftwareengineering.java.immutable.model.parameter.validator.SoftLengthRestrictionStringParameterValidator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A <code>SampleParentModelObject</code> is a sample of a parent object that implements the immutable object pattern.
 *
 * <p>This object is immutable. To modify use the object's builder class. You can use the @{link Builder#copyValues} method
 * to initialize the builder to the original values.
 *
 * @author Chris Picard
 */
public abstract class SampleParentModelObject extends ModelObjectAbs {
    /**
     * The max length of the object's name.
     */
    public static final int NAME_MAX_LENGTH = 256;
    /**
     * The name of the object.
     */
    private final String name;

    /**
     * Base constructor that will populate the <code>SampleParentModelObject</code> with the values from the provided builder.
     * This method is protected to ensure that child classes can extend this class, but should not be called to instantiate the class.
     *
     * @param builder Fully populated builder that has been validated.
     */
    protected SampleParentModelObject(final Builder<?> builder) {
        super(builder);
        this.name = builder.name;
    }

    /**
     * Accessor for the {@link #name} member variable.
     *
     * @return Current value of the {@link #name} member variable.
     */
    public String getName() {
        return name;
    }

    // BEGIN_GENERATED_CODE

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SampleParentModelObject that = (SampleParentModelObject) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
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
     *
     * @param <T> The class the builder is constructing.
     */
    public abstract static class Builder<T extends SampleParentModelObject> extends ModelObjectAbs.Builder<T> {
        /**
         * Field name of the name field.
         */
        private static final String NAME_FIELD_NAME = "Name";
        /**
         * Builder representation of {@link SampleParentModelObject#name}.
         */
        private String name;
        /**
         * Soft length validator for the name parameter.
         */
        private final SoftLengthRestrictionStringParameterValidator nameParameterValidator;

        /**
         * Default constructor that will initialize the validators.
         */
        public Builder() {
            addValidator(new MandatoryStringBuilderValidator(NAME_FIELD_NAME, this::getName));
            nameParameterValidator = new SoftLengthRestrictionStringParameterValidator(NAME_FIELD_NAME, NAME_MAX_LENGTH);
        }

        @Override
        public void reset() {
            super.reset();
            name = null;
        }

        @Override
        public void copyValues(final T sampleParentModelObject) {
            super.copyValues(sampleParentModelObject);
            setValues(sampleParentModelObject);
        }

        @Override
        public void setValues(final T sampleParentModelObject) {
            super.setValues(sampleParentModelObject);
            this.name = sampleParentModelObject.getName();
        }

        /**
         * Accessor for the {@link SampleParentModelObject#name} member variable.
         *
         * @return Current value of the {@link SampleParentModelObject#name} member variable.
         */
        public String getName() {
            return name;
        }

        /**
         * Mutator for the {@link SampleParentModelObject#name} member variable.
         *
         * @param name New value of the {@link SampleParentModelObject#name} member variable.
         */
        public void setName(final String name) {
            this.name = nameParameterValidator.validate(name);
        }
    }
}