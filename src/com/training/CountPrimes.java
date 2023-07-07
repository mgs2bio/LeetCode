package com.training;

import java.util.Arrays;
import java.util.stream.Stream;

public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes(15));
    }


    public static int countPrimes(int n) {
        Boolean[] isPrime = new Boolean[n];
        Arrays.fill(isPrime, true);
        long c = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    isPrime[j] = false;
                }
                c++;
            }
        }
        return (int) c;
    }
}
