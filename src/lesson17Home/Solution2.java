package lesson17Home;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
       // System.out.println(Arrays.toString(findNumbers("1 2 3")));
        System.out.println(Arrays.toString(findNumbers("d")));
        System.out.println(Arrays.toString(findNumbers("1 d")));
    }

    public static int[] findNumbers(String text) {
        String[] texts = text.split(" ");
        int[] index = new int[texts.length];
        int add = 0;
        for (int i = 0; i < texts.length; i++) {
            if (isDigitPresent(texts[i].trim())) {
                add++;

            }

        }
        int[] box = new int[add];
        int el = 0;
        for (int i = 0; i < index.length; i++) {
            if (isDigitPresent(texts[i])) {
                box[el] = Integer.parseInt(texts[i].trim());
                el++;

            } else {
                System.err.println(" not a number");
            }

        }
        return box;
    }

    private static boolean isDigitPresent(String string) {
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
