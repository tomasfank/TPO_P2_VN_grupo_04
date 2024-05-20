package org.example.classes;

import org.example.interfaces.IQueueOfStacks;

public class QueueOfStacks implements IQueueOfStacks {

    private final Stack[] array;
    private int count;

    public QueueOfStacks() {
        this.array = new Stack[1000];
        this.count = 0;
    }

    @Override
    public void add(Stack a) {
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desacolar una cola vacia");
            return;
        }
        for (int i = 0; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Stack getFirst() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
            Stack answer = new Stack();
            return answer;
        }
        return this.array[0];
    }

    public int length(){
        return this.count;
    }
}
