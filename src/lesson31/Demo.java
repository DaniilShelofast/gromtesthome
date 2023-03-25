package lesson31;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws Exception {

        System.out.println(Solution.countSymbols("text"));
        System.out.println(Solution.countSymbols("FreeText"));
        System.out.println(Solution.countSymbols("programmer"));
        System.out.println(Solution.countSymbols("summer"));
        System.out.println(Solution.countSymbols("apple"));

        System.out.println(Solution.words("text one two text one text"));
        System.out.println(Solution.words("java php js php java home"));
        System.out.println(Solution.words("one one one one one text"));

    }
}
