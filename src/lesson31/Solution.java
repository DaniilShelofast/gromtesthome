package lesson31;

import java.util.HashMap;
import java.util.Map;


public class Solution {

    public static Map<Character, Integer> countSymbols(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char symbol : text.toCharArray()) {
            if (!map.containsKey(symbol)) {
                map.put(symbol, 1);
            } else {
                int count = 0;
                count = map.get(symbol);
                map.put(symbol, count + 1);
            }
        }
        return map;
    }

    public static Map<String, Integer> words(String text) throws Exception {
        characterChecker(text);
        Map<String, Integer> map = new HashMap<>();
        for (String string : text.split(" ")) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else {
                int count = 0;
                count = map.get(string);
                map.put(string, count + 1);

            }
        }
        return map;
    }

    private static boolean characterChecker(String text) throws Exception {
        for (String s : text.split(" ")) {
            if (s.length() < 2) {
                throw new Exception("error : word - more than two characters.");
            }
        }
        return true;
    }
}
