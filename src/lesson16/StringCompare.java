package lesson16;

import java.util.Arrays;

public class StringCompare {
    public static void main(String[] args) {
        String test = "someStringExample";
        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));
        System.out.println("abc" == "abc");
        System.out.println("abc".equals("abc"));

        String s3 = new String("pppp");
        String s4 = "pppp";
        System.out.println(s3 == s4);

        s3 = s3.intern();
        System.out.println(s3 == s4);

        String str = "testStringVar";
        System.out.println(Arrays.toString(str.getBytes()));
        System.out.println(new String(str.getBytes()));
    }
}
