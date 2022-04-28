package com.tasks.multythreading;

import java.util.Random;

public final class RandomUtil {
    private static final Random RANDOM = new Random();
    private static final int DEFAULT_BOUND = 10;

    public static int getRandomValue() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

    public static int getRandomValue(int bound) {
        return RANDOM.nextInt(bound);
    }
}
