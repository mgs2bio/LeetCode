package com.training;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWORepeatingChar {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int max = 0;
        String tmp = s;
        for (int i = 0; i< s.length() -1; i++) {
            for (int j = s.length() -1; j>=i; j--) {
                String sb = s.substring(i, j);
                if (!containRepeats(sb)) {
                    int length = sb.length();
                    System.out.println(sb);
                    max = length > max ? length : max;
                }
            }
        }
       return max;
    }

    private static boolean containRepeats(String tmp) {
       return tmp.length() !=
               Arrays.stream(tmp.split(""))
                       .distinct()
                       .count();
    }
}
