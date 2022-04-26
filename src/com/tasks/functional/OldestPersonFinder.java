package com.tasks.functional;

import java.util.*;

public class OldestPersonFinder {
    public void findOldestPerson(List<Person> personsList) {
        personsList.stream()
                .filter(person -> person.getFullName().length() <= 15)
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getFullName)
                .ifPresent(System.out::println);
    }
}
