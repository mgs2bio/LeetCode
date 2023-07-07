package com.training;

import java.util.Stack;
import java.util.stream.IntStream;

//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
//        Input: head = [1,2,3,4,5], n = 2
//        Output: [1,2,3,5]
//        Example 2:
//
//        Input: head = [1], n = 1
//        Output: []
//        Example 3:
//
//        Input: head = [1,2], n = 1
//        Output: [1]
public class RemoveNthNodeFromEndofList {


    public static void main(String[] args) {

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next = head.next;
        Stack<ListNode> sk = new Stack<>();
        sk.push(head);
        ListNode ans = null;
        while (next != null) {
            sk.add(next);
            next = next.next;
        }
        IntStream.range(1, n).forEach(i -> sk.pop());
        ListNode toRemove = sk.pop();
        ListNode parent = sk.isEmpty() ? null : sk.pop();
        ListNode child = toRemove.next;
        if (parent == null) {
            ans = child;
            toRemove.next = null;
            return ans;
        }
        parent.next = child;
        return head;
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
