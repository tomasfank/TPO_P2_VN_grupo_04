package org.example.exercises.ejercicio5_2_Cesar;

import org.example.classes.GenericStaticDictionary;


public class Main {
    public static void main(String[] args) {
        int clave = 7; //reemplazar con un valor entero cualquiera.

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

        System.out.println();
        // Fuente de las frecuencias
        System.out.println("Fuente de las frecuencias: https://es.wikipedia.org/wiki/Frecuencia_de_aparici%C3%B3n_de_letras");
        System.out.println();

        // ---------------------------------------------------------------------------------------------------------
        // Demo de la clase CesarCipher
        CesarCipher cesarCipher = new CesarCipher();

        String frase =
                "VAMOS A MORIR, Y ESO NOS CONVIERTE EN LOS AFORTUNADOS. LA MAYORIA DE LA GENTE NO MORIRA NUNCA, \n" +
                        "PORQUE NO VA A NACER NUNCA. LA GENTE QUE PODRIA HABER ESTADO EN MI LUGAR, PERO QUE, DE HECHO, \n" +
                        "NUNCA VERA LA LUZ DEL DIA, SOBREPASA CON CRECES EL NUMERO DE GRANOS DEL DESIERTO DEL SAHARA.\n" +
                        "SIN DUDA, ENTRE ESOS ESPIRITUS NO NACIDOS HAY POETAS MAS GRANDES QUE KEATS, CIENTIFICOS MAS GRANDES QUE NEWTON.\n" +
                        "SABEMOS ESTO PORQUE EL CONJUNTO DE PERSONAS POSIBLES QUE PERMITE NUESTRO ADN SUPERA \n" +
                        "DE FORMA MASIVA AL CONJUNTO DE LAS PERSONAS QUE EXISTEN. A PESAR DE ESTA ABRUMADORAMENTE PEQUEÑA POSIBILIDAD, \n" +
                        "SOMOS TU Y YO, EN NUESTRA VIDA ORDINARIA, QUIENES ESTAMOS AQUI. NOSOTROS, LOS POCOS PRIVILEGIADOS QUE GANAMOS \n" +
                        "LA LOTERIA DE NACER CONTRA TODO PRONOSTICO, ¿COMO NOS ATREVEMOS A LLORIQUEAR POR NUESTRO INEVITABLE REGRESO \n" +
                        "A ESE ESTADO PREVIO DEL QUE LA INMENSA MAYORIA JAMAS ESCAPO?";
        GenericStaticDictionary<Character, Double> frecuencias = cesarCipher.calcularFrecuencias(frase);
        String fraseEncriptada = cesarCipher.encriptar(frase, clave);
        System.out.println("La frase encriptada es:");
        System.out.println();
        System.out.println(fraseEncriptada);
        int shift;
        shift = cesarCipher.encontrarClave(fraseEncriptada);
        String textoDesencriptado =cesarCipher.encriptar(fraseEncriptada,27-shift);
        System.out.println();
        System.out.println("La frase desencriptada:");
        System.out.println();
        System.out.println(textoDesencriptado);

    }
}
