package org.example.classes;
// Importa iQueue desde package interfaces
import java.util.Arrays;
import org.example.interfaces.iQueue;

public class Queue implements iQueue {

    int [] a;
    int i;

    public Queue() {
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
    public String toString(){
        // Usamos StringBuilder para construir la cadena de salida de manera eficiente
        StringBuilder sb = new StringBuilder("Queue{");

        // Iteramos sobre el array hasta el índice i para incluir solo los elementos relevantes
        for (int j = 0; j < i; j++) {
            sb.append(a[j]);
            if (j < i - 1) {
                sb.append(", "); // Agrega una coma y espacio entre los elementos
            }
        }

        sb.append("}");
        return sb.toString(); // Retorna la cadena construida
    }

    public int size() { return i;}
}
