package org.example.exercises.ejercicio2_5;
import org.example.classes.GenericStack;

public class ejercicio3 {
    public static boolean parenthesesBalanced(String s) {
        GenericStack stack = new GenericStack(); // C_1

        for (char c : s.toCharArray()) { // N_1
            if (c == '(' || c == '[' || c == '{') { // C_2
                stack.add(c); // C_3
            } else if (c == ')' || c == ']' || c == '}') { // C_4
                if (stack.isEmpty()) { // C_5
                    return false; // C_6
                }
                char top = (char) stack.top(); // C_7
                if ((c == ')' && top != '(') // C_8
                        || (c == ']' && top != '[') // C_9
                        || (c == '}' && top != '{')) { // C_10
                    return false; // C_11
                }
                stack.remove(); // C_12
            } else if (c == '\'' || c == '}') { // C_13
                continue; // C_14
            }
        }

        return stack.isEmpty(); // C_15
    } // O(N1×(C2+C3+C4+C5+C6+C7+C8+C9+C10+C11+C12+C13+C14))+C15 = O(n)

    public static void main(String[] args) {
        String test1 = "(a)"; // Balanced parentheses
        String test2 = "'{'[a + b] * (c - d)}"; // Balanced parentheses
        String test3 = "(a + b * (c - d)"; // Unbalanced parentheses

        System.out.println("Test 1: " + parenthesesBalanced(test1));
        System.out.println("Test 2: " + parenthesesBalanced(test2));
        System.out.println("Test 3: " + parenthesesBalanced(test3));
    }
}
