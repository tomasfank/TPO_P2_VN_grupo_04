package org.example.exercises;

import org.example.classes.Stack;
import org.example.interfaces.iStack;

public class exercise_1 {

    public static void main(String[] args) {

        iStack nuevaPila = new Stack();

        int largo = 3;

        nuevaPila.init(largo);

        for (int i = 0; i < largo; i++) {
            nuevaPila.add(i+1);
        }
        while (!nuevaPila.isEmpty()){
            System.out.println(nuevaPila.top());
            nuevaPila.remove();
        }

    }

}
