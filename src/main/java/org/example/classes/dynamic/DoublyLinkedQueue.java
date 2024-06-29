package org.example.classes.dynamic.nodes;
import org.example.interfaces.iGenericQueue;

public class DoublyLinkedQueue implements iGenericQueue<Integer> {
    private Node first;
    private Node last;

    @Override
    public void add(Integer element) {
        Node newNode = new Node(element, null, last);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            first = first.getNext();
            if (first != null) {
                first.setBack(null);
            } else {
                last = null;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Integer getFirst() {
        if (!isEmpty()) {
            return first.getValue();
        }
        return null;
    }
    public Node getFirstNode() {
        return this.first;
    }
    public Node getLastNode() {
        return this.last;
    }
}

