// M.T.T. Kiet

import java.util.Scanner;

public class Test {

    public static int inputInt() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while (!userInput.matches("\\b-?\\d+\\b")) {
            System.err.println("Dau vao khong phai so nguyen. Hay nhap lai:\n");
            userInput = input.nextLine();
        }

        return Integer.parseInt(userInput);
    }

    public static double inputDoule() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while (!userInput.matches("\\b-?\\d+(.\\d+)?")) {
            System.err.println("Dau vao khong phai so thuc. Hay nhap lai:\n");
            userInput = input.nextLine();
        }

        return Double.parseDouble(userInput);
    }

    public static String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

}
