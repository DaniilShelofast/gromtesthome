package lesson4;

public class MethodExample {
    public static void main(String[] args) {
        int result = increment(30, 20);
        System.out.println(result);

        System.out.println(min(increment(30, 20), 11));

    }

    public static int increment(int a, int index) {
        System.out.println("method invoked");
        a += index;
        System.out.println("method before return");
        return a;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
