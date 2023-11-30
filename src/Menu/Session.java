package Menu;

//import HeThongGiaoDuc.PhongVan.LichPhongVan;
//import QuanLyDoiTuong.QLLichPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import Menu.Actor.*;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.QLLichPhongVan;
import QuanLyDoiTuong.QLUser;
import TaiKhoan.*;
import Utils.ScannerUtils;

import java.time.LocalDate;

public class Session {

    private static TaiKhoan taiKhoan;

    private static final ActorKhachHang actorKhachHang= new ActorKhachHang();
    private static final ActorHocVien actorHocVien= new ActorHocVien();
    private static final ActorTroGiang actorTroGiang= new ActorTroGiang();
    private static final ActorGiangVien actorGiangVien= new ActorGiangVien();
    private static final ActorCongTacVien actorCongTacVien= new ActorCongTacVien();
    private static final ActorQuanLy actorQuanLy= new ActorQuanLy();
    private static final ActorGiamDoc actorGiamDoc = new ActorGiamDoc();

    public static TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public static void setTaiKhoan(TaiKhoan taiKhoan) {
        Session.taiKhoan = taiKhoan;
    }

    public static void logout(){
        Session.setTaiKhoan(null);
        ActorKhachHang actorKhachHang = new ActorKhachHang();
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
