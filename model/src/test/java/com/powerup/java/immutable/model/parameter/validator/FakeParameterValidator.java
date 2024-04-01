package com.powerup.java.immutable.model.parameter.validator;

@SuppressWarnings("unused")
public class FakeParameterValidator extends ParameterValidatorAbs<String> {

    public FakeParameterValidator(final String name) {
        super(name);
    }

    @Override
    public String validate(final String value) throws IllegalArgumentException {
        return null;
    }
}
