package Menu;

//import HeThongGiaoDuc.PhongVan.LichPhongVan;
//import QuanLyDoiTuong.QLLichPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.QLLichPhongVan;
import QuanLyDoiTuong.QLUser;
import TaiKhoan.*;
import Utils.ScannerUtils;

import java.time.LocalDate;

public class Form {

    private static TaiKhoan taiKhoan;

    public static TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public static void setTaiKhoan(TaiKhoan taiKhoan) {
        Form.taiKhoan = taiKhoan;
    }

    public static void logout(){
        Form.setTaiKhoan(null);
        Menu.giaoDienKhachHang();
    }



    public static void login(){
        System.out.println("Xin mời bạn nhập tài khoản: ");
        String curUsername = ScannerUtils.inputString();
        System.out.println("Xin mời bạn nhập mật khẩu: ");
        String curPassword = ScannerUtils.inputString();

        if (isLoginValid(curUsername, curPassword)){
            if (Form.taiKhoan.getUser().getVaiTro().equals(VaiTro.GiangVien)){
                Menu.giaoDienGiangVien();
            } else if (Form.taiKhoan.getUser().getVaiTro().equals(VaiTro.TroGiang)) {
                Menu.giaoDienTroGiang();
            }else if (Form.taiKhoan.getUser().getVaiTro().equals(VaiTro.HocVien)) {
                Menu.giaoDienHocVien();
            }else if (Form.taiKhoan.getUser().getVaiTro().equals(VaiTro.CongTacVien)) {
                Menu.giaoDienCongTacVien();
//            }else if (Form.taiKhoan.getUser().getVaiTro().equals(VaiTro.QuanLy)) {
//                Menu.giaoDienQuanLy();
//            }else if (Form.taiKhoan.getUser().getVaiTro().equals(VaiTro.GiamDoc)) {
//                Menu.giaoDienGiamDoc();
            }else {
                System.out.println("Lỗi đăng nhập !!!");
                Menu.giaoDienKhachHang();
            }

        }
        else {
            System.out.println("Thông tin đăng nhập không đúng hãy kiểm tra lại !!");
            System.out.println("1. Đăng nhập lại");
            System.out.println("Nhấn bất cứ nút nào để trở màn hình chính");
            String choice = ScannerUtils.inputString();


            if (choice.equals("1")){
                Form.login();
            }
            else {
                Menu.giaoDienKhachHang();
            }
        }


    }

    private static boolean isLoginValid(String curUsername, String password){
        TaiKhoan taiKhoan = QLTaiKhoan.timTaiKhoanTheoUsername(curUsername);
        if (taiKhoan == null){
            return false;
        }

        if (!taiKhoan.getMatKhau().equals(password)){
            return false;
        }
        else{
            Form.setTaiKhoan(taiKhoan);
            return true;
        }
    }

    public static void dangKyPhongVan(){
        System.out.println("Nhập họ và tên");
        String hoTen = ScannerUtils.inputString();

        System.out.println("Nhập email");
        String email = ScannerUtils.inputEmail();

        System.out.println("Chọn giới tính:");
        System.out.println("1. Nam");
        System.out.println("Các nút còn lại sẽ là nữ");
        boolean gioiTinh ;
        String genderChoice = ScannerUtils.inputString();
        if (genderChoice.equals("1")){
            gioiTinh = true;
        }
        else gioiTinh = false;


        System.out.println("Nhập số điện thoại");
        String sdt = ScannerUtils.inputSDT();

        System.out.println("Nhập địa chỉ");
        String diaChi = ScannerUtils.inputString();

        System.out.println("Nhập ngày tháng năm sinh: ");
        LocalDate ngayThang = ScannerUtils.inputDate();



        User khachHang = new User(hoTen, email, gioiTinh, ngayThang, sdt, diaChi, VaiTro.KhachHang);
        QLUser.getDsUser().add(khachHang);
        LichPhongVan lichPhongVan = new LichPhongVan(khachHang);
        QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);
        System.out.println(QLLichPhongVan.getDsLichPhongVan());
        System.out.println("Bạn đã đăng ký thành công !!");
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
        Menu.giaoDienKhachHang();
    }
}
