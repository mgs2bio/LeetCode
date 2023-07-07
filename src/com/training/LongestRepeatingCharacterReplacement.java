package com.training;

import java.util.HashSet;
import java.util.Set;

//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//        Return the length of the longest substring containing the same letter you can get after performing the above operations.
//
//
//
//        Example 1:
//
//        Input: s = "ABAB", k = 2
//        Output: 4
//        Explanation: Replace the two 'A's with two 'B's or vice versa.
//        Example 2:
//
//        Input: s = "AABABBA", k = 1
//        Output: 4
//        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//        The substring "BBBB" has the longest repeating letters, which is 4.
//        There may exists other ways to achive this answer too.

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        System.out.println('C' - 'A');
//        System.out.println(characterReplacement("ABAB", 2));
//        System.out.println(characterReplacement("AABABBA", 1));
    }


    public static int characterReplacement(String s, int k) {
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            int length = 1;
            int count = 0;
            int j = i + 1;
            while (j < s.length()) {
                if (s.charAt(j) != s.charAt(i)) {
                    count++;
                }
                if (count == k + 1) {
                    max = Math.max(max, length);
                    break;
                }
                length++;
                j++;
                if (j == s.length()) {
                    max = Math.max(max, length);
                    break;
                }
            }
        }
        return max;
    }
}
