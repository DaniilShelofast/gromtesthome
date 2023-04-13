package lesson32;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        readNumbers();
    }

    public static int readNumbers() throws Exception {
        Scanner scanner = new Scanner(System.in).useDelimiter("[\\s,;]+");
        int res = 0;

        try {

            System.out.println("Hello, before calculating, keep a number from 1-10. thank you ");
            String count = scanner.nextLine();
            checkSymbol(count);
            System.out.print(count + " !   enter numbers : ");
            String string = scanner.nextLine();
            res = sum(string);
            System.out.println("The sum of these numbers : " + res);
            return res;
        } catch (Exception e) {
            System.out.println("Your numbers are wrong. You have " + 3 + " attempts to try again");
        }

        try {

            System.out.println("Hello, before calculating, keep a number from 1-10. thank you");
            String count = scanner.nextLine();
            checkSymbol(count);
            System.out.print(count + "!" + " enter numbers : ");
            String string = scanner.nextLine();
            res = sum(string);
            System.out.println("The sum of these numbers : " + res);
            return res;
        } catch (Exception e) {
            System.out.println("Your numbers are wrong. You have " + 2 + " attempts to try again");
        }

        try {

            System.out.println("Hello, before calculating, keep a number from 1-10. thank you ");
            String count = scanner.nextLine();
            checkSymbol(count);
            System.out.print(count + "!" + " enter numbers : ");
            String string = scanner.nextLine();
            res = sum(string);
            System.out.println("The sum of these numbers : " + res);
            return res;
        } catch (Exception e) {
            System.out.println("Your numbers are wrong. You have " + 1 + " attempts to try again");
            System.err.println("Your numbers are wrong.Number of attempts exceeded");
            throw new Exception("Error...");
        }

    }

    private static boolean checkSymbol(String s) throws Exception {
        int i = 0;
        try {
            i = Integer.parseInt(s);
            if (99 < i) {
                throw new Exception("error :the number is available up to ninety nine.");
            }
            return true;
        } catch (Exception e) {
            System.err.println("error: error: The specified character is not a number, or it is possible because the number is greater than ninety-nine. ");
        }
        throw new Exception("Error.");
    }

    private static int sum(String string) throws Exception {
        int suma = 0;
        String[] strings = string.split(" ");

        for (String s : strings) {
            try {
                suma += Integer.parseInt(s.trim());

            } catch (Exception exception) {
                System.err.println("error : an error occurred in the array of numbers.");
            }
        }
        if (suma > 99) {
            throw new Exception("error : the number is greater than hundred.");
        }

        return suma;
    }
}
