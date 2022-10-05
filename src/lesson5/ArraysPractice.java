package lesson5;

public class ArraysPractice {
    public static void main(String[] args) {
        int[] array = {10, 11, 1000, 0, -3, 33, 990, 0, -1};
        System.out.println(maxElement(array));
        System.out.println(nCount( array , 0));
    }

    public static int maxElement(int[] array) {
        int max = array[0];
        for (int el : array) {
            if (el > max)
                max = el;
        }
        return max;
    }

    public static int nCount(int[] array, int n) {
        int element = 0;
        for (int el : array) {
            if (el == n)
                element++;
        }
        return element++;
    }
}