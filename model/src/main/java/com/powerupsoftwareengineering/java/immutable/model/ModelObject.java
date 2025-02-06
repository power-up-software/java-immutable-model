/*
 * Copyright (c) Power Up Software Engineering LLC 2025.
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

package com.powerupsoftwareengineering.java.immutable.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * A <code>ModelObject</code> is any domain model object that models a piece of domain for an application. These items are unique items that are used
 * in the application object.
 *
 * @author Chris Picard
 */
@SuppressWarnings("unused")
public interface ModelObject extends Serializable {

    /**
     * Accessor for the id of the model object. The id is a globally unique value that is unique across the entire system.
     *
     * @return Globally unique id for the model object.
     */
    UUID getId();
}