package com.concurrency.producerconsumer;

/**
 * Producer Class 
 */
public class Producer implements Runnable {

    private Broker broker;

    public Producer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        try {
            for (Integer index = 0; index < 5; index++) {
                System.out.println("Producer produced: " + index);
                Thread.sleep(100);
                this.broker.put(index);
            }
            this.broker.setContinueProducing(Boolean.FALSE);
            System.out.println("Producer finished its job; terminating.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
