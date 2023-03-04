package lesson3;

public class TernaryOperator {
    public static void main(String[] args) {
        int a;
        byte b = 100;

        a = b > 200 ? 500 : 350;
        System.out.println(a);

        a = b > 200 ? b : b - 500;
        System.out.println(a);
    }
}
