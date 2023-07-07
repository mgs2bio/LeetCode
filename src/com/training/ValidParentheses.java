package com.training;

import java.util.*;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.
//
//
//        Example 1:
//
//        Input: s = "()"
//        Output: true
//        Example 2:
//
//        Input: s = "()[]{}"
//        Output: true
//        Example 3:
//
//        Input: s = "(]"
//        Output: false
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("(()()"));
    }


    public static boolean isValid(String s) {
        Stack<Character> sk = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                sk.push(c);
                continue;
            }
            if (sk.isEmpty()) {
                return false;
            }
            if (c == ')' && sk.pop() != '(') {
                return false;
            }
            if (c == ']' && sk.pop() != '[') {
                return false;
            }
            if (c == '}' && sk.pop() != '{') {
                return false;
            }
        }
        return sk.isEmpty();
    }
}
