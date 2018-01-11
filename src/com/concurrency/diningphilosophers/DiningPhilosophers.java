package com.concurrency.diningphilosophers;

/**
 * Main Class
 */
public class DiningPhilosophers {

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int index = 0; index < forks.length; index++) {
            forks[index] = new Object();
        }

        for (int index = 0; index < philosophers.length; index++) {
            Object leftFork = forks[index];
            Object rightFork = forks[(index + 1) % forks.length];

            if (index == philosophers.length - 1) {
                philosophers[index] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[index] = new Philosopher(leftFork, rightFork);
            }

            Thread thread = new Thread(philosophers[index], "Philosopher " + (index + 1));
            thread.start();
        }

    }
}
