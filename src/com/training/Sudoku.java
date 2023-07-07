package com.training;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,2,5,4,6,9,8,7},
                {4,6,5,8,7,9,3,2,1},
        {7,9,8,2,1,3,6,5,4},
            {9,2,1,4,3,5,8,7,6},
                {3,5,4,7,6,8,2,1,9},
                    {6,8,7,1,9,2,5,4,3},
                        {5,7,6,9,8,1,4,3,2},
                            {2,4,3,6,5,7,1,9,8},
                                {8,1,9,3,2,4,7,6,5}};
        System.out.println(solution(matrix));
    }

    static boolean solution(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j< 9; j ++) {
                if (!rowSet.add(grid[i][j])) {
                    System.out.println("duplicate at row " + i);
                    return false;
                }
                if (!columnSet.add(grid[j][i])) {
                    System.out.println("duplicate at row " + j);
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3){
                Set<Integer> subgridSet = new HashSet<>();
                for (int r = i; r < i + 3; r ++) {
                    for (int c = j; c < j + 3; c++) {
                        if (!subgridSet.add(grid[r][c])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
