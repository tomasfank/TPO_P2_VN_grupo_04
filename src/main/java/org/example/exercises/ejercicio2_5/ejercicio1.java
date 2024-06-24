package org.example.exercises.ejercicio2_5;
import org.example.classes.GenericSet;
import org.example.classes.GenericStack;

public class ejercicio1 {
    public static void main(String[] args) {
        GenericStack stackDesordenado = new GenericStack();
        GenericSet Set = new GenericSet();
        GenericStack StackOrdenada = new GenericStack();
        stackDesordenado.add(1);
        stackDesordenado.add(2);
        stackDesordenado.add(3);
        stackDesordenado.add(4);
        stackDesordenado.add(5);
        stackDesordenado.add(6);
        stackDesordenado.add(1);
        stackDesordenado.add(2);
        stackDesordenado.add(5);

        while (!stackDesordenado.isEmpty()) {
            Set.add(stackDesordenado.top());
            stackDesordenado.remove();
        }

        while(!Set.isEmpty()){
            int elemento = (int) Set.choose();
            StackOrdenada.add(elemento);
            Set.remove(elemento);
        }

        GenericStack saux = new GenericStack();
        GenericStack saux2 = new GenericStack();

        while(!StackOrdenada.isEmpty()){
            int tmp = (int) StackOrdenada.top();
            StackOrdenada.remove();

            while (!saux.isEmpty() && (int) saux.top() > tmp){
                StackOrdenada.add(saux.top());
                saux.remove();
            }

            saux.add(tmp);


        }

        while(!saux.isEmpty()){
            System.out.println(saux.top());
            saux.remove();
        }


    }

}

