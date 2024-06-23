package org.example.utils.GenericUtil;
import org.example.classes.GenericStack;
import org.example.interfaces.iStack;
public class GenericStackUtil {

    public static <T> GenericStack<T> invertirStack(GenericStack<T> stack) {

        GenericStack<T> stackInvertida = new GenericStack<>();

        while (!stack.isEmpty()) {
            stackInvertida.add(stack.top());
            stack.remove();
        }

        return stackInvertida;
    }

    public static <T> GenericStack<T> copiarStack(GenericStack<T> stack) {
        GenericStack<T> tempStack = new GenericStack<>();
        GenericStack<T> copiedStack = new GenericStack<>();

        // Transferir elementos de la pila original a la pila auxiliar
        while (!stack.isEmpty()) {
            tempStack.add(stack.top());
            stack.remove();
        }

        // Transferir elementos de la pila auxiliar a la pila copiada y restaurar la pila original
        while (!tempStack.isEmpty()) {
            T element = tempStack.top();
            copiedStack.add(element);
            stack.add(element);  // Restaurar la pila original
            tempStack.remove();
        }

        return copiedStack;
    }

}
