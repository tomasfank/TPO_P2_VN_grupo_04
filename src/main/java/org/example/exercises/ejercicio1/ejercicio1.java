package org.example.exercises.ejercicio1;


import org.example.utils.StackUtils;
import org.example.classes.QueueOfStacks;
import org.example.utils.QueueOfStacksUtils;
import org.example.classes.Stack;

public class ejercicio1 {
    public static int trace(QueueOfStacks qos) {
        // Análisis de la complejidad.
        // Supuesto: la matriz-cola-de-pilas es cuadrada.
        // O sea: N = dimensión de qos = cantidad de pilas en la cola =
        // = cantidad de elementos en cada pila.
        // C = constante que acota superiormente el tiempo de ejecución
        // de todas las instrucciones que tardan tiempo constante
        // Conclusión: tarda O(N^2) + O(N^2) ~ O(N^2)
        QueueOfStacks copy = QueueOfStacksUtils.copy(qos); // O(N^2) tarda la copia
        int trace = 0; // C
        int N = copy.length(); // C
        int elem; // C
        Stack col; // C
        for (int col_ind = 0; col_ind < N; col_ind++){ // N veces.
            // Tiempo de ejecución iteración 1 + Tiempo de ejecución iteración 2 + ...
            // + Tiempo de ejecución iteración N =
            // O(N) + O(N-1) + O(N-2) + ... + O(1) = O(N*(N+1)/2) ~ O(N^2)
            col = copy.getFirst();
            copy.remove(); // O(N - col_ind)

            for (int row_ind = 0; row_ind <= N - 1 - col_ind; row_ind++){ // (N - col_ind) veces
                if (row_ind < N-1-col_ind){
                    col.remove(); // C
                }else{
                    elem = col.getTop(); // C
                    trace += elem; // C
                }
            }
        }
        return trace;

    }

    public static QueueOfStacks transpose(QueueOfStacks qos) {
        // Análisis de la complejidad.
        // Supuesto: la matriz-cola-de-pilas es cuadrada.
        // O sea: N = dimensión de qos = cantidad de pilas en la cola =
        // = cantidad de elementos en cada pila.
        // C = constante que acota superiormente el tiempo de ejecución
        // de todas las instrucciones que tardan tiempo constante
        // CONCLUSIÓN: El tiempo de ejecución es
        // O(N^2) + O(N) + O(N^3) ~ O(N^3)
        QueueOfStacks transpose = new QueueOfStacks(); // C
        QueueOfStacks copy = QueueOfStacksUtils.copy(qos); // O(N^2)
        Stack col, outcol; // C
        Stack colRev; // C
        int elem; // C
        int N = copy.length(); // C
        // Esta primera parte tarda O(N^2) + 5C ~ O(N^2)

        for (int i = 0; i < N; i++){ // N veces --> O(N)
            transpose.add(new Stack()); // C
        }

        for (int i = 0; i < N; i++){ // N veces --> N*(C+O(N-i)+O(N)+O(N^2)) ~
                                     // ~ N*O(N^2) ~ O(N^3)
            col = copy.getFirst(); // C
            copy.remove(); // O(N-i)
            StackUtils.revert(col); // O(N)
            while (!col.isEmpty()){ // N veces --> N*( O(N) + 5C) ~ N*O(N) ~ O(N^2)
                outcol = transpose.getFirst(); // C
                transpose.remove(); // O(N)
                elem = col.getTop(); // C
                outcol.add(elem); // C
                col.remove(); // C
                transpose.add(outcol); // C
            }
        }

        return transpose;
    }

    public static QueueOfStacks addMatrices(QueueOfStacks x, QueueOfStacks y){
        // Análisis de la complejidad.
        // Supuesto: las matrices-colas-de-pilas son cuadradas, y tienen el mismo tamaño.
        // O sea: N = dimensión de x (también de y) = cantidad de pilas en la cola =
        // = cantidad de elementos en cada pila.
        // C = constante que acota superiormente el tiempo de ejecución
        // de todas las instrucciones que tardan tiempo constante
        // CONCLUSIÓN: La complejidad es O(N^2) + O(N^2) + O(N^2) ~ O(N^2)
        QueueOfStacks a = QueueOfStacksUtils.copy(x); // O(N^2)
        QueueOfStacks b = QueueOfStacksUtils.copy(y); // O(N^2)
        QueueOfStacks c = new QueueOfStacks(); // C
        int N = a.length();
        for (int i = 0; i < N; i++){ // N veces
            // N veces * [O(N-i) + O(N-i) + 3C + O(N) + O(N)] ~
            // N * O(N) ~ O(N^2)
            Stack acol = a.getFirst(); // C
            Stack bcol = b.getFirst(); // C
            a.remove(); // O(N-i)
            b.remove(); // O(N-i)
            Stack ccol = new Stack(); // C

            int elem;
            while (!acol.isEmpty()){ // N veces --> O(N)
                elem = acol.getTop() + bcol.getTop(); // C + C + C
                acol.remove(); // C
                bcol.remove(); // C
                ccol.add(elem); // C
            }
            StackUtils.revert(ccol); // O(N)
            c.add(ccol); // C
        }
        return c;
    }



}
