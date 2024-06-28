package org.example.exercises.ejercicio2_5;
import org.example.classes.GenericSet;
import org.example.classes.GenericStack;

public class ejercicio1 {

    public static void main(String[] args) {
        GenericStack stackDesordenado = new GenericStack();
        GenericSet set = new GenericSet();
        GenericStack stackOrdenada = new GenericStack();

        stackDesordenado.add(1);
        stackDesordenado.add(2);
        stackDesordenado.add(3);
        stackDesordenado.add(4);
        stackDesordenado.add(5);
        stackDesordenado.add(6);
        stackDesordenado.add(1);
        stackDesordenado.add(2);
        stackDesordenado.add(5);

        ordenarYImprimir(stackDesordenado, set, stackOrdenada);
    }

    public static void ordenarYImprimir(GenericStack stackDesordenado, GenericSet set, GenericStack stackOrdenada) {
        while (!stackDesordenado.isEmpty()) { // N_1
            set.add(stackDesordenado.top()); // C_1
            stackDesordenado.remove(); // C_2
        }

        while (!set.isEmpty()) { // N_2
            int elemento = (int) set.choose(); // C_3
            stackOrdenada.add(elemento); // C_4
            set.remove(elemento); // C_5
        }

        GenericStack saux = new GenericStack(); // C_6

        while (!stackOrdenada.isEmpty()) { // N_3
            int tmp = (int) stackOrdenada.top(); // C_7
            stackOrdenada.remove(); // C_8

            while (!saux.isEmpty() && (int) saux.top() > tmp) { // N_4
                stackOrdenada.add(saux.top()); // C_9
                saux.remove(); // C_10
            }

            saux.add(tmp); // C_11
        }

        while (!saux.isEmpty()) { // N_5
            System.out.println(saux.top()); // C_12
            saux.remove(); // C_13
        }
    }
    // O(N1×(C1+C2)+N2×(C3+C4+C5)+N3×(C7+C8+N4×(C9+C10)+C11)+N5×(C12+C13))

    // = O(n`2)
}
