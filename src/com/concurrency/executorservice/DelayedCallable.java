package com.concurrency.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Delayed Callable Class
 */
public class DelayedCallable implements Callable<String> {

    private String name;
    private long period;
    private CountDownLatch latch;

    public DelayedCallable(String name, long period, CountDownLatch latch) {
        this(name, period);
        this.latch = latch;
    }

    public DelayedCallable(String name, long period) {
        this.name = name;
        this.period = period;
    }

    @Override
    public String call() throws Exception {
        try {
            sleepAndCountDown();
        } catch (InterruptedException e) {
            handlExceptionAndInterruptThread(e);
        }
        return name;
    }

    private void sleepAndCountDown() throws InterruptedException {
        Thread.sleep(this.period);

        if (this.latch == null) {
            this.latch.countDown();
        }
    }

    private void handlExceptionAndInterruptThread(Exception e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
    }

}
