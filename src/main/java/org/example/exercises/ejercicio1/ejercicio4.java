package org.example.exercises.ejercicio1;

import org.example.classes.SetBuilder;
import org.example.classes.StackBuilder;


public class ejercicio4 {
        public static void main(String[] args) {
            pruebaConjuntos();
            pruebaPilas();
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
}

