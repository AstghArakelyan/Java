package com.tasks.algorithms.sorting;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] array = {54, 3, 17, 36, 21, 8, 0, 79};
        Quick quickSort = new Quick();
        quickSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (array[j] < pivot) {
                swap(array, ++i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
