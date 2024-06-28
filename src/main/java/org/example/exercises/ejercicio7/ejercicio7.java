package org.example.exercises.ejercicio7;

import org.example.classes.PriorityQueueEj7;

public class ejercicio7 {

        public static <T> void modifyPriority(PriorityQueueEj7<T> queue, T element, int newPriority) {
            queue.changePriority(element, newPriority);
        }

        public static void main(String[] args) {
            PriorityQueueEj7<String> queue = new PriorityQueueEj7<>();
            queue.add("a", 3);
            queue.add("b", 1);
            queue.add("c", 2);

            System.out.println("Original queue:");
            while (!queue.isEmpty()) {
                System.out.println(queue.getFirst() + " - Prioridad: " + queue.getPriority(queue.getFirst()));
                queue.remove();
            }

            queue.add("a", 3);
            queue.add("b", 1);
            queue.add("c", 2);

            modifyPriority(queue, "b", 4);

            System.out.println("Queue después de modificar prioridad:");
            while (!queue.isEmpty()) {
                System.out.println(queue.getFirst() + " - Prioridad: " + queue.getPriority(queue.getFirst()));
                queue.remove();
            }
        }
    }


