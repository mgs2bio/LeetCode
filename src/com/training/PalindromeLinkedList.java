package com.training;

import java.util.List;

//Given the head of a singly linked list, return true if it is a palindrome
// or false otherwise.
//Input: head = [1,2,2,1]
//        Output: true
//Input: head = [1,2]
//Output: false
public class PalindromeLinkedList {


    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
           return true;
        }
        if (head.next.next == null) {
            return head.next.val == head.next.next.val;
        }
        ListNode slow = head, fast = head;
        boolean even = false;
        while (true) {
            if (fast.next == null) {
                break;
            }
            if (fast.next.next == null) {
                even = true;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextHalf;
        if (even) {
            nextHalf = slow.next;

        } else {
            nextHalf = slow.next.next;
        }
        reverse(nextHalf);
        return false;
    }

    private void reverse(ListNode nextHalf) {

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
