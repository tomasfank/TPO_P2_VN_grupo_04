package org.example.exercises.ejercicio6;
import org.example.classes.MultiSet;

import java.util.Iterator;

public class Ejercicio6_4 {

    public static void main(String[] args) {
        testAdd();
        testRemove();
        testContains();
        testIsEmpty();
        testChoose();
        testCount();
        testIterator();
    }

    public static void testAdd() {
        MultiSet<String> multiSet = new MultiSet<>();
        multiSet.add("apple");
        multiSet.add("banana");
        multiSet.add("apple");

        System.out.println("Test Add:");
        System.out.println("Expected: 2, Actual: " + multiSet.count("apple"));
        System.out.println("Expected: 1, Actual: " + multiSet.count("banana"));
        System.out.println();
    }

    public static void testRemove() {
        MultiSet<String> multiSet = new MultiSet<>();
        multiSet.add("apple");
        multiSet.add("apple");
        multiSet.remove("apple");

        System.out.println("Test Remove:");
        System.out.println("Expected: 1, Actual: " + multiSet.count("apple"));
        multiSet.remove("apple");
        System.out.println("Expected: 0, Actual: " + multiSet.count("apple"));
        System.out.println();
    }

    public static void testContains() {
        MultiSet<String> multiSet = new MultiSet<>();
        multiSet.add("apple");

        System.out.println("Test Contains:");
        System.out.println("Expected: true, Actual: " + multiSet.contains("apple"));
        System.out.println("Expected: false, Actual: " + multiSet.contains("banana"));
        System.out.println();
    }

    public static void testIsEmpty() {
        MultiSet<String> multiSet = new MultiSet<>();

        System.out.println("Test IsEmpty:");
        System.out.println("Expected: true, Actual: " + multiSet.isEmpty());
        multiSet.add("apple");
        System.out.println("Expected: false, Actual: " + multiSet.isEmpty());
        System.out.println();
    }

    public static void testChoose() {
        MultiSet<String> multiSet = new MultiSet<>();
        multiSet.add("apple");
        multiSet.add("banana");

        System.out.println("Test Choose:");
        System.out.println("Chosen element: " + multiSet.choose());
        System.out.println("Note: The chosen element may vary.");
        System.out.println();
    }

    public static void testCount() {
        MultiSet<String> multiSet = new MultiSet<>();
        multiSet.add("apple");
        multiSet.add("apple");
        multiSet.add("banana");

        System.out.println("Test Count:");
        System.out.println("Expected: 2, Actual: " + multiSet.count("apple"));
        System.out.println("Expected: 1, Actual: " + multiSet.count("banana"));
        System.out.println("Expected: 0, Actual: " + multiSet.count("cherry"));
        System.out.println();
    }

    public static void testIterator() {
        MultiSet<String> multiSet = new MultiSet<>();
        multiSet.add("apple");
        multiSet.add("banana");
        multiSet.add("apple");

        System.out.println("Test Iterator:");
        Iterator<String> iterator = multiSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\nExpected: apple apple banana (order may vary)");
        System.out.println();
    }
}

