package org.adt.core;

import org.adt.core.adt.GenericUtil.GenericStackUtil;
import org.adt.core.adt.implementation.normal.Queue;
import org.adt.core.adt.implementation.generic.GenericStack;

public class Ejercicio2a {

    public static void main(String[] args) {
        GenericStack stack = new GenericStack<>();

        Queue cola1 = new Queue();
        Queue cola2 = new Queue();

        cola1.add(1);
        cola1.add(2);
        cola1.add(3);
        cola1.add(4);

        stack.add(cola1);

        cola2.add(5);
        cola2.add(6);
        cola2.add(7);
        cola2.add(8);
        cola2.add(9);

        stack.add(cola2);

        System.out.println("El contenido de la pila es:");

        stack = GenericStackUtil.invertirStack(stack);

        int count = 1;
        while(!stack.isEmpty()) {
            Queue colatop =  (Queue) stack.top();
            System.out.println("El contenido de la cola " + count);
            count++;
            while(!colatop.isEmpty()) {
                System.out.println(colatop.getFirst());
                colatop.remove();
            }

            stack.remove();
        }

}
}
