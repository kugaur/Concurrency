package com.concurrency.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Main File 
 */
public class Main {

    public static void main(String[] args) {
        Broker broker = new Broker();
        
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new Consumer("1", broker));
        threadPool.execute(new Consumer("2", broker));
        Future produceStatus = threadPool.submit(new Producer(broker));
        try {
            produceStatus.get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
            try {
                if (!threadPool.awaitTermination(80000, TimeUnit.MILLISECONDS)) {
                    threadPool.shutdownNow();
                } 
            } catch (InterruptedException e) {
                threadPool.shutdownNow();
            }
        }
    }
}
