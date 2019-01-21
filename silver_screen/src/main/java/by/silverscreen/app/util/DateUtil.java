package by.silverscreen.app.util;

import sun.util.resources.LocaleData;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    public static LocalDate convertDateToLocaleDate(Date date){
        if(date == null){
            return null;
        }
        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        return zdt.toLocalDate();
    }

    public static Date convertLocalDateToDate(LocalDate localDate){
        if(localDate == null){
            return null;
        }
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        return Date.from(instant);
    }

    public static boolean controlAge(String string) {
        Pattern pattern = Pattern.compile("[0-9]{1,3}");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
