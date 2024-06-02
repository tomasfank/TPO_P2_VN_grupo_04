package org.example.utils;

import org.example.classes.QueueOfStacks;
import java.util.LinkedList;
import org.example.utils.StackUtils;
import org.example.interfaces.IQueueOfStacks;
import org.example.interfaces.iQueue;
import org.example.interfaces.iStack;
import org.example.classes.Queue;
import org.example.classes.Stack;

public class QueueOfStacksUtils {

    /*
    public static void print(IQueueOfStacks queueOrig) {
        QueueOfStacks queue = copy(queueOrig);

        while (!queue.isEmpty()) {
            System.out.println(queue.getFirst());
            queue.remove();
        }
    }
    */

    public static QueueOfStacks copy(QueueOfStacks qos) {
        // Análisis de complejidad
        // Supuesto: la matriz-cola-de-pilas es cuadrada.
        // O sea: N = dimensión de qos = cantidad de pilas en la cola =
        // = cantidad de elementos en cada pila.
        // C = constante que acota superiormente el tiempo de ejecución
        // de todas las instrucciones que tardan tiempo constante
        // CONCLUSIÓN: tarda O(N^2) + O(N^2) ~ O(N^2)
        QueueOfStacks copy = new QueueOfStacks(); // C
        QueueOfStacks aux = new QueueOfStacks(); // C
        while (!qos.isEmpty()) { // El ciclo se ejecuta N veces: N * (O(N)+O(N)+O(N - n_iteraciones)) =
                                 // = N * O(N) = O(N^2)
            aux.add(StackUtils.copy(qos.getFirst())); // La copia de cada pila es O(N)
            copy.add(StackUtils.copy(qos.getFirst())); // Idem: O(N)
            qos.remove(); // Tarda un tiempo ~ O(N - número de iteraciones
                          //                     del while hasta el momento) <= O(N)
        }
        while (!aux.isEmpty()) { // N veces:
            // Tiempo iteración 1 + Tiempo iter. 2 + ... + Tiempo iter. N =
            // = N + (N - 1) + (N - 2) + ... + 1 = La suma de Gauss =
            // = N*(N+1)/2 = N^2 + términos de grado menor ~ O(N^2)
            qos.add(aux.getFirst()); // C + C
            aux.remove(); // Tarda un tiempo ~ O(N - número de iteraciones
                          //                     del while hasta el momento) <= O(N)
        }
        return copy;
    }

        /**
         * Imprime por pantalla una matriz representada por una QueueOfStacks.
         *
         * @param queueOfStacks La QueueOfStacks que representa la matriz.
         */
        public static void printMatrix(QueueOfStacks queueOfStacks) {
            if (queueOfStacks == null || queueOfStacks.isEmpty()) {
                System.out.println("La matriz está vacía.");
                return;
            }
            QueueOfStacks copy = copy(queueOfStacks);

            // Crear una lista para almacenar las columnas (stacks)
            LinkedList<Stack> columns = new LinkedList<>();

            // Guardar los stacks en la lista de columnas
            while (!copy.isEmpty()) {
                Stack stack = copy.getFirst();
                columns.addFirst(stack); // Agregar al inicio para mantener el orden correcto
                copy.remove();
            }

            // Determinar el número de filas (la altura máxima de los stacks)
            int numRows = queueOfStacks.length();

            // Crear una matriz para almacenar los valores
            int[][] matrix = new int[numRows][columns.size()];

            // Rellenar la matriz con los valores de los stacks
            for (int col = 0; col < columns.size(); col++) {
                Stack stack = columns.get(col);
                StackUtils.revert(stack);
                for (int row = numRows - 1; row >= 0 && !stack.isEmpty(); row--) {
                    matrix[row][col] = stack.top();
                    stack.remove();
                }
            }

            // Imprimir la matriz
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < columns.size(); col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        }

        /*
    public static void revert(IQueue queue) {
        IStack aux = new Stack();
        while (!queue.isEmpty()) {
            aux.add(queue.getFirst());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getTop());
            aux.remove();
        }
    }

     */

}
