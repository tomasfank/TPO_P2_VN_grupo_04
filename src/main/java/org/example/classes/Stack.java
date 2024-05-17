package org.example.classes;
// Importa iStack desde package interfaces
import org.example.interfaces.iStack;

public class Stack implements iStack {

    int [] a;
    int i;

    @Override
    public void init(int large) {
        a = new int[large];
        i = 0;
    }

    @Override
    public void add(int x) {
        a[i] = x;
        i++;
    }

    @Override
    public void remove() {
        i--;
    }

    @Override
    public boolean isEmpty() {
        return (i == 0);
    }

    @Override
    public int top() {
        return a[i-1];
    }
}
