package com.tasks.reflection.ormSimulation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Runner {
    public String generateInsert(Car car) {
        String template = "INSERT INTO %s.%s (%s) VALUES(%s)";
        Table table = car.getClass().getAnnotation(Table.class);
        Field[] fields = car.getClass().getDeclaredFields();

        String fieldNames = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .sorted(Comparator.comparing(Field::getName))
                .map(field -> field.getAnnotation(Column.class))
                .map(Column::value)
                .collect(Collectors.joining(", "));

        String fieldValues = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .sorted(Comparator.comparing(Field::getName))
                .peek(field -> field.setAccessible(true))
                .map(field -> {
                    try {
                        return String.valueOf(field.get(car));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return "";
                    }
                })
                .map(value -> "'" + value + "'")
                .collect(Collectors.joining(", "));

        return  String.format(template, table.schema(), table.value(), fieldNames, fieldValues);
    }
}
