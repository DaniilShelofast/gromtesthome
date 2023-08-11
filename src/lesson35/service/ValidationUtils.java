package lesson35.service;

public class ValidationUtils {

    public static boolean checkContentAndNull(String s) {
        return s == null || s.isBlank();
    }
    public static boolean areEqual(Object filter, Object room) {
        return filter == null || filter.equals(room);
    }

}
