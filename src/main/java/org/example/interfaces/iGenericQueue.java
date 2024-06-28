package org.example.interfaces;

public interface iGenericQueue<T> {
    void add(T element);
    void remove();
    boolean isEmpty();
    T getFirst();
}
