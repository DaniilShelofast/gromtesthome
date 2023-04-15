package lesson32;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        readNumbers();
    }

    public static int readNumbers() throws Exception {
        Scanner scanner = new Scanner(System.in).useDelimiter("[\\s,;]+");
        int suma = 0;
        System.out.println("Hello, before you calculate, write down the numbers.Thank you! ");

        try {
            String string = scanner.nextLine();
            suma = sum(string);
            System.out.println("The sum of these numbers : " + suma);
            return suma;
        } catch (Exception e) {
            System.err.println("Your numbers are wrong. You have " + 1 + " attempts to try again");
        }

        try {
            String string = scanner.nextLine();
            suma = sum(string);
            System.out.println("The sum of these numbers : " + suma);
            return suma;
        } catch (Exception e) {
            System.err.println("Your numbers are wrong. You have " + 2 + " attempts to try again");
        }

        try {
            String string = scanner.nextLine();
            suma = sum(string);
            System.out.println("The sum of these numbers : " + suma);
            return suma;
        } catch (Exception e) {
            System.err.println("Your numbers are wrong.Number of attempts exceeded");
            throw new Exception("Error...");
        }
    }

    private static int sum(String string) throws Exception {
        int suma = 0;
        String[] strings = string.split(" ");

        if (strings.length > 10) {
            throw new Exception("Error.");
        }

        for (String s : strings) {
            if (isDigitPresent(s) && numberCheck(s)) {
                suma += Integer.parseInt(s.trim());
            }
        }
        return suma;
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
