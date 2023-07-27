package lesson35.service;

public class ExceptionUtils {

    public static boolean checkContentAndNull(String s) {
        return s == null || s.isBlank();
    }

}
