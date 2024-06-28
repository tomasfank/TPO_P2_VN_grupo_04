package org.example.classes;
import org.example.interfaces.iGenericSet;

import java.util.Random;

public class GenericSet<T> implements iGenericSet<T>{
    private final T[] array;
    private int count;

    public GenericSet() {
        this.array = (T[]) new Object[10000];  // No se puede crear un array genérico directamente
        this.count = 0;
    }


    @Override
    public void add(T a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(a)) {
                return;
            }
        }
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove(T a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(a)) {
                if (i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.array[i] = this.array[this.count - 1];
                this.count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacío");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }

    @Override
    public boolean contains(T element) {
        int i = 0;
        while (i < this.count && this.array[i] != element){
            i++;
        }
        return (i<this.count);
    }
}

