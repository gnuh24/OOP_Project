package Utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Convert {
    public static LocalDate stringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy");

        return LocalDate.parse(date, formatter);
    }

    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy");

        return date.format(formatter);
    }

    public static LocalTime stringToTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("HH:mm");

        return LocalTime.parse(time, formatter);
    }

    public static String timeToString(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }

}
