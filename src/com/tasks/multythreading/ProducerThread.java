package com.tasks.multythreading;

import java.util.Queue;

public class ProducerThread implements Runnable {
    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() < 10) {
                    int randomValue = RandomUtil.getRandomValue();
                    list.add(randomValue);
                    System.out.println("Producer adds value " + randomValue + ". Size " + list.size());
                } else {
                    System.out.println("Producer does nothing");
                }
                list.notifyAll();
                try {
                    int randomWaitValue = RandomUtil.getRandomValue(5);
                    System.out.println("Producer waits: " + randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
