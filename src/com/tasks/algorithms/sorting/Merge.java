package com.tasks.algorithms.sorting;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] array = {54, 3, 17, 36, 21, 8, 0, 79};
        Merge mergeSort = new Merge();
        mergeSort.sortArray(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void sortArray(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortArray(array, left, mid);
            sortArray(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftArrayLength = mid - left + 1;
        int rightArrayLength = right - mid;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];
        for (int i = 0; i < leftArrayLength; i++) {
            leftArray[i] = array[i + left];
        }
        for (int j = 0; j < rightArrayLength; j++) {
            rightArray[j] = array[j + mid + 1];
        }
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mergedArrayIndex = left;

        while (leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                array[mergedArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                array[mergedArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            mergedArrayIndex++;
        }

        while (leftArrayIndex < leftArrayLength) {
            array[mergedArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            mergedArrayIndex++;
        }
        while (rightArrayIndex < rightArrayLength) {
            array[mergedArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            leftArrayIndex++;
        }
    }
}
