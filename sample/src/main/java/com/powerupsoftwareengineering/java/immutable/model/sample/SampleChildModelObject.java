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

import com.powerupsoftwareengineering.java.immutable.model.builder.validator.MandatoryStringBuilderValidator;
import com.powerupsoftwareengineering.java.immutable.model.parameter.validator.HardLengthRestrictionStringParameterValidator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A <code>SampleChildModelObject</code> is a sample of a child class that uses a common parent which uses the immutable model object pattern. It
 * also contains an example of a hard length parameter validator.
 *
 * <p>This object is immutable. To modify use the object's builder class. You can use the @{link Builder#copyValues} method
 * to initialize the builder to the original values.
 *
 * @author Chris Picard
 */
public final class SampleChildModelObject extends SampleParentModelObject {
    /**
     * The max length of the object type.
     */
    public static final int TYPE_MAX_LENGTH = 256;
    /**
     * The type associated with the object.
     */
    private final String type;

    /**
     * Base constructor that will populate the <code>User</code> with the values from the provided builder.
     * This method is private to ensure that the builder is used to instantiate the class to ensure that all the checks are validated.
     *
     * @param builder Fully populated builder that has been validated.
     */
    private SampleChildModelObject(final Builder builder) {
        super(builder);
        this.type = builder.type;
    }

    /**
     * Accessor for the {@link #type} member variable.
     *
     * @return Current value of the {@link #type} member variable.
     */
    public String getType() {
        return type;
    }

// BEGIN_GENERATED_CODE

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SampleChildModelObject that = (SampleChildModelObject) o;

        return new EqualsBuilder()
                .append(type, that.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
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
    public static final class Builder extends SampleParentModelObject.Builder<SampleChildModelObject> {
        /**
         * Field name of the type field.
         */
        private static final String TYPE_FIELD_NAME = "Type";
        /**
         * Builder representation of {@link SampleChildModelObject#type}.
         */
        private String type;
        /**
         * Soft length validator for the name parameter.
         */
        private final HardLengthRestrictionStringParameterValidator typeParameterValidator;

        /**
         * Default constructor that will initialize the validators.
         */
        public Builder() {
            addValidator(new MandatoryStringBuilderValidator(TYPE_FIELD_NAME, this::getType));
            typeParameterValidator = new HardLengthRestrictionStringParameterValidator(TYPE_FIELD_NAME, TYPE_MAX_LENGTH);
        }

        @Override
        public SampleChildModelObject build() {
            validate();
            return new SampleChildModelObject(this);
        }

        @Override
        public void reset() {
            super.reset();
            type = null;
        }

        @Override
        public void copyValues(final SampleChildModelObject sampleParentModelObject) {
            super.copyValues(sampleParentModelObject);
            setValues(sampleParentModelObject);
        }

        @Override
        public void setValues(final SampleChildModelObject sampleParentModelObject) {
            super.setValues(sampleParentModelObject);
            this.type = sampleParentModelObject.getType();
        }

        /**
         * Accessor for the {@link SampleChildModelObject#type} member variable.
         *
         * @return Current value of the {@link SampleChildModelObject#type} member variable.
         */
        public String getType() {
            return type;
        }

        /**
         * Mutator for the {@link SampleChildModelObject#type} member variable.
         *
         * @param type New value of the {@link SampleChildModelObject#type} member variable.
         *
         * @throws IllegalArgumentException Provided string length is outside of {@link SampleChildModelObject#TYPE_MAX_LENGTH}
         */
        public void setType(final String type) {
            this.type = typeParameterValidator.validate(type);
        }
    }
}