package org.example.classes;

import org.example.interfaces.iGenericQueue;;

public class GenericQueue<T> implements iGenericQueue<T> {

    private final T[] array;
    private int count = 0;

    public GenericQueue(final int capacity) {
        this.array = (T[]) new Object[capacity];
        this.count= 0;
    }


    @Override
    public void add(T element) {
        if (count == array.length) {
            throw new IllegalStateException("The queue is full");
        }
        this.array[this.count] = element;
        this.count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            System.out.println("Error: Cannot remove from an empty queue");
            return;
        }
        for (int i = 0; i < this.count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.count - 1] = null; // Helps garbage collection
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            System.out.println("Error: Cannot get the first element from an empty queue");
            return null;
        }
        return this.array[0];
    }
}
