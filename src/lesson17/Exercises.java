package lesson17;

import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
        String test = "There is Test something new or jot sdf sdf sdf world Test or op";
        System.out.println(deleteDuplicated(test));
        System.out.println(Arrays.toString(countDuplicated(test, new String[]{"or", "some", "test"})));

       /* String str = "Today is good day ... Hello sdf";

        System.out.println(replace(str, "is", "that"));
        System.out.println(replace(str, "o", " "));
        System.out.println(replace(str, "To", "PPP"));
        System.out.println(replace(str, "lo", "X"));*/

    }

    public static String deleteDuplicated(String input) {
        String[] worlds = input.split(" ");

        for (int i = 0; i < worlds.length; i++) {
            for (int j = i + 1; j < worlds.length; j++) {
                if (worlds[i].equals(worlds[j])) {
                    worlds[j] = "";
                }
            }
        }
        String res = "";
        for (String work : worlds) {
            res += work;

            if (!work.isEmpty()) {
                res += " ";
            }
        }
        return res;
    }

    public static int[] countDuplicated(String input, String[] worlds) {
        String[] strings = input.split(" ");

        int res[] = new int[worlds.length];
        for (String string : strings) {
            for (int i = 0; i < worlds.length; i++) {
                if (string.equals(worlds[i])) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public static String replace(String input, String target, String replacement) {
        int[] indexes = findStartIndexes(input.toCharArray(), target.charAt(0));

        if (indexes.length == 0) return input;

        for (int index : indexes) {
            if (checkReplace(input, target, index)) {
                return replace(input, target, replacement, index);
            }
        }
        return input;
    }

    private static String replace(String input, String target, String replacement, int index) {
        char[] res1 = new char[index];

        for (int i = 0; i < index; i++) {
            res1[i] = input.toCharArray()[i];
        }
        char[] res3 = new char[input.length() - res1.length - target.length()];
        for (int i = 0, j = res1.length + target.length(); i < res3.length && j < input.length(); i++, j++) {
            res3[i] = input.toCharArray()[j];
        }
        return new String(res1) + replacement + new String(res3);
    }

    private static boolean checkReplace(String input, String target, int index) {
        char[] inputChars = input.toCharArray();
        char[] replaceChars = target.toCharArray();

        for (int i = 0; i < replaceChars.length && index < inputChars.length; i++, index++) {
            if (inputChars[index] != replaceChars[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] findStartIndexes(char[] inputChars, char beginningChar) {
        int count = 0;
        for (char ch : inputChars) {
            if (ch == beginningChar) {
                count++;
            }
        }
        int[] indexes = new int[count];
        int in = 0;

        int index = 0;
        for (char ch : inputChars) {
            if (ch == beginningChar) {
                indexes[in] = index;
                in++;
            }
            index++;
        }
        return indexes;
    }
}
