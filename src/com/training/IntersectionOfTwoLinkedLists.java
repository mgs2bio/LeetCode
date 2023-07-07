package com.training;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        System.out.println(getIntersectionNode(a1, b1));
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        int diff = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != null) {
            currentA = currentA.next;
            lengthA++;
        }
        while (currentB != null) {
            currentB = currentB.next;
            lengthB++;
        }
        diff = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        }
        if (lengthB > lengthA) {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        currentA = headA;
        currentB = headB;
        while (currentA != null) {
            if (currentA == currentB) {
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
