package org.example.interfaces;

import org.example.classes.Queue;
import org.example.classes.QueueOfQueue;

public interface iQueueOfQueue {
    void add(Queue x);

    void remove();

    boolean isEmpty();

    Queue first();

    QueueOfQueue concatenate(QueueOfQueue... qoq);
    Queue flat();
    void reverseWithDepth();

}
