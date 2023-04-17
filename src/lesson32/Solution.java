package lesson32;

import java.util.Scanner;

public class Solution {

    public static int readNumbers() throws Exception {
        System.out.println("Hello, before you calculate, write down the numbers.Thank you! ");
        try {
            return countNumbers();
        } catch (Exception e) {
            System.err.println("Your numbers are wrong. You have " + 1 + " attempts to try again");
        }

        try {
            return countNumbers();
        } catch (Exception e) {
            System.err.println("Your numbers are wrong. You have " + 2 + " attempts to try again");
        }

        try {
            return countNumbers();
        } catch (Exception e) {
            System.err.println("Your numbers are wrong.Number of attempts exceeded");
            throw new Exception("Error...");
        }
    }

    private static int countNumbers() throws Exception {
        int count = 0;
        Scanner scanner = new Scanner(System.in).useDelimiter("[\\s,;]+");
        String string = scanner.nextLine();
        count = sumNumbers(string);
        System.out.println("The sum of these numbers : " + count);
        return count;
    }

    private static int sumNumbers(String string) throws Exception {
        int sum = 0;
        String[] strings = string.split(" ");

        if (strings.length > 10) {
            throw new Exception("Error.");
        }

        for (String s : strings) {
            if (isDigitPresent(s) && numberCheck(s)) {
                sum += Integer.parseInt(s.trim());
            }
        }
        return sum;
    }

    private static boolean numberCheck(String string) throws Exception {
        if (Integer.parseInt(string) <= 100) {
            return true;
        }
        throw new Exception("Error.");
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
