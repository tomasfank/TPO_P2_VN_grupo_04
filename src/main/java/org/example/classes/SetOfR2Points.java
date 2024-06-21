package org.example.classes;

import java.util.Arrays;
import java.util.Random;

public class SetOfR2Points {

    private final R2Point[] points;
    private int count;

    public SetOfR2Points() {
        this.points = new R2Point[10000];
        this.count = 0;
    }

    // Método para agregar un punto al conjunto
    public void add(R2Point p) {
        for (int i = 0; i < this.count; i++) {
            if (this.points[i].getX() == p.getX() && this.points[i].getY() == p.getY()) {
                return;  // El punto ya está en el conjunto
            }
        }
        this.points[this.count] = p;
        this.count++;
    }

    // Método para eliminar un punto del conjunto
    public void remove(R2Point p) {
        for (int i = 0; i < this.count; i++) {
            if (this.points[i].getX() == p.getX() && this.points[i].getY() == p.getY()) {
                if (i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.points[i] = this.points[this.count - 1];
                this.count--;
                return;
            }
        }
    }

    // Método para verificar si el conjunto está vacío
    public boolean isEmpty() {
        return this.count == 0;
    }

    // Método para elegir un punto aleatorio del conjunto
    public R2Point choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacío");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.points[randomIndex];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            points[i].print();
        }
    }

    public int size(){
        return this.count;
    }

    // Método equals para comparar dos conjuntos de puntos
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetOfR2Points that = (SetOfR2Points) o;
        if (count != that.count) return false;

        R2Point[] array1Copy = Arrays.copyOf(points, count);
        R2Point[] array2Copy = Arrays.copyOf(that.points, that.count);
        Arrays.sort(array1Copy, (p1, p2) -> {
            if (p1.getX() != p2.getX()) return Double.compare(p1.getX(), p2.getX());
            return Double.compare(p1.getY(), p2.getY());
        });
        Arrays.sort(array2Copy, (p1, p2) -> {
            if (p1.getX() != p2.getX()) return Double.compare(p1.getX(), p2.getX());
            return Double.compare(p1.getY(), p2.getY());
        });

        for (int i = 0; i < count; i++) {
            if (array1Copy[i].getX() != array2Copy[i].getX() || array1Copy[i].getY() != array2Copy[i].getY()) {
                return false;
            }
        }
        return true;
    }
*/
}

