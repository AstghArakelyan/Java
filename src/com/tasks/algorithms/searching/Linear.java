package com.tasks.algorithms.searching;

public class Linear {
    public static void main(String[] args) {
        int[] array = {10, 3, 7, 14, 25, 39, 8};
        int searchedItem = 14;
        Linear linear = new Linear();

        System.out.println(linear.linearSearch(array, searchedItem));
    }

    public int linearSearch(int[] array, int searchedItem) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchedItem)
                return i;
        }
        return -1;
    }
}
