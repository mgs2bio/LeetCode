package com.training;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//        A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//Example 1:
//
//        Input: digits = "23"
//        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        Example 2:
//
//        Input: digits = ""
//        Output: []
//        Example 3:
//
//        Input: digits = "2"
//        Output: ["a","b","c"]
public class LetterCombinationsofaPhoneNumber {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

//        System.out.println(letterCombinations("23"));
//        System.out.println(letterCombinations(""));
//        System.out.println(letterCombinations("2"));
    }


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        helper(digits, 0, "", res);
        return res;
    }

    private void helper(String digits, int index, String path, List<String> res) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            helper(digits, index + 1, path + c, res);
        }
    }
}
