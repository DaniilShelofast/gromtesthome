package lesson35.service;

public class ValidationUtils {

    public static boolean checkContentAndNull(String s) {
        return s == null || s.isBlank();
    }
    public static boolean areEqual(Object object1, Object object2) {
        return object1 == null || object1.equals(object2);
    }

}
