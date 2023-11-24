package Utils;

import java.time.LocalDate;
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


}
