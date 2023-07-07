package com.training;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        return isHappy(n, set);
    }

    public static boolean isHappy(int n, Set<Integer> set) {
        if (n == 1) {
            return true;
        }
        int next = 0;
        while (n % 10 > 0 || n / 10 > 0) {
            next = next + (int) Math.pow(n % 10, 2);
            n = n / 10;
        }
        if (!set.add(next)) {
            return false;
        }
        return isHappy(next, set);
    }
}
