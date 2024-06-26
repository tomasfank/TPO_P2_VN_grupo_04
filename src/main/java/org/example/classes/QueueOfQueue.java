package org.example.classes;
import org.example.interfaces.iQueueOfQueue;
import org.example.utils.QueueUtils;

public class QueueOfQueue implements iQueueOfQueue{
    Queue [] a;
    int i;

    public QueueOfQueue() {
        a = new Queue[100];
        i = 0;
    }

    @Override
    public void add(Queue x) {
        a[i] = x;
        i++;
    }

    @Override
    public void remove() {
        for (int j = 0; j < i-1; j++) {
            a[j] = a[j+1];
        }
        i--;
    }

    @Override
    public boolean isEmpty() {
        return (i == 0);
    }

    @Override
    public Queue first() {
        return a[0];
    }

    @Override
    public String toString(){
        // Usamos StringBuilder para construir la cadena de salida de manera eficiente
        StringBuilder sb = new StringBuilder("QueueOfQueue{\n");

        // Iteramos sobre el array hasta el índice i para incluir solo las colas relevantes
        for (int j = 0; j < i; j++) {
            sb.append("  Queue ").append(j + 1).append(": ").append(a[j].toString()).append("\n");
        }
        sb.append("}");
        return sb.toString(); // Retorna la cadena construida
    }
    @Override
    public void reverseWithDepth() {
        StackOfQueue aux = new StackOfQueue();
        while (!this.isEmpty()) {
            QueueUtils.revert(this.first());
            aux.add(this.first());
            this.remove();
        }
        while (!aux.isEmpty()) {
            this.add(aux.top());
            aux.remove();
        }
    }

    @Override
    public QueueOfQueue concatenate(QueueOfQueue... qoq) {
        QueueOfQueue concat = new QueueOfQueue();

        for(int j = 0; j < this.i ; j++){//Primer for para la propia Queue que llama al método
            concat.add(this.a[j]);
        }
        for(QueueOfQueue x : qoq) {
            while(!x.isEmpty()){
                concat.add(x.first());
                x.remove();
            }
        }
        return concat;
    }

    @Override
    public Queue flat() {
        Queue flated = new Queue();
        for(int j = 0; j < this.i ; j++){
            while(!this.a[j].isEmpty()){
                flated.add(this.a[j].first());
                this.a[j].remove();
            }
        }
        return flated;
    }
}
