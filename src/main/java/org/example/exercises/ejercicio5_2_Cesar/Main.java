package org.example.exercises.ejercicio5_2_Cesar;

import org.example.classes.GenericStaticDictionary;

public class Main {
    public static void main(String[] args) {
        GenericStaticDictionary<Character, Double> dictionary = new GenericStaticDictionary<>();

        // Letras del alfabeto español y sus frecuencias relativas
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        double[] frequencies = {0.1253, 0.0142, 0.0468, 0.0586, 0.1368, 0.0069, 0.0101, 0.0070,
                0.0625, 0.0044, 0.0002, 0.0497, 0.0315, 0.0671, 0.0031, 0.0868,
                0.0251, 0.0088, 0.0687, 0.0798, 0.0463, 0.0393, 0.0090, 0.0001,
                0.0022, 0.0090, 0.0052};

        // Agregar las letras y sus frecuencias al diccionario
        for (int i = 0; i < letters.length; i++) {
            dictionary.add(letters[i], frequencies[i]);
        }

        // Imprimir el diccionario
        System.out.println("Diccionario de frecuencias de letras en español:");
        for (char letter : letters) {
            System.out.println("Letra: " + letter + " - Frecuencia: " + Math.round(10000.0 * dictionary.get(letter))/100.0 + "%");
        }

        // Fuente de las frecuencias
        System.out.println("Fuente de las frecuencias: https://es.wikipedia.org/wiki/Frecuencia_de_aparici%C3%B3n_de_letras");
    }
}
