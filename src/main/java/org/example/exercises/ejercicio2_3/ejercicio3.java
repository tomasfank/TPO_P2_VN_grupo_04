package org.example.exercises.ejercicio2_3;
import org.example.classes.GenericStack;
import org.example.interfaces.iGenericStack;

public class ejercicio3 {
    public static boolean parenthesesBalanced(String s) {
        GenericStack stack = new GenericStack();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = (char) stack.top();
                if ((c == ')' && top != '(')
                        || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
                stack.remove();
            }
            else if(c == '\'' || c == '}'){
                continue;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "(a)"; // Balanced parentheses
        String test2 = "'{'[a + b] * (c - d)}"; // Balanced parentheses
        String test3 = "(a + b * (c - d)"; // Unbalanced parentheses

        System.out.println("Test 1: " + parenthesesBalanced(test1));
        System.out.println("Test 2: " + parenthesesBalanced(test2));
        System.out.println("Test 3: " + parenthesesBalanced(test3));
    }
}
