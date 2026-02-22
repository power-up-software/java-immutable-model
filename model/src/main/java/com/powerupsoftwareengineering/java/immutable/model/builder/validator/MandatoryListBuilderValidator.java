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

package com.powerupsoftwareengineering.java.immutable.model.builder.validator;

import com.powerupsoftwareengineering.value.verification.util.CollectionVerificationUtil;
import java.util.List;
import java.util.function.Supplier;

/**
 * A <code>MandatoryListBuilderValidator</code> is a validator that validates if a mandatory list is set.
 * In this context, a set list is one that is not null and is not empty.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryListBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the string parameter to validate that it is set.
     */
    private final Supplier<List<?>> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryListBuilderValidator(final String name, final Supplier<List<?>> valueSupplier) {
        super(name);
        validateBuilder();
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
    }

    @Override
    public String validate() {
        String result = "";
        if (CollectionVerificationUtil.isNotEmpty(valueSupplier.get())) {
            result = String.format(UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}