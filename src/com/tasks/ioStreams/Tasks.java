package com.tasks.ioStreams;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Tasks {
    public static void main(String[] args) {
        Tasks t = new Tasks();
        t.reverseOrder();
    }

    public void findWordsStartWithVowel(String folderName, String fileName) {
        String vowels = "аоуэеёияюы";
        Path path = Path.of(folderName, fileName);
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                char firstSymbol = word.charAt(0);
                if (vowels.indexOf(firstSymbol) >= 0) {
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void matchFirstLastChars(String folderName, String fileName) {
        Path path = Path.of(folderName, fileName);
        try (Scanner scanner = new Scanner(path)) {
            String prev = null;
            if (scanner.hasNext()) {
                prev = scanner.next();
            }
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (isEqualFirstCharLastChar(prev, current)) {
                    System.out.println(prev + " " + current);
                }
                prev = current;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isEqualFirstCharLastChar(String prev, String current) {
        return prev.charAt(prev.length() - 1) == current.charAt(0);
    }

    public void readFileAndFindMaxDigitsCount(String folderName, String fileName) {
        Path path = Path.of(folderName, fileName);
        try {
            Files.readAllLines(path).stream()
                    .map(this::findMaxDigitsCount)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Integer findMaxDigitsCount(String line) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                count++;
            } else {
                if (result < count) {
                    result = count;
                }
                count = 0;
            }
        }
        return result;
    }

    public void publicToPrivate(String fileName) {
        Path path = Path.of("src", "com", "tasks", "functional", "Tasks.java");
        try {
            String string = Files.readString(path);
            String result = string.replace("public", "private");
            Path newFilePath = Path.of("resources", fileName);
            Files.writeString(newFilePath, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void reverseOrder() {
        Path path = Path.of("resources", "text.txt");
        Path newFilePath = Path.of("resources", "newFile.txt");
        try (Stream<String> lines = Files.lines(path);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(newFilePath, APPEND, CREATE)) {
            lines.map(StringBuffer::new)
                    .map(StringBuffer::reverse)
                    .forEach(line -> {
                        try {
                            bufferedWriter.write(line.toString());
                            bufferedWriter.newLine();
                            ;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
