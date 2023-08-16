package lesson35.service;

import lesson35.exception.BadRequestException;

import java.util.Date;

public class ValidationUtils {

    public static boolean checkContentAndNull(String s) {
        return s == null || s.isBlank();
    }
    public static boolean areEqual(Object object1, Object object2) {
        return object1 == null || object1.equals(object2);
    }

    public static void validateDate(Date dateFrom, Date dateTo) throws BadRequestException {
        if (dateFrom == null || dateTo == null) {
            throw new BadRequestException("Error : date parameter can not be Null.");
        }
    }

}
