package com.training;

import java.util.List;

public class ReverseLinkedList {
    public static class ListNode {
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

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(reverseList(node1));
    }

    private static ListNode reverseList1(ListNode head) {
        ListNode reversed = reverseListRecursively1(head.next);
        if (reversed != null) {
            head.next = null;
        }
        return reversed;
    }

    private static ListNode reverseListRecursively1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reversed = reverseListRecursively(head.next);
        if (reversed != null) {
            head.next.next = head;
        } else {
            reversed = head;
        }
        return reversed;
    }


    public static ListNode reverseList(ListNode head) {
        ListNode reversed = reverseListRecursively(head);
        if (head != null) {
            head.next = null;
        }
        return reversed;
    }

    public static ListNode reverseListRecursively(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reversed = reverseListRecursively(head.next);
        if (head.next != null) {
            head.next.next = head;
        }
        if (reversed != null) {
            return reversed;
        } else {
            return head;
        }
    }
}
