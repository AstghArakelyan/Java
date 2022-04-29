package com.tasks.concurrent;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Tasks {
     public void firstTask() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int seconds = scanner.nextInt();
            if (seconds < 0) {
                break;
            }
            executorService.submit(() -> {
                Integer counter = threadLocal.get();
                threadLocal.set(counter == null ? 1 : ++counter);
                System.out.printf("%s thread, task %d %n",
                        Thread.currentThread().getName(),
                        threadLocal.get());
                Thread.sleep(seconds * 1000L);
                System.out.printf("%s thread sleep %d seconds %n",
                        Thread.currentThread().getName(), seconds);
                return seconds;
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10L, TimeUnit.MINUTES);
    }

    public void secondTask() {
        int[] array = new int[15_000_000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(300) + 1;
        }
        trackTime(() -> findMax(array));
        trackTime(() -> findMaxParallel(array));
    }

    private int trackTime(Supplier<Integer> task) {
        long startTime = System.currentTimeMillis();
        int result = task.get();
        System.out.println(result + ": " + (System.currentTimeMillis() - startTime));
        return result;
    }

    private int findMax(int[] array) {
        return IntStream.of(array)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private int findMaxParallel(int[] array) {
        return IntStream.of(array)
                .parallel()
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
