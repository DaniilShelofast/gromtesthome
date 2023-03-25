package lesson31;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<Character, Integer> countSymbols(String text) throws Exception {
        Map<Character, Integer> map = new HashMap<>();
        checkSymbol(text);
        int count = 0;

        for (char symbol : text.toCharArray()) {
            if (map.containsKey(symbol)) {
                count = map.get(symbol);
            }
            map.put(symbol, count + 1);
        }
        return map;
    }

    public static Map<String, Integer> words(String text) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (String string : text.split(" ")) {
            if (map.containsKey(string)) {
                count = map.get(string);
            }
            map.put(string, count + 1);
        }
        return map;
    }

    private static boolean checkSymbol(String string) throws Exception {
        char[] ch = string.toCharArray();
        for (char c : ch) {
            if (!Character.isLetterOrDigit(c)) {
                throw new Exception("error : need to review the data provided.");
            }
        }
        return true;
    }

}
