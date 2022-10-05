package lesson8;

public class Adder extends Arithmetic {
    public static void main(String[] args) {
        int res = add(10, 22);
        System.out.println(res);
    }

    public static int add(int a, int b) {
        int sum = a + b;

        return sum;
    }
}
