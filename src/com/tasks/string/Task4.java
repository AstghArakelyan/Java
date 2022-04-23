package com.tasks.string;

public class Task4 {
    public static void main(String[] args) {
        String palindromeString = "palindrome";
        Task4 task = new Task4();

        System.out.println(task.isPalindrome(palindromeString));
    }
    private boolean isPalindrome(String palindromeString) {
        int i = 0;
        int j = palindromeString.length() - 1;

        while (i++ < j--) {
            if (palindromeString.charAt(i) != palindromeString.charAt(j))
                return false;
        }
        return true;
    }
}
