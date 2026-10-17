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

package com.powerupsoftwareengineering.java.immutable.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ImmutableSet<I> implements Set<I> {
    private final Set<I> set;

    private ImmutableSet(final Set<I> set) {
        this.set = set;
    }

    private static <I> ImmutableSet<I> copyOf(Set<? extends I> items) {
        return new ImmutableSet<>(new HashSet<>(items));
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(final Object item) {
        return set.contains(item);
    }

    @Override
    public Iterator<I> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] array) {
        return set.toArray(array);
    }

    @Override
    public boolean add(final I Item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(final Object item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(final Collection<?> items) {
        return set.containsAll(items);
    }

    @Override
    public boolean addAll(final Collection<? extends I> items) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(final Collection<?> items) {
        return set.retainAll(items);
    }

    @Override
    public boolean removeAll(final Collection<?> items) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
