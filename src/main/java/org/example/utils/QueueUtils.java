package org.example.utils;

//import org.example.interfaces.IQueue;
//import org.example.interfaces.IStack;
import org.example.classes.Queue;
import org.example.classes.Stack;

public class QueueUtils {

    public static void print(Queue queue) {
        Queue copy = copy(queue);
        while (!copy.isEmpty()) {
            System.out.println(copy.first());
            copy.remove();
        }
    }

    public static Queue copy(Queue queue) {
        Queue copy = new Queue();
        Queue aux = new Queue();
        while (!queue.isEmpty()) {
            aux.add(queue.first());
            copy.add(queue.first());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.first());
            aux.remove();
        }
        return copy;
    }

    public static void revert(Queue queue) {
        Stack aux = new Stack();
        while (!queue.isEmpty()) {
            aux.add(queue.first());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.top());
            aux.remove();
        }
    }

}