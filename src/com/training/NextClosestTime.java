package com.training;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NextClosestTime {
    public static void main(String[] args) {
    }

    public String nextClosestTime(String time) {
        char[] result = time.toCharArray();
        int[] arr = new int[] {result[0], result[1], result[3], result[4]};
        Arrays.sort(arr);

        return "";
    }
}
