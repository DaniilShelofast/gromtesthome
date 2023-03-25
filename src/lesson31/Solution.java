package lesson31;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static Map<Character, Integer> countSymbols(String text) {
        Map<Character, Integer> map = new TreeMap<>();
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

    public static Map<String, Integer> words(String text) {
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
}
