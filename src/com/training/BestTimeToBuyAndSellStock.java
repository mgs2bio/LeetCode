package com.training;

import java.util.*;
import java.util.stream.IntStream;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//    You want to maximize your profit by choosing a single day to buy one stock and choosing a
//    different day in the future to sell that stock.
//
//    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
//    return 0.
//Input: prices = [7,1,5,3,6,4]
//        Output: 5
//Input: prices = [7,6,4,3,1]
//        Output: 0
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }


    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int lpc = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i] < lpc) {
                lpc = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - lpc);
        }
        return maxProfit;
    }

}
