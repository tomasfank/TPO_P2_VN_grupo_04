package org.example.exercises.ejercicio5MonteCarlo;

import org.example.classes.R2Point;
import org.example.classes.SetOfR2Points;

public class R2PointTestCasero {

    public static void testGetX() {
        R2Point point = new R2Point(3.0, 4.0);
        boolean testeo = Math.abs(3.0 - point.getX()) <= 0.001;
        if (testeo) {
            System.out.println("Salio' bien.");
        } else {
            System.out.println("Salio' mal.");
        }
    }

    public static void main(String[] args) {

        testGetX();
        R2Point p1 = new R2Point(3.0, 4.0);
        R2Point p2 = new R2Point(5.0, 7.0);
        R2Point p3 = new R2Point(11.0, 13.0);
        //p1.print();
        //p2.print();
        //p3.print();
        SetOfR2Points puntos = new SetOfR2Points();
        puntos.add(p1);
        puntos.add(p2);
        puntos.add(p3);
        puntos.add(p3);
        //puntos.remove(new R2Point(11.0, 13.0)
    }
}
