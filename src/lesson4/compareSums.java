package lesson4;

public class compareSums {
    public static void main(String[] args) {
        boolean res = compareSums(4, 10, 2, 10);
        System.out.println(res);

    }

    public static boolean compareSums(int a, int b, int c, int d) {

        int to = sum(a, b);
        int floe = sum(c, d);
        return to > floe;
    }

    public static int sum(int from, int to) {

        int sum = 0;
        while (from <= to) {
            from++;
            sum += from;
        }
        return sum;
    }
}

