package org.example.classes;

import org.example.interfaces.iGenericPriorityQueue;

public class PriorityQueueEj7<T> implements iGenericPriorityQueue<T> {

    private final int max = 10000;
    private final T[] array;
    private final int[] priorities;
    private int count = 0;

    public PriorityQueueEj7() {
        this.array = (T[]) new Object[max];
        this.priorities = new int[this.array.length];
        this.count = 0;
    }

    @Override
    public void add(T element, int priority) {
        if (count == array.length) {
            throw new IllegalStateException("The priority queue is full");
        }
        int i;
        for (i = count - 1; i >= 0 && priority < priorities[i]; i--) {
            array[i + 1] = array[i];
            priorities[i + 1] = priorities[i];
        }
        array[i + 1] = element;
        priorities[i + 1] = priority;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty priority queue");
        }
        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
            priorities[i] = priorities[i + 1];
        }
        array[count - 1] = null;
        priorities[count - 1] = 0; // Helps garbage collection
        count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot get first element from an empty priority queue");
        }
        return this.array[count - 1];
    }

    @Override
    public int getPriority(T element) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(element)) {
                return priorities[i];
            }
        }
        throw new IllegalArgumentException("Element not found in priority queue");
    }

    // Método para cambiar la prioridad de un elemento manteniendo el orden relativo
    public void changePriority(T element, int newPriority) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (array[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Element not found in priority queue");
        }

        int originalPriority = priorities[index];
        priorities[index] = newPriority;

        if (newPriority > originalPriority) {
            // Mover hacia adelante
            for (int i = index; i > 0 && priorities[i] > priorities[i - 1]; i--) {
                swap(i, i - 1);
            }
        } else if (newPriority < originalPriority) {
            // Mover hacia atrás
            for (int i = index; i < count - 1 && priorities[i] < priorities[i + 1]; i++) {
                swap(i, i + 1);
            }
        }
    }

    // Método auxiliar para intercambiar elementos y prioridades
    private void swap(int i, int j) {
        T tempElement = array[i];
        int tempPriority = priorities[i];
        array[i] = array[j];
        priorities[i] = priorities[j];
        array[j] = tempElement;
        priorities[j] = tempPriority;
    }
}
