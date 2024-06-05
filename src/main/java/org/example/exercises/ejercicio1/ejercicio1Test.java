package org.example.exercises.ejercicio1;

import org.example.exercises.ejercicio1.ejercicio1;
import org.example.classes.QueueOfStacks;
import org.example.classes.Stack;
import org.example.utils.QueueOfStacksUtils;


public class ejercicio1Test {

    public static void main(String[] args) {
        boolean testCaso1x1 = false;

        QueueOfStacks qos = new QueueOfStacks();
        Stack s1 = new Stack();
        s1.add(9);
        s1.add(6);
        s1.add(3);
        qos.add(s1);

        Stack s2 = new Stack();
        s2.add(8);
        s2.add(5);
        s2.add(2);
        qos.add(s2);

        Stack s3 = new Stack();
        s3.add(7);
        s3.add(4);
        s3.add(1);
        qos.add(s3);

        if (testCaso1x1) {
            // Test de caso critico: matriz de 1x1.
            qos.remove();
            qos.remove();
            qos.remove();
            Stack s4 = new Stack();
            s4.add(7);
            qos.add(s4);
        }



        int traza = ejercicio1.trace(qos);
        int n = qos.length();

        System.out.println("La traza de qos: " + String.valueOf(traza));
        //QueueOfStacks traspuesta = ejercicio1.transpose(qos);
        QueueOfStacks suma = ejercicio1.addMatrices(qos, qos);
        System.out.println("La matriz qos:");
        QueueOfStacksUtils.printMatrix(qos);
        System.out.println();
        System.out.println("La traspuesta de qos:");
        QueueOfStacksUtils.printMatrix(ejercicio1.transpose(qos));
        System.out.println();
        System.out.println("La suma de qos consigo misma:");
        QueueOfStacksUtils.printMatrix(suma);


    }
}
