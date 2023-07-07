package com.training;

//https://leetcode.com/problems/add-two-numbers/

//You are given two non-empty linked lists representing two non-negative integers.
//        The digits are stored in reverse order, and each of their nodes contains a single digit.
//        Add the two numbers and return the sum as a linked list.
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//Input: l1 = [2,4,3], l2 = [5,6,4]
//        Output: [7,0,8]
//        Explanation: 342 + 465 = 807.

import java.util.*;

public class AddTwoNumbers {

    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>(List.of(9, 9, 9, 9, 9, 9, 9));
        LinkedList<Integer> b = new LinkedList<>(List.of(9, 9, 9, 9));
//        System.out.println(addTwoNumbers(a, b));
        System.out.println(addTwoNumbers1(a, b));
        LinkedList<Integer> a0 = new LinkedList<>(List.of(0));
        LinkedList<Integer> b0 = new LinkedList<>(List.of(0));
        System.out.println(addTwoNumbers1(a0, b0));
    }


    private static LinkedList<Integer> addTwoNumbers1(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0, j = 0;
        boolean addOne = false;
        while (true) {
            int aVal = 0, bVal = 0;
            if (i < a.size()) {
                aVal = a.get(i);
                i++;
            }
            if (j < b.size()) {
                bVal = b.get(j);
                j++;
            }
            int sum = addOne ? aVal + bVal + 1 : aVal + bVal;
            if (sum < 10) {
                result.add(sum);
                addOne = false;
            } else {
                result.add(sum - 10);
                addOne = true;
            }
            if (i == a.size() && j == b.size()) {
                break;
            }
        }
        if (addOne) {
            result.add(1);
        }

        return result;
    }


    private static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> a, LinkedList<Integer> b) {
        int sum = toInt(a) + toInt(b);
        return toLinkedList(sum);
    }

    private static int toInt(LinkedList<Integer> num) {
        int sum = 0;
        for (int i = num.size() - 1; i >= 0; i--) {
            sum += num.get(i) * Math.pow(10, i);
        }
        System.out.println("Int:" + sum);
        return sum;
    }

    private static LinkedList toLinkedList(int num) {
        LinkedList<Integer> ll = new LinkedList<>();
        int temp = 0;
        while (num / 10 != 0) {
            ll.add(num % 10);
            num = num / 10;
        }
        ll.add(num);

        return ll;
    }

}
