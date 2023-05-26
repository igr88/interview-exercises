package dev.me.exercises;

import java.util.Arrays;
import java.util.List;

/*
Sometimes is necessary to filter a signal by frequency, e.g. to reduce noise outside
of the expected frequency range. Filters can be stacked, allowing  only the frequencies
within the range allowed by all filters to get through. For example, three filters with ranges
of (10,17), (13,15) and (13, 17) will only allow signals between 13 and 15 through. The only
range that all filters overlap is (13, 15). Given n signals' frequencies and a series of m
filters that let through frequencies in the range x t y, inclusive, determine the number of
signals that will get through the filters. There will be only one range where all the filters
overlap.

Example

frequencies = [8, 15, 14, 16, 21]
filterRanges = [[10,17], [13,15], [13,17]]
the range that all of the filters allow through  is from 13 to 15, inclusive. the 2 frequencies
that will pass through all filters have frequencies of 15 and 14. Return 2
 */
public class SignalFilter {
    public static int countSignals(List<Integer> frequencies, List<List<Integer>> filterRanges) {
        var min = 0;
        var max = Integer.MAX_VALUE;

        for (List<Integer> ranges : filterRanges) {
            if(ranges.get(0) >= min) {
                min = ranges.get(0);
            }

            if (ranges.get(1) <= max) {
                max = ranges.get(1);
            }
        }

        int finalMin = min;
        int finalMax = max;
        return (int)frequencies.stream()
                .filter(f -> f >= finalMin && f<= finalMax)
                .count();
    }

    public static void main(String[] args) {
        List<Integer> frequencies = Arrays.asList(8, 15, 14, 16, 21);
        List<List<Integer>> filterRanges = List.of(List.of(10, 17), List.of(13,15), List.of(13,17));
        System.out.println(countSignals(frequencies, filterRanges));
    }
}
