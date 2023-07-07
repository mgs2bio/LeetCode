package com.training;

//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
//        or -1 if needle is not part of haystack.
//Input: haystack = "sadbutsad", needle = "sad"
//        Output: 0
//        Explanation: "sad" occurs at index 0 and 6.
//        The first occurrence is at index 0, so we return 0.
//Input: haystack = "leetcode", needle = "leeto"
//        Output: -1
//        Explanation: "leeto" did not occur in "leetcode", so we return -1.
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        System.out.println(strStr("abc",  "c"));
    }


    public static int strStr(String haystack, String needle) {
       int length = needle.length();
       if (haystack.length() < length) {
           return -1;
       }
       if (haystack.length() == length) {
           return haystack.equals(needle) ? 0 : -1;
       }
       for (int i = 0; i < haystack.length() - length +1; i ++) {
           if (haystack.substring(i, i + length).equals(needle)) {
               return i;
           }
       }
       return -1;
    }
}
