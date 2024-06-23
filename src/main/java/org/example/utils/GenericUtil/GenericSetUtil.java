package org.example.utils.GenericUtil;
import org.example.interfaces.iGenericSet;
import org.example.classes.GenericSet;



//Ejercicio 2.1: Crear un metodo para que se pueda copiar una stack
public class GenericSetUtil {
    public static <T> GenericSet<T> copy(GenericSet<T> original) {
        GenericSet<T> copy = new GenericSet<>();
        GenericSet<T> aux = new GenericSet<>();

        while (!original.isEmpty()) {
            T elemento = original.choose();
            copy.add(elemento);
            original.remove(elemento);
        }
        return copy;
    }
}
