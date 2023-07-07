package com.training;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//        In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> previseRow = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j ++) {
                int value;
                if (j == 0 || j == i) {
                    value = 1;
                } else {
                    value = previseRow.get(j-1) + previseRow.get(j);
                }
                row.add(value);
            }
            previseRow = row;
            ls.add(row);
        }
        return ls;
    }
}
