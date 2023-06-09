package dev.me.exercises;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!

Given an array, , of  real number strings, sort them in descending order — but wait, there's more! Each number must be printed in the exact same format as it was read from stdin, meaning that  is printed as , and  is printed as . If two numbers represent numerically equivalent values (e.g., ), then they must be listed in the same order as they were received as input).

Complete the code in the unlocked section of the editor below. You must rearrange array 's elements according to the instructions above.

Input Format

The first line consists of a single integer, , denoting the number of integer strings.
Each line  of the  subsequent lines contains a real number denoting the value of .

Constraints

Each  has at most  digits.
Output Format

Locked stub code in the editor will print the contents of array  to stdout. You are only responsible for reordering the array's elements.

Sample Input

9
-100
50
0
56.6
90
0.12
.12
02.34
000.000

Sample Output

90
56.6
50
02.34
0.12
.12
0
000.000
-100
 */
public class BigDecimalOrdering {
    public static void main(String[] args) {
        String[] input = {
                "9",
                "-100",
                "0.0",
                "50",
                "0",
                "56.6",
                "90",
                "0.12",
                ".12",
                "02.34",
                "000.000"
        };

        var readLines = Arrays.asList(input);

        /*
        Scanner console = new Scanner(System.in);
        var totalLines = console.nextInt();
        var readLines = new ArrayList<String>();

        for(int count=0; count <= totalLines; count++){
            String line = console.nextLine();
            readLines.add(line);
        }
        console.close();

        // TODO: Remove this hack
        readLines.remove(0);*/

        orderNumbers2(readLines);
    }

    private static void orderNumbers2(List<String> readLines) {
        Comparator<? super String> orderComparator = (o1, o2) -> {
            BigDecimal number1 = new BigDecimal(o1);
            BigDecimal number2 = new BigDecimal(o2);

            return number1.compareTo(number2);
        };

        Collections.sort(readLines, orderComparator.reversed());
        readLines.forEach(System.out::println);
    }
}
