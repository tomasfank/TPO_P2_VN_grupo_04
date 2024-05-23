package org.example.exercises.ejercicio1;


import org.example.utils.StackUtils;
import org.example.classes.QueueOfStacks;
import org.example.utils.QueueOfStacksUtils;
import org.example.classes.Stack;

public class ejercicio1 {
    public static int trace(QueueOfStacks qos) {
        int trace = 0;
        int n = qos.length();
        int elem;
        Stack col;
        for (int col_ind = 0; col_ind < n; col_ind++){
            col = qos.getFirst();
            qos.remove();
            for (int row_ind = 0; row_ind <= n - 1 - col_ind; row_ind++){
                if (row_ind < n-1-col_ind){
                    col.remove();
                }else{
                    elem = col.top();
                    trace += elem;
                }
            }
        }
        return trace;

    }

    public static QueueOfStacks transpose(QueueOfStacks qos) {
        QueueOfStacks transpose = new QueueOfStacks();
        Stack col, outcol;
        Stack colRev;
        int elem;
        int n = qos.length();

        for (int i = 0; i<n; i++){
            transpose.add(new Stack());
        }

        for (int i = 0; i<n; i++){
            col = qos.getFirst();
            qos.remove();
            StackUtils.revert(col);
            while (!col.isEmpty()){
                outcol = transpose.getFirst();
                transpose.remove();
                elem = col.top();
                outcol.add(elem);
                col.remove();
                transpose.add(outcol);
            }
        }

        return transpose;
    }

    public static QueueOfStacks addMatrices(QueueOfStacks x, QueueOfStacks y){
        QueueOfStacks a = QueueOfStacksUtils.copy(x);
        QueueOfStacks b = QueueOfStacksUtils.copy(y);
        QueueOfStacks c = new QueueOfStacks();
        int n = a.length();
        for (int i = 0; i < n; i++){
            Stack acol = a.getFirst();
            Stack bcol = b.getFirst();
            a.remove();
            b.remove();
            Stack ccol = new Stack();

            while (!acol.isEmpty()){
                int elem = acol.top() + bcol.top();
                acol.remove();
                bcol.remove();
                ccol.add(elem);
            }
            c.add(ccol);
        }
        return c;
    }



}
