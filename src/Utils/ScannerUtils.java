package Utils;

import java.util.Scanner;


public class ScannerUtils {



        public static int inputInt(String errorMessage){
            Scanner input = new Scanner(System.in);
            try {

                return Integer.parseInt(input.nextLine());

            }
            catch (Exception e) {
                System.out.println(errorMessage);
            }
            return inputInt(errorMessage);
        }


        public static float inputFloat(String errorMessage){
            Scanner input = new Scanner(System.in);

            try {
                return Float.parseFloat( input.nextLine() );
            }
            catch (Exception e){
                System.out.println(errorMessage);
            }
            return inputFloat(errorMessage);
        }

        public static double inputDouble(String errorMessage){
            Scanner input = new Scanner(System.in);

            try {
                return  input.nextDouble();
            }
            catch (Exception e){
                System.out.println(errorMessage);
            }
            return inputDouble(errorMessage);
        }

    public static String inputString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    // hàm nhập email
    // hàm nhập số điện thoại

    //







}
