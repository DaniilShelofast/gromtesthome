package lesson18Home;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findStrings("11")));
        System.out.println(Arrays.toString(findStrings("1 d")));
        System.out.println(Arrays.toString(findStrings("text")));
    }

    public static String[] findStrings(String text) {
        String[] texts = text.split(" ");

        int add = 0;
        for (int i = 0; i < texts.length; i++) {
            if (isLetterPresent(texts[i].trim())) {
                add++;
            }
        }

        String[] box = new String[add];

        int el = 0;
        for (int i = 0; i < texts.length; i++) {
            if (isLetterPresent(texts[i])) {
                box[el] = texts[i];
                el++;
            } else {
                System.err.println("not a string");
            }

        }
        return box;
    }

    private static boolean isLetterPresent(String string) {
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }
}
