package lesson35.service;

import lesson35.exception.BadRequestException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static long getNumberOfNights(Date dateFrom, Date dateTo) throws BadRequestException {
        Date today = new Date();
        if (dateFrom.getTime() >= dateTo.getTime() || today.getTime() > dateTo.getTime() || today.getTime() >= dateFrom.getTime()) {
            throw new BadRequestException("Error : the arrival date is greater than the departure date.");
        }
        long timeIndex = dateTo.getTime() - dateFrom.getTime();
        return TimeUnit.DAYS.convert(timeIndex, TimeUnit.MILLISECONDS);
    }

}
