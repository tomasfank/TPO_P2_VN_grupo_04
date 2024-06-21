package org.example.exercises.ejercicio5MonteCarlo;

import org.example.classes.R2Point;

import java.util.Random;

public class CalculadoraPi {

    public static void main(String[] args) {

        Montecarlo unCuarto = new Montecarlo();
        R2Point p;
        Random random = new Random();
        int simulationSize = 0;
        while (unCuarto.cantidadPuntos() < 10000){
            p = new R2Point(random.nextDouble(), random.nextDouble());
            //p.print();
            unCuarto.testPoint(p);
            simulationSize++;
        }
        System.out.println("Al final, la cantidad de iteraciones que se hicieron fueron: " + simulationSize);
        double pi = (double) unCuarto.cantidadPuntos() / (double) simulationSize;
        System.out.println("El numero pi aproximado es: " + (4.0 * pi));
    }
}
