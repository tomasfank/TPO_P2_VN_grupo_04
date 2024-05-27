package org.adt.core.adt.definition;

public interface iGenericStack<T> {
    void add(T element);
    void remove();
    T top();
    boolean isEmpty();
    }


