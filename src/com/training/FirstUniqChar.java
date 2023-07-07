package com.training;

import java.util.HashMap;
import java.util.Map;

//Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
public class FirstUniqChar {

    public static void main(String[] args) {
    }

    public static int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Boolean repeated = map.get(chars[i]);
            if (repeated == null) {
                map.put(chars[i], false);
            } else {
                map.put(chars[i], true);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])) {
                return i;
            }
        }
        return -1;
    }


    public static int firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), true);
            } else {
                map.put(s.charAt(i), false);
            }
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])) {
                return i;
            }
        }
        return -1;
    }
}
