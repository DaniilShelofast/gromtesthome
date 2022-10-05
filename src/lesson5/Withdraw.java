package lesson5;

import java.util.Arrays;

public class Withdraw {
    public static void main(String[] args) {

        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nicolai", "Irina"};
        int[] balances = {10, 200, 8432, -99, 12000, -54, 0};

        int result =  withdraw(names, balances, "Denis", 100);
        System.out.println(Arrays.toString(balances));
        System.out.println(result);
    }

    public static int withdraw(String[] clients, int[] balances, String client, int money) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) {
                break;
            }
            clientIndex++;
        }

        if (money > balances[clientIndex]){
            return -1;
        }

        balances[clientIndex] -= money;

        return balances[clientIndex];
    }
}
