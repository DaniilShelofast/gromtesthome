package lesson32;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        readNumbers();
    }

    public static void readNumbers() {
        int suma = 0;
        try {
            Scanner scanner = new Scanner(System.in).useDelimiter("[\\s,;]+");
            System.out.println("Hello, before calculating, keep a number from 1-10. thank you ");
            String count = scanner.nextLine();
            checkSymbol(count);
            System.out.print(count + " !   enter numbers : ");
            String string = scanner.nextLine();
            suma = validationAndCounting(string);
            System.out.println("The sum of these numbers : " + suma);
        } catch (Exception e) {
            System.out.println(" - Your numbers are wrong. You have n " + 1 + " attempts to try again");
        }

        try {
            Scanner scanner = new Scanner(System.in).useDelimiter("[\\s,;]+");
            System.out.println("Hello, before calculating, keep a number from 1-10. thank you");
            String count = scanner.nextLine();
            checkSymbol(count);
            System.out.print(count + "!" + " enter numbers : ");
            String string = scanner.nextLine();
            suma = validationAndCounting(string);
            System.out.println("The sum of these numbers : " + suma);
        } catch (Exception e) {
            System.out.println(" - Your numbers are wrong. You have n " + 2 + " attempts to try again");
        }

        try {
            Scanner scanner = new Scanner(System.in).useDelimiter("[\\s,;]+");
            System.out.println("Hello, before calculating, keep a number from 1-10. thank you ");
            String count = scanner.nextLine();
            checkSymbol(count);
            System.out.print(count + "!" + " enter numbers : ");
            String string = scanner.nextLine();
            suma = validationAndCounting(string);
            System.out.println("The sum of these numbers : " + suma);
        } catch (Exception e) {
            System.out.println(" - Your numbers are wrong. You have n " + 3 + " attempts to try again");
            System.out.println("Your numbers are wrong.Number of attempts exceeded");
        }
    }


    private static void checkSymbol(String s) throws Exception {
        int i = 0;
        try {
            i = Integer.parseInt(s);
            if (100 < i) {
                throw new Exception("error :available symbol < 100 ");
            }
        } catch (Exception e) {
            System.err.println("error: the specified character is not a number or there is a possible error due to a character > 100 . ");
        }
    }

    private static int validationAndCounting(String string) throws Exception {
        int suma = 0;
        String[] strings = string.split(" ");
        for (String s : strings) {
            if (strings.length > 10) {
                throw new Exception("error : the maximum number is ten numbers.");
            }
            try {
                suma = Integer.parseInt(s.trim());
            } catch (Exception exception) {
                System.err.println("error : an error occurred in the array of numbers, the maximum number is ten digits and can be led the letter. ");
            }
        }
        return suma;
    }
}
