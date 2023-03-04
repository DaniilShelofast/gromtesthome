package lesson3;

public class FindOdd {
    public static void main(String[] args) {

        int b = 5;
        int sum = 0;
        for (int a = 0; a <= 1000; a++) {
            if (a % 2 == 1) {
                sum += a;
                System.out.println("Found");
            }
        }
        sum *= b;
        if (sum > 5000) {
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller or equal");
        }
    }
}
