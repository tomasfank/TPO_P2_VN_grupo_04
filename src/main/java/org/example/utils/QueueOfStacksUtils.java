package org.example.utils;

import org.example.classes.QueueOfStacks;
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
        QueueOfStacks copy = new QueueOfStacks();
        QueueOfStacks aux = new QueueOfStacks();
        while (!qos.isEmpty()) {

            aux.add(StackUtils.copy(qos.getFirst()));
            copy.add(StackUtils.copy(qos.getFirst()));
            qos.remove();
        }
        while (!aux.isEmpty()) {
            qos.add(aux.getFirst());
            aux.remove();
        }
        return copy;
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
