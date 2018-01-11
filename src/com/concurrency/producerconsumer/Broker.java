package com.concurrency.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.Setter;

/**
 * Broker Class
 */
@Getter
public class Broker {

    @Setter
    private Boolean continueProducing;
    private ArrayBlockingQueue<Integer> queue;

    public Broker() {
        this.queue = new ArrayBlockingQueue<Integer>(100);
        this.continueProducing = Boolean.TRUE;
    }

    public void put(Integer data) throws InterruptedException {
        this.queue.put(data);
    }

    public Integer get() throws InterruptedException {
        return this.queue.poll(1, TimeUnit.SECONDS);
    }
}
