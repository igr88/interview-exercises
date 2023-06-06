package dev.me.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input

{}()
({()})
{}(
[]
Sample Output

true
true
false
true
 */
public class BalancedParentheses {

    public static void main(String[] args) {
        /*var input = new String[] {
                "{}()",
                "({()})",
                "{}(",
                "[]"
        };

        var readLines = Arrays.asList(input);*/

        String line;
        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                if (line.isEmpty()) {
                    break;
                }

                System.out.println(verify(line));
            }
        }
    }

    private static boolean verify(String line) {
        if (line == null || line.isEmpty() || line.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character c : line.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                var charAtTop = stack.peek();

                if (charAtTop == '{' && c == '}' ||
                        charAtTop == '[' && c == ']' ||
                        charAtTop == '(' && c == ')') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
