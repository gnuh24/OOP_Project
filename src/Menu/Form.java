package Menu;

import HeThongGiaoDuc.PhongVan.LichPhongVan;
import NguoiDung.KhachHang;
import QuanLyDoiTuong.QLLichPhongVan;
import TaiKhoan.*;
import Utils.ScannerUtils;

public class Form {
    private static String id;
    private static String username;
    private static String password;

    private static TrangThaiDangNhap trangThaiDangNhap;

    public static TrangThaiDangNhap getTrangThaiDangNhap() {
        return trangThaiDangNhap;
    }

    public static void setTrangThaiDangNhap(TrangThaiDangNhap trangThaiDangNhap) {
        Form.trangThaiDangNhap = trangThaiDangNhap;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Form.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Form.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Form.password = password;
    }

    public static void login(){
        System.out.println("Xin mời bạn nhập tài khoản: ");
        String curUsername = ScannerUtils.inputString();
        System.out.println("Xin mời bạn nhập mật khẩu: ");
        String curPassword = ScannerUtils.inputString();

        if (isLoginValid(curUsername, curPassword)){
            Form.username = curUsername;
            Form.password = curPassword;
            if (Form.getTrangThaiDangNhap().equals(TrangThaiDangNhap.GiangVien)){
                Menu.giaoDienGiangVien();
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
            Form.setId(taiKhoan.getId());
            Form.setTrangThaiDangNhap(Form.checkTrangThai(Form.getId()));
            return true;
        }
    }

    @SuppressWarnings("all") //Bỏ qua tất ca các cảnh báo
    private static TrangThaiDangNhap checkTrangThai(String id){
        String mauCanTest = id.substring(0, 1);
        if (mauCanTest.equals("GV")){
            return TrangThaiDangNhap.GiangVien;
        }   else if (mauCanTest.equals("TG")) {
                return TrangThaiDangNhap.TroGiang;
        }   else if (mauCanTest.equals("HV")) {
                return TrangThaiDangNhap.HocVien;
        }   else if (mauCanTest.equals("QL")) {
                return TrangThaiDangNhap.QuanLy;
        }   else if (mauCanTest.equals("CV")) {
                return TrangThaiDangNhap.CongTacVien;
        }   else if (mauCanTest.equals("GD")) {
                return TrangThaiDangNhap.GiamDoc;
        } else {
            System.out.println("ID không hợp lệ !!");
            return null;
        }
    }

    public static void dangKyPhongVan(){
        System.out.println("Nhập họ và tên");
        String hoTen = ScannerUtils.inputString();

        System.out.println("Nhập email");
        String email = ScannerUtils.inputString();

        System.out.println("Nhập số điện thoại");
        String sdt = ScannerUtils.inputString();


        LichPhongVan lichPhongVan = new LichPhongVan(new KhachHang(hoTen, email, sdt));
        QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);

        System.out.println("Bạn đã đăng ký thành công !!");
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
        Menu.giaoDienKhachHang();
    }
}
