package org.example.classes;
// Importa iQueue desde package interfaces
import org.example.interfaces.iQueue;

public class Queue implements iQueue {

    int [] a;
    int i;

    @Override
    public void init() {
        a = new int[100];
        i = 0;
    }

    @Override
    public void add(int x) {
        a[i] = x;
        i++;
    }

    @Override
    public void remove() {
        for (int j = 0; j < i-1; j++) {
            a[j] = a[j+1];
        }
        i--;
    }

    @Override
    public boolean isEmpty() {
        return (i == 0);
    }

    @Override
    public int first() {
        return a[0];
    }
}
