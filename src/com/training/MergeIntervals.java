package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and
// return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//
//
//        Example 1:
//
//        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//        Example 2:
//
//        Input: intervals = [[1,4],[4,5]]
//        Output: [[1,5]]
//        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
public class MergeIntervals {

    public static void main(String[] args) {
//        System.out.println(merge(new int[][] {{1,3},{2,6},{8,10},{15,18}}));
//        System.out.println(merge(new int[][] {{1,4},{2,3}}));
        System.out.println(merge(new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}}));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (s1, s2) -> {
            if (s1[0] == s2[0]) {
                return s1[1] - s2[1];
            }
            return s1[0] - s2[0];
        });
        int i = 0, j = 0, t = 1, length = intervals.length;
        List<List<Integer>> result = new ArrayList<>();
        while (true) {
            int begin = intervals[i][0];
            int end = intervals[j][1];
            if (j + t == length) {
                end = Math.max(intervals[j + t - 1][1], end);
                result.add(List.of(begin, end));
                break;
            }
            if (end >= intervals[j + t][0] && end <= intervals[j + t][1]) {
                j = j + t;
                t = 1;
                continue;
            }
            if (end > intervals[j + t][1]) {
                t++;
                continue;
            }
            if (end < intervals[j + t][0]) {
                result.add(List.of(begin, end));
                i = j + t;
                j = j + t;
                t = 1;
            }
        }
        return result.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

}
