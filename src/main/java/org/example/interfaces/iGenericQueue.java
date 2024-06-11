package org.adt.core.adt.definition;

public interface iGenericQueue<T> {
    void add(T element);
    void remove();
    boolean isEmpty();
    T getFirst();
}
