package org.example.exercises.ejercicio6;

import org.example.classes.SuperSet;
import org.example.classes.UniversalSet;
import org.example.interfaces.iSuperSet;

public class ejercicio6_2 {
    public static void main(String[] args) {
        SuperSet subset = new SuperSet();
        subset.add(2);
        subset.add(4);


        UniversalSet universalSet = new UniversalSet();
        universalSet.add(1);
        universalSet.add(2);
        universalSet.add(3);
        universalSet.add(4);
        universalSet.add(5);



        System.out.println("Is subset: " + universalSet.isSubset(subset));  // Imprime: True o False
    /*
        iSuperSet complement = universalSet.complement(subset);
        while (!complement.isEmpty()) {
            System.out.println("Complement element: " + complement.choose());
            complement.remove(complement.choose());
        }*/
        // Imprime los elementos que están en universalSet pero no en subset
    }
}
