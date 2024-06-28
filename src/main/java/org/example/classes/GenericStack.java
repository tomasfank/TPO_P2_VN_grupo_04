package org.example.classes;

import org.example.interfaces.iGenericStack;;

public class GenericStack<T> implements iGenericStack<T> {

    private final int max = 1000;
    private final T[] array;
    private int count;

    public GenericStack() {
        array = (T[]) new Object[max]; // Corregido: max no debe estar dentro de los paréntesis
        count = 0;
    }

    @Override
    public void add(T element) {
        array[count++] = element;
    }

    @Override
    public void remove() {
        array[--count] = null;
    }

    @Override
    public T top() {
        return array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
