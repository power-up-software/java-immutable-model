package com.powerup.java.immutable.model.builder.validator;

public class FakeBuilderValidator extends BuilderValidatorAbs {
    public FakeBuilderValidator(final String name) {
        super(name);
    }

    @Override
    public String validate() {
        return null;
    }
}
