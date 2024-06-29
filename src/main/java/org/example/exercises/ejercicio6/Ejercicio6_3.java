package org.example.exercises.ejercicio6;
import org.example.classes.dynamic.nodes.DoublyLinkedQueue;
import org.example.classes.dynamic.nodes.Node;

public class Ejercicio6_3 {

    public static void main(String[] args) {
        DoublyLinkedQueue queue = new DoublyLinkedQueue();

        // Prueba de agregar elementos a la cola
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Prueba de obtener el primer elemento
        System.out.println("Primer elemento: " + queue.getFirst());  // Debería imprimir: 1

        // Prueba de eliminar el primer elemento
        queue.remove();
        System.out.println("Primer elemento después de eliminar: " + queue.getFirst());  // Debería imprimir: 2

        // Prueba de verificar si la cola está vacía
        System.out.println("¿Está vacía la cola? " + queue.isEmpty());  // Debería imprimir: false

        // Prueba de obtener los nodos first y last
        System.out.println("Nodo first: " + queue.getFirstNode().getValue());
        System.out.println("Nodo last: " + queue.getLastNode().getValue());

        // Prueba de vaciar la cola
        queue.remove();
        queue.remove();
        System.out.println("¿Está vacía la cola después de vaciarla? " + queue.isEmpty());  // Debería imprimir: true
    }
}
