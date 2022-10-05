package lesson5;


import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] number = {3, 66, 1, 43, 2, 8};

        int[] a = sortAscending(number);
        System.out.println(Arrays.toString(a));

        System.out.print("\n    \n");

        int[] b = sortDescending(number);
        System.out.println(Arrays.toString(b));
    }

    public static int[] sortAscending(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int el = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    el = j;
                }
            }
            if (i != el){
                int abc = arr[i];
                arr[i] = arr[el];
                arr [el] = abc;
            }
        }
        return arr;
    }
    public static int[] sortDescending(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int ab = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= max) {
                    max = arr[j];
                    ab = j;
                }
            }

            if (ab != max) {
                int to = arr[i];
                arr[i] = arr[ab];
                arr[ab] = to;
            }
        }
        return arr;
    }
}

