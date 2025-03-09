package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707)); // true
        System.out.println(isPalindrome(11212)); // false

        // Mükemmel sayı testi
        System.out.println(isPerfectNumber(6)); // true
        System.out.println(isPerfectNumber(28)); // true
        System.out.println(isPerfectNumber(5)); // false
        System.out.println(isPerfectNumber(-1)); // false

        // Sayıyı kelimelere dökme testi
        numberToWords(123); // "One Two Three"
        numberToWords(1010); // "One Zero One Zero"
        numberToWords(-12); // "Invalid Value"

    }

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        // Negatif sayıları pozitif hale getirme
        if (number < 0) {
            number = -number;
        }

        while (number > 0) {
            int lastDigit = number % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            number /= 10;
        }

        return reversedNumber == Math.abs(originalNumber);
    }

    // Mükemmel sayıyı kontrol eden metod
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // Sayıyı kelimelere döken metod
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        String[] words = {
                "Zero", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine"
        };

        StringBuilder result = new StringBuilder();
        String numberStr = Integer.toString(number);

        for (char digit : numberStr.toCharArray()) {
            result.append(words[digit - '0']).append(" ");
        }

        return result.toString().trim(); // Trim ile sondaki boşluğu kaldırıyoruz
    }

}
