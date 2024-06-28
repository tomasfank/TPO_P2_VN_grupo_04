package org.example.classes;

import org.example.interfaces.iStackOfQueue;

public class StackOfQueue implements iStackOfQueue {
    private Queue[] a;
    private int i;

    public StackOfQueue() {
        a = new Queue[1000];
        i = 0;
    }

    @Override
    public void add(Queue x) {
        a[i] = x;
        i++;
    }

    @Override
    public void remove() {
        i--;
    }

    @Override
    public boolean isEmpty() {
        return (i == 0);
    }

    @Override
    public Queue top() {
        return a[i-1];
    }
}
