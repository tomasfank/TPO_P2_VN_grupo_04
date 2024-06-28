package org.example.utils;

import org.example.interfaces.iStack;
import org.example.classes.Stack;

public class StackUtils {

    public static void print(iStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
    }

    public static Stack copy(Stack stack) {
        // Análisis de complejidad
        // N = cantidad de elementos de stack.
        // C = constante que acota superiormente el tiempo de
        // ejecución de todas las instrucciones que tardan un
        // tiempo constante.
        // Resumen: Este método tiene una complejidad O(N)
        // por el análisis línea por línea más abajo.
        Stack copy = new Stack(); // C
        Stack aux = new Stack(); // C
        while (!stack.isEmpty()) { // N veces --> 3*C*N ~ O(N)
            aux.add(stack.getTop()); // C + C = 2*C
            stack.remove(); // C
        }
        while (!aux.isEmpty()) { // N veces --> 5*C*N ~ O(N)
            stack.add(aux.getTop()); // C + C
            copy.add(aux.getTop()); // C + C
            aux.remove(); // C
        }
        return copy;
    }

    /**
     * Este método invierte el orden de los elementos en la pila dada.
     *
     * @param stack La pila que se va a invertir. Después de llamar a este método, los elementos en la pila
     * estarán en el orden inverso.
     *
     * La modificación de la pila es *in situ*. No devuelve una copia de la pila
     * pero con los elementos invertidos.
     */
    public static void revert(iStack stack) {
        // Análisis de la complejidad
        // N = cantidad de elementos del stack
        // CONCLUSIÓN: Tarda O(N) + O(N) + O(N) ~ O(N)
        iStack aux = new Stack(); // C
        iStack aux2 = new Stack(); // C
        while (!stack.isEmpty()) { // N veces --> N*3C ~ O(N)
            aux.add(stack.getTop()); // C + C
            stack.remove(); // C
        }
        while (!aux.isEmpty()) { // N veces --> N*3C ~ O(N)
            aux2.add(aux.getTop()); // C + C
            aux.remove(); // C
        }
        while (!aux2.isEmpty()) { // Idem: O(N)
            stack.add(aux2.getTop());
            aux2.remove();
        }
    }

}
