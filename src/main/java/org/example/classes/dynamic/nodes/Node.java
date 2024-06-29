package org.example.classes.dynamic.nodes;

public class Node {

    private int value;
    private Node next;
    private Node back;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    public Node(int value, Node next, Node back) {
        this.value = value;
        this.next = next;
        this.back = back;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public Node getBack() {
        return back;
    }

    public void setBack(Node back) {
        this.back = back;
    }
}
