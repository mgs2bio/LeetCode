package com.training;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class ThreadPractice {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(10);

        IntStream.range(0, 10).mapToObj(i -> new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(String.format("Thread %s started", i));
        }) {{
            setDaemon(false);
        }}).forEach(Thread::start);

        System.out.println("program ended");
    }
}
