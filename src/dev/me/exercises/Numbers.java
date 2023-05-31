package dev.me.exercises;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/*
PerformOperation isOdd(): The lambda expression must return  if a number is odd or  if it is even.
PerformOperation isPrime(): The lambda expression must return  if a number is prime or  if it is composite.
PerformOperation isPalindrome(): The lambda expression must return  if a number is a palindrome or  if it is not.
Input Format

Input is handled for you by the locked stub code in your editor.

Output Format

The locked stub code in your editor will print  lines of output.

Sample Input

The first line contains an integer,  (the number of test cases).

The  subsequent lines each describe a test case in the form of  space-separated integers:
The first integer specifies the condition to check for ( for Odd/Even,  for Prime, or  for Palindrome). The second integer denotes the number to be checked.

5
1 4
2 5
3 898
1 3
2 12
Sample Output

EVEN
PRIME
PALINDROME
ODD
COMPOSITE
 */
public class Numbers {
    public static void main(String[] args) {
        var input = new String[] {
                "1 4",
                "2 5",
                "3 898",
                "1 3",
                "2 12"
        };

        var readLines = new ArrayList<String>();

        try(Scanner console = new Scanner(System.in)) {
            var totalLines = console.nextInt();

            for(int count=0; count <= totalLines; count++){
                String line = console.nextLine();
                readLines.add(line);
            }
            console.close();

            // TODO: Remove this hack
            readLines.remove(0);
        }

        for(String line : readLines) {
            System.out.println(determineOperation(splitParams(line)));
        }
    }

    public static String determineOperation(int[] params) {
        final var number = params[1];
        return switch (params[0]) {
            case 1 -> isOddOrEven(number);
            case 2 -> isPrimeOrComposite(number);
            case 3 -> isPalindromeOrNot(number);
            default -> throw new IllegalArgumentException("Invalid option");
        };
    }

    private static String isPalindromeOrNot(int number) {
        return isPalindrome(number) ? "PALINDROME" : "NOT PALINDROME";
    }

    private static String isOddOrEven(int number) {
        return isOdd(number) ? "ODD" : "EVEN";
    }

    private static String isPrimeOrComposite(int number) {
        return isPrime(number) ? "PRIME" : "COMPOSITE";
    }

    private static boolean isPalindrome(int number) {
        int reversed = reverse(number);
        return reversed == number;
    }

    private static int reverse(int number) {
        int reversed = 0;

        while(number > 0){
            int digit = number % 10;
            reversed = (reversed * 10) + digit;
            number /= 10;
        }

        return reversed;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isPrime(int number) {
        // corner cases
        if (number <= 1) {
            return false;
        }

        if (number == 2 || number == 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0){
            return false;
        }

        for (int i=3; i<Math.sqrt(number); i+=2) {
            if ( i % number == 0 || i % Math.sqrt(number) == 0) {
                return false;
            }
        }

        return true;
    }

    public static int[] splitParams(String line) {
        return Stream.of(line.split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
