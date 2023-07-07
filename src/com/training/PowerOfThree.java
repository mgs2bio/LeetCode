package com.training;
//Given an integer n, return true if it is a power of three. Otherwise, return false.
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(5));
    }



    public static boolean isPowerOfThree(int n) {
        double d = Math.log10(n)/Math.log10(3);
        int i = (int) d;
        return i == d;
    }
}
