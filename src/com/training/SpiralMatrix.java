package com.training;

import java.lang.reflect.Array;
import java.util.*;

public class SpiralMatrix {

    public static void main(String[] args) {
//        int[][] matrix = spiralOrder(3);
//        System.out.println(Arrays.toString(matrix));
//        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    private static int[][] spiralOrder(int n) {
        int t = 0;
        int value = 1;
        int[][] matrix = new int[n][n];

        while (t < n - t) {
            for (int j = t; j < n - t; j++) {
                matrix[t][j] = value++;
            }
            for (int i = t + 1; i < n - t; i++) {
                matrix[i][n - t - 1] = value++;
            }
            for (int j = n - t - 2; j >= t; j--) {
                matrix[n - t - 1][j] = value++;
            }
            for (int i = n - t - 2; i >= t + 1; i--) {
                matrix[i][t] = value++;
            }
            t++;
        }
        return matrix;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int t = 0;
        int value = 1;
        int n = matrix[0].length;
        int m = matrix.length;
        List<Integer> ans = new ArrayList<>();
        while (t < Math.min(m, n) - t) {
            for (int j = t; j < n - t; j++) {
                ans.add(matrix[t][j]);
            }
            for (int i = t + 1; i < m - t; i++) {
                ans.add(matrix[i][n - t - 1]);
            }
            if (m - t - 1 > t) {
                for (int j = n - t - 2; j >= t; j--) {
                    ans.add(matrix[m - t - 1][j]);
                }
            }
            if (t < n - t - 1) {
                for (int i = m - t - 2; i >= t + 1; i--) {
                    ans.add(matrix[i][t]);
                }
            }
            t++;
        }
        return ans;
    }
}
