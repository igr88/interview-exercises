package dev.me.exercises;

import java.util.Arrays;

/*
Given an array of integers, return an array of integers such that the value at index i of the output
is the product of everything in the input except the input value at index i. An empty list should
return []. A list of length 1 should return [1] no matter what the input element is.

Example:
product_exclusion([2,3,4,5]) => [60, 40, 30, 24]
 */
public class ProductInArray {
    public int[] exclusionOnxn(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }

        if (input.length == 1) {
            return new int[]{1};
        }

        int[] results = new int[input.length];

        for (int i=0; i<input.length; i++) {
            int pos = 0;
            int product = 1;

            while (pos < input.length){
                if (pos != i) {
                    product *= input[pos];
                }
                pos++;
            }
            results[i] = product;
        }

        return results;
    }

    public int[] exclusionOn(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }

        if (input.length == 1) {
            return new int[]{1};
        }

        int[] results = new int[input.length];
        int product = 1;
        int zeroCount = 0;

        for (int i=0;i<input.length;i++) {
            if (input[i] == 0) {
                zeroCount++;
            } else {
                product *= input[i];
            }
        }

        for (int i=0; i< input.length; i++) {
            if (input[i] == 0) {
                if (zeroCount > 1) {
                    results[i] = 0;
                } else {
                    results[i] = product;
                }
            } else {
                if (zeroCount > 0) {
                    results[i] = 0;
                } else {
                    results[i] = product / input[i];
                }
            }
        }

        return results;
    }


    public static void main(String[] args) {
        ProductInArray pia = new ProductInArray();
        int[][] input = new int[][] {
                {2,3,4,5},
                {2,3,0,5},
                {2,0,0,5},
                {},
                {13}
        };

        for (int i=0; i<input.length; i++) {
            System.out.println(Arrays.toString(pia.exclusionOnxn(input[i])));
            System.out.println(Arrays.toString(pia.exclusionOn(input[i])));
        }

    }
}
