package org.example.interfaces;

public interface iUniversalSet extends iSuperSet {

    /**
     * Precondicion: El conjunto parametro debe estar inicializado.
     *
     * @param subset el conjunto a verificar si es subconjunto.
     * @return <code>true</code> si el conjunto parametro es un subconjunto de este conjunto, <code>false</code> en otro caso.
     */
    boolean isSubset(iSuperSet subset);

    /**
     * Precondicion: El conjunto parametro debe estar inicializado y ser un subconjunto de este conjunto.
     *
     * @param subset el conjunto para el cual calcular el complemento.
     * @return el conjunto complemento del conjunto parametro.
     */
    iSuperSet complement(iSuperSet subset);
}
