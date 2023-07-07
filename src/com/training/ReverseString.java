package com.training;

//Write a function that reverses a string. The input string is given as an array of characters s.
//
//        You must do this by modifying the input array in-place with O(1) extra memory.
//
//
//
//        Example 1:
//
//        Input: s = ["h","e","l","l","o"]
//        Output: ["o","l","l","e","h"]
//        Example 2:
//
//        Input: s = ["H","a","n","n","a","h"]
//        Output: ["h","a","n","n","a","H"]

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        solution(chars);
        System.out.println(Arrays.toString(chars));
    }

    private static void solution(char[] chars) {
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }


    }
}
