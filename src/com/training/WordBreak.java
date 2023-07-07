package com.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println("hellow".startsWith("ell", 1));
        System.out.println(wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return wordBreak1(s, 0, wordDict, memo);
    }

    public static boolean wordBreak1(String s, int nextStart, List<String> wordDict, Boolean[] memo) {
        Boolean isFound = false;
        String subStr = s.substring(nextStart);
        for (int i = subStr.length(); i >= 1; i--) {
            if (wordDict.contains(subStr.substring(0, i))) {
                if (i == subStr.length()) {
                    return true;
                }
                isFound = memo[nextStart + i];
                if (isFound == null) {
                    if (wordBreak1(s, nextStart + i, wordDict, memo)) {
                        return memo[nextStart + i] = true;
                    }
                    memo[nextStart + i] = false;
                }
            }
        }
        return memo[nextStart] = false;
    }
}
