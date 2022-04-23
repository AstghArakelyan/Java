package com.tasks.string;

public class Task2 {
    public static void main(String[] args) {
        String value = String.join("Jane is taken in by people she later discovers are her cousins.",
                "One of them is St. John, a principled clergyman. He gives her a job and soon proposes marriage,",
                "suggesting that she join him as a missionary in India! Jane initially agrees to leave with him",
                "but not as his wife. However, St. John pressures her to reconsider his proposal,",
                "and a wavering Jane finally appeals to Heaven to show her what to do.");
        Task2 task = new Task2();

        System.out.println(task.countSymbols(value));
    }

    public int countSymbols(String value) {
        String valueWithoutSymbols = value.replace(".", "")
                .replace(",", "")
                .replace("!", "");
        return value.length() - valueWithoutSymbols.length();
    }
}
