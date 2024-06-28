package org.example.classes;
import org.example.interfaces.iGenericSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class MultiSet<T> implements iGenericSet<T> {
    private Map<T, Integer> elements;

    public MultiSet() {
        elements = new HashMap<>();
    }

    @Override
    public void add(T element) {
        elements.put(element, elements.getOrDefault(element, 0) + 1);
    }

    @Override
    public void remove(T element) {
        if (elements.containsKey(element)) {
            int count = elements.get(element);
            if (count > 1) {
                elements.put(element, count - 1);
            } else {
                elements.remove(element);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public T choose() {
        if (isEmpty()) {
            throw new NoSuchElementException("The set is empty");
        }
        return elements.keySet().iterator().next();
    }

    @Override
    public boolean contains(T element) {
        return elements.containsKey(element);
    }

    // Método adicional para obtener la cantidad de un elemento específico
    public int count(T element) {
        return elements.getOrDefault(element, 0);
    }

    // Método para devolver el tamaño del conjunto
    public int size() {
        return elements.size();
    }

    // Método para obtener un iterador de todos los elementos (incluye repetidos)
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> entryIterator = elements.entrySet().iterator();
            private T currentElement;
            private int remainingCount = 0;

            @Override
            public boolean hasNext() {
                return remainingCount > 0 || entryIterator.hasNext();
            }

            @Override
            public T next() {
                if (remainingCount == 0) {
                    Map.Entry<T, Integer> entry = entryIterator.next();
                    currentElement = entry.getKey();
                    remainingCount = entry.getValue();
                }
                remainingCount--;
                return currentElement;
            }

            @Override
            public void remove() {
                if (remainingCount > 0) {
                    throw new IllegalStateException("Cannot remove during partial iteration of an element.");
                }
                entryIterator.remove();
            }
        };
    }
}

