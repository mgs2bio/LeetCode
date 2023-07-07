package com.training;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Write a function to find the longest common prefix string amongst an array of strings.
//
//        If there is no common prefix, return an empty string "".
//
//
//
//        Example 1:
//
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
//        Example 2:
//
//        Input: strs = ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
public class LongestCommonPrefix {

    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix1(new String[]{"flower", "flow", "flight"}));
//        System.out.println(longestCommonPrefix1(new String[]{"b",""}));
        System.out.println(longestCommonPrefix(new String[]{"cir", "car"}));
    }


    public static String longestCommonPrefix(String[] strs) {
        Queue<String> queue = new LinkedList<>();
        if (strs.length == 1) {
            return strs[0];
        }
        String first = strs[0];
        char[] chars = first.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < chars.length; j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < j + 1 || strs[i].charAt(j) != chars[j]) {
                    return sb.toString();
                }
                if (i == strs.length - 1) {
                    sb.append(chars[j]);
                }
            }
        }
        return sb.toString();
    }


}






