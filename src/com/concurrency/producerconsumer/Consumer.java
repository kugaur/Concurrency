package com.concurrency.producerconsumer;

/**
 * Consumer Class 
 */
public class Consumer implements Runnable {

    private String name;
    private Broker broker;

    public Consumer(String name, Broker broker) {
        this.name = name;
        this.broker = broker;
    }

    @Override
    public void run() {
        try {
            Integer data = broker.get();
            while (broker.getContinueProducing() || data != null) {
                Thread.sleep(1000);
                data = broker.get();
                System.out.println("Consumer " + this.name + " processed data from broker: " + data);
            }
            System.out.println("Comsumer " + this.name + " finished its job; terminating.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
