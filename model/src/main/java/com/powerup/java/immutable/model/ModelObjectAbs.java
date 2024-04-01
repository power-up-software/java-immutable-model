package com.powerup.java.immutable.model;

import com.powerup.java.immutable.model.builder.BuilderAbs;
import java.io.Serial;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <code>ModelObjectAbs</code> is designed to serve as the parent class for {@link ModelObject}s. It contains all the common logic needed by model all
 * model objects.
 *
 * @author Chris Picard
 */
public abstract class ModelObjectAbs implements ModelObject {
    /**
     * The version ID of the serializable object.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * Globally unique id that identifies the model object on any system.
     */
    private final UUID id;

    /**
     * Base constructor that will populate the <code>ModelObjectAbs</code> with the values from the provided builder.
     * This method is protected to ensure that the class is immutable and always valid, but allow for child classes to extend it.
     *
     * @param builder Fully populated builder that has been validated.
     */
    protected ModelObjectAbs(final Builder<?> builder) {
        this.id = Objects.requireNonNullElseGet(builder.id, UUID::randomUUID);
    }

    /**
     * Accessor for the value of {@link #id}.
     *
     * @return Value of {@link #id}.
     */
    @Override
    public UUID getId() {
        return id;
    }

    // BEGIN_GENERATED_CODE

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    // END_GENERATED_CODE

    /**
     * The builder class provides the ability to populate all the values of a model object, validate the model object content, and provide an
     * immutable version of the model object.
     *
     * @param <T> The class the builder is constructing.
     */
    public abstract static class Builder<T extends ModelObjectAbs> extends BuilderAbs<T> {
        /**
         * Builder value for {@link ModelObjectAbs#id}.
         */
        private UUID id;

        @Override
        public void copyValues(final T modelObject) {
            this.id = modelObject.getId();
        }

        @Override
        public void setValues(final T modelObject) {
        }

        @Override
        public void reset() {
            id = null;
        }

        /**
         * Accessor for the value of {@link #id}.
         *
         * @return Value of {@link #id}.
         */
        public UUID getId() {
            return id;
        }

        /**
         * Mutator for the value of {@link ModelObjectAbs#id}.
         *
         * @param id New value of {@link ModelObjectAbs#id}.
         */
        public void setId(final UUID id) {
            this.id = id;
        }
    }
}
