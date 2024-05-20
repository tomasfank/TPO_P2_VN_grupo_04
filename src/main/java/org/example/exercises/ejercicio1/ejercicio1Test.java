package org.example.exercises.ejercicio1;

import org.example.exercises.ejercicio1.ejercicio1;
import org.example.classes.QueueOfStacks;
import org.example.classes.Stack;


public class ejercicio1Test {

    public static void main(String[] args) {
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

        /*
         // Test de caso critico: matriz de 1x1.
         qos.remove();
         qos.remove();
         qos.remove();
         Stack s4 = new Stack();
         s4.add(7);
         qos.add(s4);
        */


        int traza = ejercicio1.trace(qos);
        int n = qos.length();
        //QueueOfStacks traspuesta = QueueOfStacksAlgos.transpose(qos);
        System.out.println("The trace of the Queue of Stacks is " + String.valueOf(traza));
        /*
        for (int i = 0; i < n; i++){
            Stack col = traspuesta.getFirst();
            traspuesta.remove();
            //System.out.print("La columna " + String.valueOf(n-i) + " de la traspuesta es: ");
            StackAlgorithms.print(col);
        }
        int nT = traspuesta.length();
        System.out.println("La traspu esta tiene " + nT + " columnas");
        Stack col = traspuesta.getFirst();
        traspuesta.remove();
        System.out.println("Primera columna de la traspuesta (deberia ser [7 8 9], de arriba a abajo):");
        while (!col.isEmpty()){
            System.out.println(String.valueOf(col.getTop()));
            col.remove();
        }*/


    }
}
