package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }


    public static int[] plusOne(int[] digits) {
        boolean incrementNext = false;
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                digits[i] = digits[i] + 1;
            }
            if (incrementNext) {
                digits[i] = digits[i] + 1;
            }
            if (digits[i] == 10) {
                digits[i] = 0;
                incrementNext = true;
            } else {
                incrementNext = false;
            }
        }
        if (incrementNext) {
            return IntStream.range(0, length + 1).map(i -> i == 0 ? 1 : digits[i - 1]).toArray();
        }
        return digits;
    }


    public static int[] betterSolution(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
