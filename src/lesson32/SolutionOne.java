package lesson32;

import java.util.Scanner;

public class SolutionOne {

    public static int readNumbers() throws Exception {
        System.out.println("Hello, before you calculate, write down the numbers.Thank you! ");
        try {
            return countNumbers();
        } catch (Exception e) {
            System.err.println("Your numbers are wrong. You have " + 2 + " attempts to try");
        }

        try {
            return countNumbers();
        } catch (Exception e) {
            System.err.println("Your numbers are wrong. You have " + 1 + " attempts to try");
        }

        try {
            return countNumbers();
        } catch (Exception e) {
            System.err.println("Your numbers are wrong.Number of attempts exceeded");
            throw new Exception("Error...");
        }
    }

    private static int countNumbers() throws Exception {
        Scanner scanner = new Scanner(System.in).useDelimiter("[\\s,;]+");
        String string = scanner.nextLine();
        System.out.println("The sum of these numbers : " + sumNumbers(string));
        return sumNumbers(string);
    }

    private static int sumNumbers(String string) throws Exception {
        int sum = 0;
        String[] strings = string.split(" ");

        if (strings.length > 10) {
            throw new Exception("Error.");
        }

        for (String s : strings) {
            if (isDigitPresent(s.trim()) && Integer.parseInt(s) <= 100) {
                sum += Integer.parseInt(s.trim());
            } else {
                throw new Exception("Error.");
            }
        }
        return sum;
    }


    private static boolean isDigitPresent(String string) throws Exception {
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                throw new Exception("Error.");
            }
        }
        return true;
    }
}

