package com.training;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//        Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//        Return intervals after the insertion.
//
//
//
//        Example 1:
//
//        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//        Output: [[1,5],[6,9]]
//        Example 2:
//
//        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        Output: [[1,2],[3,10],[12,16]]
//        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
public class InsertInterval {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.toString(insert(new int[][]{{1, 5}}, new int[]{0, 0})));
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        if (length == 0) {
            return new int[][]{newInterval};
        }
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> merged = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < length; i++) {
            if (intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0] || (
                    intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]
            )) {
                left = Math.min(intervals[i][0], left);
                right = Math.max(intervals[i][1], right);
                continue;
            }
            if (intervals[i][1] < newInterval[0]) {
                merged.add(new int[]{intervals[i][0], intervals[i][1]});
                continue;
            }
            if (intervals[i][0] > newInterval[1]) {
                if (!inserted) {
                    merged.add(new int[]{left, right});
                    inserted = true;
                }
                merged.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        if (!inserted) {
            merged.add(new int[]{left, right});
        }
        return merged.toArray(int[][]::new);
    }
}
