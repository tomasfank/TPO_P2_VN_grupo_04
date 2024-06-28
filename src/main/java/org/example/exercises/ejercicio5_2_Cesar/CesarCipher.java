package org.example.exercises.ejercicio5_2_Cesar;

import org.example.classes.GenericStaticDictionary;

public class CesarCipher {

    public final GenericStaticDictionary<Character, Double> frequencies;

    public CesarCipher() {
        this.frequencies = new GenericStaticDictionary<>();
        initializeFrequencies();
    }

    private void initializeFrequencies() {
        // Letras del alfabeto español y sus frecuencias relativas
        // Fuente: https://es.wikipedia.org/wiki/Frecuencia_de_aparici%C3%B3n_de_letras
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        double[] proportions = {0.1253, 0.0142, 0.0468, 0.0586, 0.1368, 0.0069, 0.0101, 0.0070,
                0.0625, 0.0044, 0.0002, 0.0497, 0.0315, 0.0671, 0.0031, 0.0868,
                0.0251, 0.0088, 0.0687, 0.0798, 0.0463, 0.0393, 0.0090, 0.0001,
                0.0022, 0.0090, 0.0052};

        // Agregar las letras y sus proporciones al diccionario
        for (int i = 0; i < letters.length; i++) {
            frequencies.add(letters[i], proportions[i]);
        }
    }

    /**
     *
     * @param shift
     * @return un diccionario que representa la biyeccion del alfabeto español luego de aplicar
     * una clave que "shiftea" todo el alfabeto.
     */
    public GenericStaticDictionary<Character, Character> createCipher(int shift) {
        //if (shift < 0 || shift > 26) {
        //    throw new IllegalArgumentException("El valor de shift debe estar entre 0 y 26");
        //}
        int shiftMod27 = shift % 27;

        GenericStaticDictionary<Character, Character> cipher = new GenericStaticDictionary<>();
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        int alphabetSize = letters.length;

        for (int i = 0; i < alphabetSize; i++) {
            char original = letters[i];
            char shifted = letters[(i + shiftMod27) % alphabetSize];
            cipher.add(original, shifted);
        }

        return cipher;
    }

    /**
     *
     * @param texto
     * @param shift
     * @return el texto encriptado segun la clave shift
     */
    public String encriptar(String texto, int shift) {
        GenericStaticDictionary<Character, Character> cipher = createCipher(shift);
        StringBuilder encryptedText = new StringBuilder();

        for (char c : texto.toCharArray()) {
            if (Character.isUpperCase(c)) {
                encryptedText.append(cipher.get(c));
            } else if (Character.isLowerCase(c)) {
                char upperChar = Character.toUpperCase(c);
                char encryptedChar = cipher.get(upperChar);
                encryptedText.append(Character.toLowerCase(encryptedChar));
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    /**
     *
     * @param alphabet
     * @param target
     * @return true si el char target está en el array de char's alphabet
     * esta funcion es auxiliar para el metodo calcularFrecuencias
     */
    public static boolean alphabetContains(char[] alphabet, char target) {
        for (char c : alphabet) {
            if (c == target) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param texto
     * @return un Diccionario Character --> Double, que representa una tabla de
     * frecuencias calculada empíricamente sobre el input texto (posiblemente, un texto encriptado)
     */
    public GenericStaticDictionary<Character, Double> calcularFrecuencias(String texto) {
        GenericStaticDictionary<Character, Double> frecuencias = new GenericStaticDictionary<>();
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        // Inicializar el diccionario de frecuencias
        for (char letter : letters) {
            frecuencias.add(letter, 0.0);
        }

        // Contar las apariciones de cada letra
        int totalLetters = 0;
        for (char c : texto.toCharArray()) {
            c = Character.toUpperCase(c);
            if (alphabetContains(letters, c)) { // si el char está en el alfabeto español,
                                                // me influye en la tabla de frecuencias. Si no, no.
                frecuencias.add(c, frecuencias.get(c) + 1.0);
                totalLetters++;
            }
        }

        // Calcular las frecuencias relativas
        for (char letter : letters) {
            double relativeFrequency = frecuencias.get(letter) / (double) totalLetters;
            frecuencias.add(letter, relativeFrequency);
        }

        return frecuencias;
    }

    /**
     *
     * @param dic1
     * @param dic2
     * @return Calcula la similitud coseno entre dos tablas de frecuencias relativas,
     * pensadas como vectores ordenados (por el orden léxicográfico del dominio).
     */
    public double calcularSimilitudCoseno(GenericStaticDictionary<Character, Double> dic1,
                                          GenericStaticDictionary<Character, Double> dic2) {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        double dotProduct = 0.0;
        double normDic1 = 0.0;
        double normDic2 = 0.0;

        for (char letter : letters) {
            double freq1 = dic1.get(letter);
            double freq2 = dic2.get(letter);

            dotProduct += freq1 * freq2;
            normDic1 += Math.pow(freq1, 2);
            normDic2 += Math.pow(freq2, 2);
        }

        return dotProduct / (Math.sqrt(normDic1) * Math.sqrt(normDic2));
    }

    /**
     *
     * @param F
     * @param C
     * @return la composición F o C, pensando estos diccionarios como funciones.
     */
    public static GenericStaticDictionary<Character, Double> componerFreqCipher(
            GenericStaticDictionary<Character, Double> F,
            GenericStaticDictionary<Character, Character> C) {

        GenericStaticDictionary<Character, Double> resultado = new GenericStaticDictionary<>();
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (char letter : letters) {
            Character mappedLetter = C.get(letter);
            Double frequency = F.get(mappedLetter);
            resultado.add(letter, frequency);
        }

        return resultado;
    }

    /**
     *
     * @param textoEncriptado
     * @return la clave tal que this.encriptar(textoOriginal, clave) devuelve textoEncriptado
     */
    public int encontrarClave(String textoEncriptado){
        GenericStaticDictionary<Character, Double> freqEnc = calcularFrecuencias(textoEncriptado);
        Double[] similitudes = new Double[27];

        // Calculo el array de las similitudes-coseno entre todas las tablas de frecuencia que
        // puedo obtener SHIFTEANDO el textoEncriptado, y la tabla de frecuencias maestra que
        // saqué de wikipedia, e inicializo cada vez que creo un objeto CesarCipher.
        for(int shift = 0; shift <= 26; shift++){
            GenericStaticDictionary<Character, Character> cifrador = createCipher(shift);
            GenericStaticDictionary<Character, Double> freqEncShift = componerFreqCipher(freqEnc, cifrador);
            Double similitud = calcularSimilitudCoseno(freqEncShift, frequencies);
            similitudes[shift] = similitud;
        }
        int shift = 0;
        for (int i = 1; i < similitudes.length; i++) {
            if (similitudes[i] > similitudes[shift]) {
                shift = i;
            }
        }

        return shift;

    }
}
