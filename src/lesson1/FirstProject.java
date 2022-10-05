package lesson1;

import lesson9.utils.Checker;

public class FirstProject {
    public static void main(String[] args) {
        System.out.println("I am studying Java");
        System.out.println("Done");

        Checker checker = new Checker();
        System.out.println(checker.checkCompanyName("Google"));

    }
}
