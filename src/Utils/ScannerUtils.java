// M.T.T. Kiet
package Utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScannerUtils {

    public static int inputInt() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while (!userInput.matches("-?\\d+")) {
            System.err.println("Khong phai so nguyen. Hay nhap lai:\n");
            userInput = input.nextLine();
        }

        return Integer.parseInt(userInput);
    }

    public static double inputDoule() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while (!userInput.matches("-?\\d+(.\\d+)?")) {
            System.err.println("Khong phai so thuc. Hay nhap lai:\n");
            userInput = input.nextLine();
        }

        return Double.parseDouble(userInput);
    }

    public static String inputEmail() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String regex = "\\w+[\\w\\.]*[\\w_]*[\\w\\+]\\w*@[a-zA-Z]+(.[a-zA-Z]+)+";

        while (!userInput.matches(regex)) {
            System.err.println("Khong phai email. Hay nhap lai:\n");
            userInput = input.nextLine();
        }

        return userInput;
    }

    public static String inputSDT() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String regex = "0[35789]\\d{8}";

        while (!userInput.matches(regex)) {
            System.err.println("Khong phai so dien thoai. Hay nhap lai:\n");
            userInput = input.nextLine();
        }

        return userInput;
    }

    public static String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static LocalDate inputDate() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String regex = "(\\d{2}/){2}\\d{4}";

        while (!userInput.matches(regex)) {
            System.err.println("Khong phai dinh dang Ngay. Hay nhap lai:\n");
            userInput = input.nextLine();
        }

        return LocalDate.parse(userInput);
    }

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

    public static LocalTime inputTime() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String regex = "\\d{2}/\\d{2}";

        while (!userInput.matches(regex)) {
            System.err.println("Khong phai dinh dang Thoi gian. Hay nhap lai:\n");
            userInput = input.nextLine();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH/mm");
        return LocalTime.parse(userInput, formatter);
    }

}
