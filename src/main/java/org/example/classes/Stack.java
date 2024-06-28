package org.example.classes;
// Importa iStack desde package interfaces
import org.example.interfaces.iStack;

public class Stack implements iStack {

    private int[] a;
    private int i;

    // No hay que usar @Override aca: la interfaz creo que no debería
    // tener un constructor. Sólo las implementaciones concretas de la
    // interfaz (como la clase Stack) lo tienen.
    // Borre' el "void" delante del constructor, porque si no, no funciona..
    // En general los constructores en java parece que no deben tener un tipo
    // de dato de retorno.
    // Simplifiquemonos la vida, fijando el tamanio de los Stacks no-dinamicos.
    public Stack() {
        a = new int[1000];
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
    public int getTop() {
        return a[i-1];
    }
}
