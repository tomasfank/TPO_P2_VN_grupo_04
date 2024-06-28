package org.example.classes;

import org.example.interfaces.iSetBuilder;

import java.util.Random;
import java.util.Set;

public class SetBuilder implements iSetBuilder {

    private final int[]array;
    private int count;

    public SetBuilder(){
        this.array = new int[100];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        for (int i = 0; i < this.count; i++) {
            if  (this.array[i] == a){
                return;
            }
        }
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a){
                if (i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.array[i] = this.array[this.count - 1];
                this.count--;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0){
            System.out.println("No se puede elegir un elemento de un conjunto vacío.");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }

    // Patrón Builder para conjuntos.
    public static class Builder {
        private final SetBuilder setBuilder;

        public Builder() {
            this.setBuilder = new SetBuilder();
        }

        public Builder add(int a) {
            this.setBuilder.add(a);
            return this;
        }

        // A esto le faltan retoques.
        public Builder addAll(Set<Integer> set) {
            for (int element : set) {
                this.setBuilder.add(element);
            }
            return this;
        }

        public SetBuilder build() {
            return this.setBuilder;
        }
    }

    // Método estático para obtener una instancia del Builder
    public static Builder builder() {
        return new Builder();
    }
}
