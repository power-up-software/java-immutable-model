package com.powerup.java.immutable.model;

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
