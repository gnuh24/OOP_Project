// M.T.T. Kiet
package Utils;

import NguoiDung.VaiTro;

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
        String regex = "\\w+[\\w-_\\.]*@[a-zA-Z]+(.[a-zA-Z]+)+";

        while (!userInput.matches(regex)) {
            System.err.println("Không phải là một email. Hãy nhập lại !!!\n");
            userInput = input.nextLine();
        }

        return userInput;
    }

    public static String inputSDT() {
        System.out.println("Xin mời nhập số điện thoại. (VD: 0938240359)");
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

    public static double inputDiem() {
        System.out.println("Xin mời nhập điểm: ");
        double userInput = ScannerUtils.inputDouble();
        while (userInput < 0 || userInput > 10) {
            System.out.println("Bạn chỉ đụược nhập điểm từ 0 -> 10");
            userInput = ScannerUtils.inputDouble();
        }
        return userInput;
    }

    public static VaiTro inputVaiTro(){
        System.out.println("Hãy phân loại người dùng. ");
        System.out.println("1. Khách hàng");
        System.out.println("2. Học viên");
        System.out.println("3. Trợ giảng");
        System.out.println("4. Giảng viên");
        System.out.println("5. Cộng tác viên");
        System.out.println("6. Quản lý");
        System.out.println("7. Giám đốc");

        boolean isValid = false;
        VaiTro vaiTro = null;

        while (!isValid){
            int input = ScannerUtils.inputInt();

            switch (input){
                case 1:
                    vaiTro = VaiTro.KhachHang;
                    isValid = true;
                    break;

                case 2:
                    vaiTro = VaiTro.HocVien;
                    isValid = true;
                    break;

                case 3:
                    vaiTro = VaiTro.TroGiang;
                    isValid = true;
                    break;

                case 4:
                    vaiTro = VaiTro.GiangVien;
                    isValid = true;
                    break;

                case 5:
                    vaiTro = VaiTro.CongTacVien;
                    isValid = true;
                    break;

                case 6:
                    vaiTro = VaiTro.QuanLy;
                    isValid = true;
                    break;

                case 7:
                    vaiTro = VaiTro.GiamDoc;
                    isValid = true;
                    break;

                default:
                    System.out.println("Bạn chỉ được nhập các giá trị chỉ định !!!");
            }
        }

        return vaiTro;
    }

    public static boolean inputGioiTinh() {
        int luaChonGioiTinh;

        do {
            System.out.println("Nhập giới tính: ");
            System.out.println("1. Nam");
            System.out.println("2. Nữ");

            luaChonGioiTinh = ScannerUtils.inputInt();

            if (luaChonGioiTinh != 1 && luaChonGioiTinh != 2) {
                System.out.println("Vui lòng chỉ chọn 1 (Nam) hoặc 2 (Nữ). Hãy nhập lại.");
            }

        } while (luaChonGioiTinh != 1 && luaChonGioiTinh != 2);

        return luaChonGioiTinh == 1;
    }

    public static String inputName() {
        String ten;

        do {
            System.out.println("Nhập tên: ");
            ten = ScannerUtils.inputString();

            if (ten.trim().isEmpty()) {
                System.out.println("Tên không được để trống. Hãy nhập lại.");
            }

        } while (ten.trim().isEmpty());

        return ten;
    }

    public static String inputDiaChi() {
        String diaChi;

        do {
            System.out.println("Nhập địa chỉ: ");
            diaChi = ScannerUtils.inputString();

            if (diaChi.trim().isEmpty()) {
                System.out.println("Địa chỉ không được để trống. Hãy nhập lại.");
            }

        } while (diaChi.trim().isEmpty());

        return diaChi;
    }

    public static int inputHocPhi() {
        System.out.println("Nhập học phí: ");
        int hocPhi = ScannerUtils.inputInt();

        while (hocPhi < 0) {
            System.out.println("Học phí không thể là một số âm. Hãy nhập lại: ");
            hocPhi = ScannerUtils.inputInt();
        }

        return hocPhi;
    }


}
