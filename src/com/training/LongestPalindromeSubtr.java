package com.training;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//Given a string s, return the longest
//        palindromic
//
//        substring
//        in s.
//
//
//
//        Example 1:
//
//        Input: s = "babad"
//        Output: "bab"
//        Explanation: "aba" is also a valid answer.
//        Example 2:
//
//        Input: s = "cbbd"
//        Output: "bb"
public class LongestPalindromeSubtr {

    public static void main(String[] args) {

        System.out.println(longestPalindrome1("cbbd"));
        System.out.println(longestPalindrome1("babad"));
    }

    private static boolean isPalinDrome1(String substr) {
        return substr.equals(new StringBuilder(substr).reverse().toString());
    }

    public static String longestPalindrome1(String s) {
        int length = s.length();
        String result = "";

        for (int i = 1; i <= length; i++) {
            int j = 0;
            while (i - j - 1 >= 0 && i + j <= length) {
                String substr = s.substring(i - j - 1, i + j);
                if (isPalinDrome1(substr)) {
                    result = result.length() < substr.length() ? substr : result;
                    j++;
                    continue;
                }
                break;
            }
            j = 0;
            while (i + j + 1 <= length) {
                String substr = s.substring(i, i + j + 1);
                if (isPalinDrome1(substr)) {
                    result = result.length() < substr.length() ? substr : result;
                    j++;
                    continue;
                }
                break;
            }

        }
        return result;

    }


    public static String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sb = s.substring(i, j);
                if (isPalindrome(sb) && sb.length() > longest.length()) {
                    longest = sb;
                }
            }
        }
        return longest;
    }

    public static boolean isPalindrome(String s) {
        List<String> sl = Arrays.asList(s.split(""));
        Collections.reverse(sl);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sl.size(); i++) {
            sb.append(sl.get(i));
        }
        return s.equals(sb.toString());
    }

}
