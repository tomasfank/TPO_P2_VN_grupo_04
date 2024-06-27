package org.example.exercises.ejercicio4;

import org.example.classes.QueueBuilder;
import org.example.classes.SetBuilder;
import org.example.classes.StackBuilder;


public class ejercicio4 {
        public static void main(String[] args) {
            pruebaConjuntos();
            pruebaPilas();
            pruebaQueue();
        }

       /*
       *
       *   Función para probar funcionalidad de la implementación del patrón Builder en pilas.
       *
       */
        public static void pruebaPilas(){
            StackBuilder nuevoStack = StackBuilder.builder()
                    .add(1)
                    .add(2)
                    .add(3)
                    .add(4)
                    .add(5)
                    .build();

            while (!nuevoStack.isEmpty()){
                System.out.println(nuevoStack.getTop());
                nuevoStack.remove();
            }
            System.out.println("Pila vacía.");
        }

        /*
        *
        *   Función para probar funcionalidad de la implementación del patrón Builder en conjuntos.
        *
        */
        public static void pruebaConjuntos(){
            SetBuilder nuevoSet = SetBuilder.builder()
                    .add(1)
                    .add(2)
                    .add(3)
                    .add(4)
                    .build();

            System.out.println("Elemento elegido: " + nuevoSet.choose());
            nuevoSet.remove(2);
            System.out.println("Elemento elegido después de remover 2: " + nuevoSet.choose());
        }

        /*
        *
        * Función para probar Queue con constructor de parámetros variable.
        *
        *
         */
    public static void pruebaQueue(){
        int[] elementos = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Inicializamos el array
        QueueBuilder queue = new QueueBuilder(elementos);
        System.out.println("Primer elemento: " + queue.first());
        System.out.println("Tamaño: " + queue.size());

        // Prueba de que funciona correctamente el Queue
        while (!queue.isEmpty()){
            System.out.println(queue.first());
            queue.remove();
        }
    }
}

