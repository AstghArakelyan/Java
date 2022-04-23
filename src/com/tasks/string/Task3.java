package com.tasks.string;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int n = 3;
        String value = "0123456789";
        Task3 task = new Task3();

        System.out.println(Arrays.toString(task.split(value, n)));
    }

    public String[] split(String value, int n) {
        int arraySize = (int) Math.ceil(value.length() / (double) n);
        String[] array = new String[arraySize];
        int currentIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < value.length(); i += n) {
            endIndex = Math.min(value.length(), i + n);
            array[currentIndex++] = value.substring(i, endIndex);
        }
        return array;
    }
}
