package org.example.exercises.ejercicio7;

import org.example.interfaces.iStack;
import org.example.classes.dynamic.DynamicStack;

public class ejercicio7 {
        public static void main(String[] args) {
            // Crear una pila con capacidad máxima de 3 elementos
            DynamicStack stack = new DynamicStack(3);

            // Apilar elementos
            stack.add(10);
            stack.add(20);
            stack.add(30);

            System.out.println("Tope: " + stack.getTop());
            System.out.println("Tamaño: " + stack.getSize());

            // Intentar apilar otro elemento debería lanzar una excepción
            try {
                stack.add(40);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());  // No se puede apilar, la pila ha alcanzado su capacidad máxima
            }

            // Desapilar un elemento
            stack.remove();
            System.out.println("Tope antes del pop: " + stack.getTop());
            System.out.println("Tamaño antes del pop: " + stack.getSize());
        }
    }


