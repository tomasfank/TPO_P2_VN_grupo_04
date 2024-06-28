package org.example.classes;

//import org.example.definition.Dictionary;
import org.example.classes.GenericSet;

public class GenericStaticDictionary<K, V> {

    private static final int MAX = 10000;

    private Object[][] array;
    private int count;

    public GenericStaticDictionary() {
        this.array = new Object[MAX][2];
        this.count = 0;
    }


    public void add(K k, V v) {
        if (count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for (int i = 0; i < count; i++) {
            if (this.array[i][0].equals(k)) {
                this.array[i][1] = v;
                return;
            }
        }
        this.array[count] = new Object[2];
        this.array[count][0] = k;
        this.array[count][1] = v;
        this.count++;
    }


    public void remove(K k, V v) {
        for (int i = 0; i < count; i++) {
            if (this.array[i][0].equals(k)) {
                if (this.array[i][1].equals(v)) {
                    this.array[i] = this.array[count - 1];
                    count--;
                    return;
                }
                throw new RuntimeException("No existe el valor para la clave dada");
            }
        }
        throw new RuntimeException("No existe la clave");
    }

    public GenericSet<K> getKeys() {
        GenericSet<K> set = new GenericSet<>();
        for (int i = 0; i < count; i++) {
            set.add((K) this.array[i][0]);
        }
        return set;
    }

    public V get(K k) {
        for (int i = 0; i < count; i++) {
            if (this.array[i][0].equals(k)) {
                return (V) array[i][1];
            }
        }
        throw new RuntimeException("No existe un valor asociado a la clave");
    }
}
