package com.training;


//The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
//
//        countAndSay(1) = "1"
//        countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
//        To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
//
//        For example, the saying and conversion for digit string "3322251":
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }


    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String digitStr = countAndSay(n - 1);
        int repeats = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digitStr.length(); i++) {
            if (i == digitStr.length() -1) {
                sb.append(repeats).append(digitStr.charAt(i));
                break;
            }
            if (digitStr.charAt(i) == digitStr.charAt(i + 1)) {
                repeats++;
            } else {
                sb.append(repeats).append(digitStr.charAt(i));
                repeats = 1;
            }
        }
        return sb.toString();
    }

}
