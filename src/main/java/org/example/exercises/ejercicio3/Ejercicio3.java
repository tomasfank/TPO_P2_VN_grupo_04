package org.example.exercises.ejercicio3;

import org.example.classes.Queue;
import org.example.classes.QueueOfQueue;

public class Ejercicio3 {
    public static void main(String[] args) {
        Queue q1 = new Queue();
        Queue q2 = new Queue();
        Queue q3 = new Queue();

        QueueOfQueue qoq1 = new QueueOfQueue();

        Queue q4 = new Queue();
        Queue q5 = new Queue();
        Queue q6 = new Queue();

        QueueOfQueue qoq2 = new QueueOfQueue();

        q1.add(1);
        q1.add(2);
        q1.add(3);

        q2.add(4);
        q2.add(5);
        q2.add(6);

        q3.add(7);
        q3.add(8);
        q3.add(9);

        q4.add(10);
        q4.add(11);
        q4.add(12);

        q5.add(13);
        q5.add(14);
        q5.add(15);

        q6.add(16);
        q6.add(17);
        q6.add(18);

        qoq1.add(q1);
        qoq1.add(q2);
        qoq1.add(q3);

        qoq2.add(q4);
        qoq2.add(q5);
        qoq2.add(q6);

        //Ya creamos las QueuesOfQueues, ahora probamos los metodos creados. Cómo los métodos modifican las colas, lo testeamos de manera aislada.
        System.out.println("QueueOfQueue 1: " + qoq1.toString());
        System.out.println("QueueOfQueue 2: " + qoq2.toString());

        /**
        System.out.println("Testeamos el concatenado de qoq1 y qoq2:");
        System.out.println(qoq1.concatenate(qoq2).toString());
         **/

        /**
        System.out.println("Testeamos el flat de qoq1: ");
        System.out.println(qoq1.flat().toString());
        **/

        /**
        System.out.println("Testeamos el reverseWithDepth de qoq2: ");
        System.out.println(qoq2.toString());
        qoq2.reverseWithDepth();
        System.out.println(qoq2.toString());
        **/
    }


}
