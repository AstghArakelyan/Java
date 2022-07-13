package com.tasks.algorithms.searching;

public class Binary {
    public static void main(String[] args) {
        int[] sortedArray = {0, 3, 7, 8, 17, 28, 36, 51};
        int searchedItem = 51;

        Binary binary = new Binary();
        System.out.println(binary.binarySearch(sortedArray, searchedItem, 0, sortedArray.length - 1));
    }

    public int binarySearch(int[] sortedArray, int searchedItem, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (searchedItem == sortedArray[mid]) {
                return mid;
            }
            if (searchedItem < sortedArray[mid]) {
                return binarySearch(sortedArray, searchedItem, 0, mid);
            }
            return binarySearch(sortedArray, searchedItem, mid + 1, sortedArray.length - 1);
        }
        return -1;
    }
}
