package com.tasks.algorithms.sorting;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] array = {54, 3, 17, 21, 8, 0, 79};
        Bubble bubble = new Bubble();
        bubble.bubbleSort(array);
    }

    public void bubbleSort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
