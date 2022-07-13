package com.tasks.algorithms.sorting;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] array = {54, 3, 17, 36, 21, 8, 0, 79};
        Selection selectionSort = new Selection();
        selectionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array) {
        int temp;
        int minElementIndex;
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            minElementIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            temp = array[minElementIndex];
            array[minElementIndex] = array[i];
            array[i] = temp;
        }
    }
}
