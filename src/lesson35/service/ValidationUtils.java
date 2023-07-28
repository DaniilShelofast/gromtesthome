package lesson35.service;

public class ValidationUtils {

    public static boolean checkContentAndNull(String s) {
        return s == null || s.isBlank();
    }

}
