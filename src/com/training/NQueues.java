package com.training;

import java.util.List;

public class NQueues {

    public static void main(String[] args) {

    }

    public List<List<String>> solveNQueens(int n) {
        if (n==1) {
            return List.of(List.of("Q"));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

            }
        }
        return null;
    }

//    private static List<String> eliminate(int row, int column, int n, String[][] existingList) {
//        for (int i=row+1; i<=n; i++) {
//            if (!existingList.contains(i + "," + column)) {
//                existingList.add(i + "," + column);
//            }
//            int right = column+i-row;
//            if (right <= n && !existingList.contains(i + "," + right)) {
//                existingList.add(i + "," + right);
//            }
//            int left = column-(i-row);
//            if (left>0 && !existingList.contains(i + "," + left)){
//                existingList.add(i + "," + left);
//            }
//        }
//        return existingList;
//    }
}
