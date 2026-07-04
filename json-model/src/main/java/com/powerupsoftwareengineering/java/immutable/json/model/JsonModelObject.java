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

package com.powerupsoftwareengineering.java.immutable.json.model;

import java.io.Serializable;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A <code>JsonModelObject</code> is the JSON representation of {@link com.powerupsoftwareengineering.java.immutable.model.ModelObjectAbs}.
 *
 * @author Chris Picard
 */
public abstract class JsonModelObject implements Serializable {

    private String id;

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     *         {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *         {@link String }
     *
     */
    public void setId(final String value) {
        this.id = value;
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
}
