package org.example.classes;

import org.example.interfaces.iQueueBuilder;

public class QueueBuilder implements iQueueBuilder {

    int [] a;
    int i;

    // Constructor que recibe un numero variable de elementos
    public QueueBuilder(int[] elements) {
        a = new int[100];
        i = 0;
        for (int element : elements) {
            add(element);
        }
    }

    @Override
    public void add(int x) {
        if (i < a.length) {
            a[i] = x;
            i++;
        } else {
            throw new IllegalStateException("Queue is full");
        }
    }

    @Override
    public void remove() {
        if (i > 0) {
            for (int j = 0; j < i-1; j++) {
                a[j] = a[j+1];
            }
            i--;
        } else {
            throw new IllegalStateException("Queue is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return (i == 0);
    }

    @Override
    public int first() {
        if (i > 0) {
            return a[0];
        } else {
            throw new IllegalStateException("Queue is empty");
        }
    }

    public int size() {
        return i;
    }
}
