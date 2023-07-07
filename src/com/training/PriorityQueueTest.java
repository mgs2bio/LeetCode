package com.training;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((i, j) -> i - j);
        queue.add(3);
        queue.add(1);
        queue.add(2);

        while (queue.size() > 0) {
            System.out.println(queue.remove());
        }

    }
}