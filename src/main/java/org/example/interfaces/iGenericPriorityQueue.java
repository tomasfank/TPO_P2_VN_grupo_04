package org.example.interfaces;

public interface iGenericPriorityQueue<T> {
    void add (T element, int priority);
    void remove();
    boolean isEmpty();
    T getFirst();
    int getPriority(T Element);
}
