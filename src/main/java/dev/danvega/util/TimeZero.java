package dev.danvega.util;

import java.util.Calendar;
import java.util.Date;

public class TimeZero {
    public static Date MAX_DATE = new Date(Long.MAX_VALUE);
    public static Date MIN_DATE = new Date(Long.MIN_VALUE);

    public static Date getZeroTimeDate(Date date) {
        Date res = date;
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        res = calendar.getTime();

        return res;
    }

}
