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
            System.err.println("Không phải số nguyên. Hãy nhập lại !!!\n");
            userInput = input.nextLine();
        }

        return Integer.parseInt(userInput);
    }

    public static double inputDouble() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while (!userInput.matches("-?\\d+(.\\d+)?")) {
            System.err.println("Không phải số thực. Hãy nhập lại !!!\n");
            userInput = input.nextLine();
        }

        return Double.parseDouble(userInput);
    }

    public static String inputEmail() {
        System.out.println("Xin mời nhập email. (VD: hungnt@gmail.com)");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String regex = "\\w+[\\w\\.]*[\\w_]*[\\w\\+]\\w*@[a-zA-Z]+(.[a-zA-Z]+)+";

        while (!userInput.matches(regex)) {
            System.err.println("Không phải là một email. Hãy nhập lại !!!\n");
            userInput = input.nextLine();
        }

        return userInput;
    }

    public static String inputSDT() {
        System.out.println("Xin mời nhập ngày tháng năm. (VD: 0938240359)");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        // Số điện thoại 10 số
        String regex = "0[35789]\\d{8}";

        while (!userInput.matches(regex)) {
            System.err.println("Không phải số điện thoại chuẩn. Hãy nhập lại:\n");
            userInput = input.nextLine();
        }

        return userInput;
    }

    public static String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static LocalDate inputDate() {
        System.out.println("Xin mời nhập ngày tháng năm. (VD: 02/04/2004)");

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String regex = "(\\d{2}/){2}\\d{4}";

        while (!userInput.matches(regex)) {
            System.err.println("Không phải định dạng ngày đúng .Hãy nhập lại !!\n");
            userInput = input.nextLine();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(userInput, formatter);
    }

    public static LocalTime inputTime() {
        System.out.println("Xin mời nhập thời gian (VD: 20:30)");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String regex = "\\d{2}:\\d{2}";

        while (!userInput.matches(regex)) {
            System.err.println("Không phải định dạng thời gian chuẩn. Hãy nhập lại !!\n");
            userInput = input.nextLine();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(userInput, formatter);
    }

    public static double inputDiem(){
        System.out.println("Xin mời nhập điểm: ");
        double userInput = ScannerUtils.inputDouble();
        while (userInput < 0 || userInput > 10){
            System.out.println("Bạn chỉ đụược nhập điểm từ 0 -> 10");
            userInput = ScannerUtils.inputDouble();
        }
        return userInput;
    }

}
