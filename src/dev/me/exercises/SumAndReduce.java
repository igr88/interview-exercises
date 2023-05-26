package dev.me.exercises;

import java.util.List;

/*
Sum all elements of a collection, try to use the reduce operator with identity parameter instead of an IntStream
 */
public class SumAndReduce {
    public static int calculate(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}
