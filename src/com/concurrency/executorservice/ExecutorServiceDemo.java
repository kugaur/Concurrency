package com.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demo Class
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> {
            new Task();
        });
        executor.shutdown();
        executor.shutdownNow();
        try {
            executor.awaitTermination(20l, TimeUnit.NANOSECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
