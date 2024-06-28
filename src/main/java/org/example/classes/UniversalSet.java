package org.example.classes;

import org.example.interfaces.iSuperSet;
import org.example.interfaces.iUniversalSet;

public class UniversalSet extends SuperSet implements iUniversalSet {

    @Override
    public boolean isSubset(iSuperSet subset) {
        if (subset.isEmpty()) {
            return true;
        }

        int subsetSize = getSize(subset);
        int[] subsetElements = getElements(subset, subsetSize);

        for (int i = 0; i < subsetSize; i++) {
            if (!contains(subsetElements[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public iSuperSet complement(iSuperSet subset) {
        if (!isSubset(subset)) {
            throw new RuntimeException("No se puede calcular el complemento de un conjunto que no es subconjunto del superconjunto");
        }

        SuperSet complementSet = new SuperSet();

        for (int i = 0; i < this.count; i++) {
            if (!containsInSet(subset, this.array[i])) {
                complementSet.add(this.array[i]);
            }
        }
        return complementSet;
    }

    // Método auxiliar para verificar si un conjunto contiene un elemento
    private boolean containsInSet(iSuperSet set, int element) {
        for (int i = 0; i < getSize(set); i++) {
            if (getElements(set, getSize(set))[i] == element) {
                return true;
            }
        }
        return false;
    }

    // Método auxiliar para verificar si el superconjunto contiene un elemento
    private boolean contains(int element) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == element) {
                return true;
            }
        }
        return false;
    }

    // Método auxiliar para obtener el tamaño de un conjunto
    private int getSize(iSuperSet set) {
        int size = 0;
        iSuperSet copy = copySet(set);
        while (!copy.isEmpty()) {
            copy.remove(copy.choose());
            size++;
        }
        return size;
    }

    // Método auxiliar para obtener los elementos de un conjunto
    private int[] getElements(iSuperSet set, int size) {
        int[] elements = new int[size];
        iSuperSet copy = copySet(set);
        for (int i = 0; i < size; i++) {
            elements[i] = copy.choose();
            copy.remove(elements[i]);
        }
        return elements;
    }

    // Método auxiliar para copiar un conjunto
    private iSuperSet copySet(iSuperSet set) {
        SuperSet copy = new SuperSet();
        int size = getSizeInternal(set);
        int[] elements = getElementsInternal(set, size);
        for (int element : elements) {
            copy.add(element);
        }
        return copy;
    }

    // Método auxiliar para obtener el tamaño de un conjunto sin modificarlo
    private int getSizeInternal(iSuperSet set) {
        int size = 0;
        iSuperSet copy = new SuperSet();
        while (!set.isEmpty()) {
            int element = set.choose();
            copy.add(element);
            set.remove(element);
            size++;
        }
        for (int i = 0; i < size; i++) {
            set.add(copy.choose());
            copy.remove(copy.choose());
        }
        return size;
    }

    // Método auxiliar para obtener los elementos de un conjunto sin modificarlo
    private int[] getElementsInternal(iSuperSet set, int size) {
        int[] elements = new int[size];
        iSuperSet copy = new SuperSet();
        for (int i = 0; i < size; i++) {
            int element = set.choose();
            copy.add(element);
            set.remove(element);
            elements[i] = element;
        }
        for (int i = 0; i < size; i++) {
            set.add(copy.choose());
            copy.remove(copy.choose());
        }
        return elements;
    }
}
