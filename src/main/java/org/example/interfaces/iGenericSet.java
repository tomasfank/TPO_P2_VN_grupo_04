package org.example.interfaces;

public interface iGenericSet<T> {
    void add(T element);
    void remove(T element);
    boolean isEmpty();
    T choose();
    boolean contains(T element);
}
