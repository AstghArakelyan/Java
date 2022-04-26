package com.tasks.functional;

import java.util.*;
import java.util.stream.Collectors;

public class Tasks {
    public void oddNumbersAverage(List<Integer> list) {
        OptionalDouble average = list.stream()
                .filter(value -> value % 2 != 0)
                .filter(value -> value % 5 == 0)
                .mapToInt(Integer::intValue)
                .average();
        average.ifPresent(System.out::println);
    }

    public long uniqueStringsCount(List<String> list) {
       /*
            list.stream()
                .filter(value -> value.length() > 8)
                    .collect(Collectors.toSet())
                    .size()
         */

        return list.stream()
                .filter(value -> value.length() > 8)
                .distinct()
                .count();
    }

    public int mapValuesSum(Map<String, Integer> map) {
        return map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public String numberToStringAndConcat(List<Integer> list) {
        return list.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
