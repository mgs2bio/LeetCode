package com.training;

//Given a string s, find the length of the longest
//        substring
//        without repeating characters.
//
//
//
//        Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring]]

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(lengthOfLongestSubstring1("bbbbb"));
        System.out.println(lengthOfLongestSubstring1("pwwkew"));
        System.out.println(lengthOfLongestSubstring1("dvdf"));
        System.out.println(lengthOfLongestSubstring1("tmmzuxt"));
    }


    private static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int first = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(chars[i]);
            if (index != null && index >= first) {
                first = index + 1;
            }
            map.put(chars[i], i);
            maxLength = Math.max(maxLength, i - first + 1);
        }
        return maxLength;
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int max = 1;
        int begin = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            final Integer previous = map.get(arr[i]);
            if (previous != null && begin <= previous) {
                max = Math.max(max, i - begin);
                begin = previous + 1;
            }
            if (i == arr.length - 1) {
                max = Math.max(max, i - begin + 1);
            }
            map.put(arr[i], i);
        }
        return max;
    }
}
