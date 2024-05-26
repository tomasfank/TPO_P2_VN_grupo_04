package org.example.classes;

import org.example.interfaces.iStackBuilder;

public class StackBuilder implements iStackBuilder {

    private final int[] array;
    private int count;

    public StackBuilder() {
        this.array = new int[100];
        this.count = 0;
    }

    @Override
    public void add(int x) {
        if (this.count < this.array.length) {
            this.array[this.count] = x;
            this.count++;
        } else {
            System.out.println("No se pueden agregar más elementos, la pila está llena.");
        }
    }

    @Override
    public void remove() {
        if(count == 0){
            System.out.println("No se puede desapilar una pila vacía.");
            return;
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getTop() {
        if(count == 0){
            System.out.println("No se puede obtener el tope de una pila vacía.");
            return -1;
        };
        return this.array[this.count - 1];
    }

    // Patrón Builder
    public static class Builder {
        private final StackBuilder stackBuilder;

        public Builder() {
            this.stackBuilder = new StackBuilder();
        }

        public Builder add(int x) {
            this.stackBuilder.add(x);
            return this;
        }

        public StackBuilder build() {
            return this.stackBuilder;
        }
    }

    // Método estático para obtener una instancia del Builder
    public static Builder builder() {
        return new Builder();
    }
}
