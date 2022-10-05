package lesson4;

public class FindDiv {
    public static void main(String[] args) {

        short b = 10;
        short a = 5;
        int n = 2;

        System.out.println(findDivCount(a, b, n));

    }

    public static int findDivCount(short a, short b, int n) {

        int count = 0;
        while (a <= b) {
            if (a % n == 0) {
                count++;
            }
            a++;
        }
        return count;
    }

}


