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

package com.powerupsoftwareengineering.java.immutable.web.model.translator;

import com.powerupsoftwareengineering.java.immutable.jaxb.JaxbModelObject;
import com.powerupsoftwareengineering.java.immutable.model.ModelObjectAbs;
import java.util.UUID;

/**
 * The <code>ModelObjectTranslator</code> class is a translator that will convert model objects between the domain model and web model
 * representations.
 *
 * @author Chris Picard
 */
public final class ModelObjectTranslator {
    /**
     * Constructor made private for utility classes.
     */
    private ModelObjectTranslator() {
    }

    /**
     * Translates the fields from the web model object representation to the domain object representation.
     *
     * @param jaxbModelObject Web model object representation to be translated.
     * @param builder Builder for the domain object representation to be populated.
     */
    public static void fromXml(final JaxbModelObject jaxbModelObject, final ModelObjectAbs.Builder<?> builder) {
        if (jaxbModelObject.getId() != null) {
            builder.setId(UUID.fromString(jaxbModelObject.getId()));
        }
    }

    /**
     * Translates the fields from the domain model representation to the web model object representation.
     *
     * @param modelObject Domain model object representation to be translated.
     * @param jaxbModelObject Web object representation to be populated.
     */
    public static void toXml(final ModelObjectAbs modelObject, final JaxbModelObject jaxbModelObject) {
        jaxbModelObject.setId(modelObject.getId().toString());
    }
}