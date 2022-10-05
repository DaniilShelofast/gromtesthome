package lesson8;

public class Arithmetic {
    public static void main(String[] args) {
       int[] array = {1, 2, 4, 5, 6, 7, 8, 11};

        System.out.println(check(array));

    }

    public static boolean check(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++)
            if (array[i] < min) {
                min = array[i];
            }

        for (int j = 1; j < array.length; j++)
            if (array[j] > max) {
                max = array[j];
            }

        int sum = 0;
        sum = min + max;

        return sum > 100;
    }
}
