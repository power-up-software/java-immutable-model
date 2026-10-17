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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class ImmutableList<I> implements List<I> {
    private final List<I> list;

    private ImmutableList(final List<I> list) {
        this.list = list;
    }

    private static <I> ImmutableList<I> copyOf(final Collection<? extends I> items) {
        List<I> noneNullItems = new ArrayList<>();
        items.forEach(item -> {
            if (item != null) {
                noneNullItems.add(item);
            }
        });
        return new ImmutableList<>(noneNullItems);

    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(final Object item) {
        return list.contains(item);
    }

    @Override
    public Iterator<I> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] array) {
        return list.toArray(array);
    }

    @Override
    public boolean add(final I item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(final Object item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(final Collection<?> items) {
        return list.containsAll(items);
    }

    @Override
    public boolean addAll(final Collection<? extends I> items) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends I> items) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(final Collection<?> items) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(final Collection<?> items) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(final Object object) {
        return list.equals(object);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public I get(final int index) {
        return null;
    }

    @Override
    public I set(final int index, final I item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(final int index, final I item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public I remove(final int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object item) {
        return list.indexOf(item);
    }

    @Override
    public int lastIndexOf(final Object item) {
        return list.lastIndexOf(item);
    }

    @Override
    public ListIterator<I> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<I> listIterator(final int index) {
        return list.listIterator(index);
    }

    @Override
    public List<I> subList(final int fromIndex, final int toIndex) {
        return list.subList(fromIndex, toIndex);
    }
}
