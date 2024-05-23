package org.example.utils;

import org.example.interfaces.iStack;
import org.example.classes.Stack;

public class StackUtils {

    public static void print(iStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.top());
            stack.remove();
        }
    }

    public static Stack copy(Stack stack) {
        Stack copy = new Stack();
        Stack aux = new Stack();
        while (!stack.isEmpty()) {
            aux.add(stack.top());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            stack.add(aux.top());
            copy.add(aux.top());
            aux.remove();
        }
        return copy;
    }

    public static void revert(iStack stack) {
        iStack aux = new Stack();
        iStack aux2 = new Stack();
        while (!stack.isEmpty()) {
            aux.add(stack.top());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            aux2.add(aux.top());
            aux.remove();
        }
        while (!aux2.isEmpty()) {
            stack.add(aux2.top());
            aux2.remove();
        }
    }

}
