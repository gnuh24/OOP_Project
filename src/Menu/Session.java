package Menu;

//import HeThongGiaoDuc.PhongVan.LichPhongVan;
//import QuanLyDoiTuong.QLLichPhongVan;
import Menu.GiaoDien.*;
import NguoiDung.VaiTro;
import TaiKhoan.*;
import Utils.ScannerUtils;

public class Session {

    private static TaiKhoan taiKhoan;

    private static final GiaoDienKhachHang actorKhachHang= new GiaoDienKhachHang();
    private static final GiaoDienHocVien actorHocVien= new GiaoDienHocVien();
    private static final GiaoDienTroGiang actorTroGiang= new GiaoDienTroGiang();
    private static final GiaoDienGiangVien actorGiangVien= new GiaoDienGiangVien();
    private static final GiaoDienCongTacVien actorCongTacVien= new GiaoDienCongTacVien();
    private static final GiaoDienQuanLy actorQuanLy= new GiaoDienQuanLy();
    private static final GiaoDienGiamDoc actorGiamDoc = new GiaoDienGiamDoc();

    public static TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public static void setTaiKhoan(TaiKhoan taiKhoan) {
        Session.taiKhoan = taiKhoan;
    }

    public static void logout(){
        Session.setTaiKhoan(null);
        actorKhachHang.giaoDien();
    }


    public static void login(){
        System.out.println("Xin mời bạn nhập tài khoản: ");
        String curUsername = ScannerUtils.inputString();
        System.out.println("Xin mời bạn nhập mật khẩu: ");
        String curPassword = ScannerUtils.inputString();

        if (isLoginValid(curUsername, curPassword)){
            if (Session.taiKhoan.getUser().getVaiTro().equals(VaiTro.GiangVien)){
                    actorGiangVien.giaoDien();
            }   else if (Session.taiKhoan.getUser().getVaiTro().equals(VaiTro.TroGiang)) {
                    actorTroGiang.giaoDien();
            }   else if (Session.taiKhoan.getUser().getVaiTro().equals(VaiTro.HocVien)) {
                    actorHocVien.giaoDien();
            }   else if (Session.taiKhoan.getUser().getVaiTro().equals(VaiTro.CongTacVien)) {
                    actorCongTacVien.giaoDien();
            }   else if (Session.taiKhoan.getUser().getVaiTro().equals(VaiTro.QuanLy)) {
                    actorQuanLy.giaoDien();
            }   else if (Session.taiKhoan.getUser().getVaiTro().equals(VaiTro.GiamDoc)) {
                    actorGiamDoc.giaoDien();
            }   else {
                    System.out.println("Lỗi đăng nhập !!!");
                    actorKhachHang.giaoDien();
            }
        }
        else {
            System.out.println("Thông tin đăng nhập không đúng hãy kiểm tra lại !!");
            System.out.println("1. Đăng nhập lại");
            System.out.println("Nhấn bất cứ nút nào để trở màn hình chính");
            String choice = ScannerUtils.inputString();


            if (choice.equals("1")){
                Session.login();
            }
            else {
                actorKhachHang.giaoDien();
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
            Session.setTaiKhoan(taiKhoan);
            return true;
        }
    }
}
