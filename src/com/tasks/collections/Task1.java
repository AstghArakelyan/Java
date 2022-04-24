package com.tasks.collections;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Task1 task = new Task1();
        Map<Integer, Integer> firstPolynomial = Map.of(
                0, 5,
                1, 3,
                3, 2,
                5, 4,
                6, 7
        );
        Map<Integer, Integer> secondPolynomial = Map.of(
                0, 5,
                3, 4,
                5, 5,
                6, 1
        );

        System.out.println("Result: " + task.convertToString(task.sum(firstPolynomial, secondPolynomial)));
    }

    private String convertToString(Map<Integer, Integer> sumResult) {
        Map<Integer, Integer> reversedResult = new TreeMap<>(Comparator.reverseOrder());
        reversedResult.putAll(sumResult);
        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: reversedResult.entrySet()) {
            String polynomial = entry.getKey() == 0
                    ? String.valueOf(entry.getValue())
                    : entry.getValue() + "^x" + entry.getKey();
            list.add(polynomial);
        }
        return String.join("+", list);
    }
    private Map<Integer, Integer> sum(Map<Integer, Integer> firstPolynomial,
                                      Map<Integer, Integer> secondPolynomial) {
        Map<Integer, Integer> sumResult = new HashMap<>(firstPolynomial);
        for (Map.Entry<Integer, Integer> entry: secondPolynomial.entrySet()) {
            sumResult.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return sumResult;
    }
}
