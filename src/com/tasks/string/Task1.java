package com.tasks.string;

public class Task1 {
    public static void main(String[] args) {
        String firstName = "john";
        String lastName = "Williams";
        String patronymic = "johnson";
        Task1 task = new Task1();

        System.out.println(task.format(firstName, lastName, patronymic));
    }

    public String format(String firstName, String lastName, String patronymic) {
        char firstNameChar = Character.toUpperCase(firstName.charAt(0));
        char lastNameChar = Character.toUpperCase(lastName.charAt(0));
        char patronymicChar = Character.toUpperCase(patronymic.charAt(0));

        return String.format("%s.%s.%s", firstNameChar, lastNameChar, patronymicChar);
    }
}
