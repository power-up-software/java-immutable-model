package com.powerup.java.immutable.model;

public class FakeModelObjectBuilder extends ModelObjectAbs.Builder<FakeModelObject> {

    @Override
    public FakeModelObject build() {
        return new FakeModelObject(this);
    }
}
