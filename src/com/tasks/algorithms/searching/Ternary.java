package com.tasks.algorithms.searching;

public class Ternary {
    public static void main(String[] args) {
        int[] sortedArray = {0, 3, 7, 8, 17, 28, 51};
        int searchedItem = 8;

        Ternary ternarySearch = new Ternary();
        int index = ternarySearch.search(sortedArray, 0, sortedArray.length - 1, searchedItem);
        System.out.println(index);
    }

    public int search(int[] sortedArray, int left, int right, int searchedItem) {
        if (left <= right) {
            int firstMidIndex = left + (right - left) / 2;
            int secondMidIndex = right - (right - left) / 2;
            if (searchedItem == sortedArray[firstMidIndex]) {
                return firstMidIndex;
            }
            if (searchedItem == sortedArray[secondMidIndex]) {
                return secondMidIndex;
            }
            if (searchedItem < sortedArray[firstMidIndex]) {
                return search(sortedArray, left, firstMidIndex - 1, searchedItem);
            }
            if (searchedItem > sortedArray[secondMidIndex]) {
                return search(sortedArray, secondMidIndex + 1, right, searchedItem);
            }
            return search(sortedArray, firstMidIndex + 1, secondMidIndex - 1, searchedItem);
        } else {
            return -1;
        }
    }
}
