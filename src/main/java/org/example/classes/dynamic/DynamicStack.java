package org.example.classes.dynamic;

import org.example.interfaces.iStack;
import org.example.classes.dynamic.nodes.Node;

import java.util.Objects;

public class DynamicStack implements iStack {

    private Node first;
    private int size;
    private final int capacity;

    // Constructor que recibe la capacidad máxima
    public DynamicStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public void add(int a) {
        if (size >= capacity) {
            throw new RuntimeException("No se puede apilar, la pila ha alcanzado su capacidad máxima");
        }
        this.first = new Node(a, this.first);
        size++;
    }
    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacía");
        }
        this.first = this.first.getNext();
        size--;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }


    // Método para obtener el tamaño actual de la pila
    public int getSize() {
        return size;
    }

    // Método para obtener la capacidad máxima de la pila
    public int getCapacity() {
        return capacity;
    }
}
