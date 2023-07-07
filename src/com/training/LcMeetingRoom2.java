package com.training;


//Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), find the minimum number of conference rooms required.
//
//Input:
//        [[0, 30],[5, 10],[15, 20]]
//        Output:
//        2

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Input:
//        [[7,10],[2,4]]
//        Output:
//        1
public class LcMeetingRoom2 {

    public static void main(String[] args) {
        int[][] arr = {{0, 30},{5, 10},{15, 20}, {6, 8}};
        System.out.println(minRoom(arr));
        int[][] arr1 = {{7, 10},{2, 4}};
        System.out.println(minRoom(arr1));
    }

    private static int minRoom(int[][] arr) {
       int[] starts = new int[arr.length];
       int[] ends = new int[arr.length];
       for (int i = 0; i < arr.length; i++) {
           starts[i] = arr[i][0];
           ends[i] =  arr[i][1];
       }
       Arrays.sort(starts);
       Arrays.sort(ends);
       int max = 0;
       int numOfRooms = 0;
       int j = 0;
       for (int i = 0; i < starts.length -1; i ++) {
           //keep adding rooms if the next end time is after the current start time

           if (starts[i] < ends[j]) {
               numOfRooms ++;
           } else {
               numOfRooms --;
               j ++;
           }
           max = Math.max(numOfRooms, max);
       }
       return max;

    }
}

