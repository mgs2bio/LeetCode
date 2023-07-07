package com.training;


import java.util.LinkedList;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        Implement the MinStack class:
//
//        MinStack() initializes the stack object.
//        void push(int val) pushes the element val onto the stack.
//        void pop() removes the element on the top of the stack.
//        int top() gets the top element of the stack.
//        int getMin() retrieves the minimum element in the stack.
//        You must implement a solution with O(1) time complexity for each function.
public class MinStack {

    int min = Integer.MAX_VALUE;
    LinkedList<Integer> ls = new LinkedList<>();
    LinkedList<Integer> mins = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        min = Math.min(min, val);
        mins.add(min);
        ls.add(val);
    }

    public void pop() {
        ls.removeLast();
        mins.removeLast();
    }

    public int top() {
        return ls.getLast();
    }

    public int getMin() {
        return mins.getLast();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
