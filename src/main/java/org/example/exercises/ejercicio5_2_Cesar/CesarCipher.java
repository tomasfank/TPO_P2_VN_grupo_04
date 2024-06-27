package org.example.exercises.ejercicio5_2_Cesar;

import org.example.classes.GenericStaticDictionary;

public class CesarCipher {

    private final GenericStaticDictionary<Character, Double> frequencies;

    public CesarCipher() {
        this.frequencies = new GenericStaticDictionary<>();
        initializeFrequencies();
    }

    private void initializeFrequencies() {
        // Letras del alfabeto español y sus frecuencias relativas
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

    public static boolean alphabetContains(char[] alphabet, char target) {
        for (char c : alphabet) {
            if (c == target) {
                return true;
            }
        }
        return false;
    }
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
            if (alphabetContains(letters, c)) {
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

    public static void main(String[] args) {
        CesarCipher cesarCipher = new CesarCipher();

        // Prueba del cifrado
        String texto = "HOLA MUNDO";
        int shift = 30;
        String textoCifrado = cesarCipher.encriptar(texto, shift);
        System.out.println("Texto original: " + texto);
        System.out.println("Texto cifrado: " + textoCifrado);

        String frase = "VAMOS A MORIR, Y ESO NOS CONVIERTE EN LOS AFORTUNADOS. LA MAYORIA DE LA GENTE NO MORIRA NUNCA, PORQUE NO VA A NACER NUNCA. LA GENTE QUE PODRIA HABER ESTADO EN MI LUGAR, PERO QUE, DE HECHO, NUNCA VERA LA LUZ DEL DIA, SOBREPASA CON CRECES EL NUMERO DE GRANOS DEL DESIERTO DEL SAHARA. SIN DUDA, ENTRE ESOS ESPIRITUS NO NACIDOS HAY POETAS MAS GRANDES QUE KEATS, CIENTIFICOS MAS GRANDES QUE NEWTON. SABEMOS ESTO PORQUE EL CONJUNTO DE PERSONAS POSIBLES QUE PERMITE NUESTRO ADN SUPERA DE FORMA MASIVA AL CONJUNTO DE LAS PERSONAS QUE EXISTEN. A PESAR DE ESTA ABRUMADORAMENTE PEQUEÑA POSIBILIDAD, SOMOS TU Y YO, EN NUESTRA VIDA ORDINARIA, QUIENES ESTAMOS AQUI. NOSOTROS, LOS POCOS PRIVILEGIADOS QUE GANAMOS LA LOTERIA DE NACER CONTRA TODO PRONOSTICO, ¿COMO NOS ATREVEMOS A LLORIQUear POR NUESTRO INEVITABLE REGRESO A ESE ESTADO PREVIO DEL QUE LA INMENSA MAYORIA JAMAS ESCAPO?";
        GenericStaticDictionary<Character, Double> frecuencias = cesarCipher.calcularFrecuencias(frase);
        System.out.println(frecuencias.get('A'));
    }
}
