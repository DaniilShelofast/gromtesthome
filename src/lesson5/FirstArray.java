package lesson5;

import java.util.Arrays;

public class FirstArray {
    public static void main(String[] args) {

      // перший варіант.

        int[] firstArray = new int[4];
        firstArray[0] = 11;
        firstArray[1] = 200;
        firstArray[2] = 10;

        for (int i = 0; i < firstArray.length; i++) {
            System.out.println(firstArray[i]);
        }
        System.out.println(Arrays.toString(firstArray));

        //другий варіант.

        int[] secondArray = {12, 13, -15, 100, 98};
        System.out.println(Arrays.toString(secondArray));

        for ( int element : secondArray ){
            System.out.println(element);
        }

    }
}