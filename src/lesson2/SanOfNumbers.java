package lesson2;

public class SanOfNumbers {
    public static void main(String[] args) {

        int sum = 0;
        for (int a = 0; a <= 1000; a++) {
            sum += a;

        }

        int b = 1234;
        int c1 = sum / b;
        int c2 = sum % b;
      //  System.out.println(c1);
      //  System.out.println(c2);
        System.out.println(c1 > c2);


    }
}
