package Menu;

import HeThongGiaoDuc.PhongVan.LichPhongVan;
import QuanLyDoiTuong.QLLichPhongVan;
import TaiKhoan.*;
import ThoiGian.NgayThang;
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

    public static void logout(){
        Form.setId(null);
        Form.setPassword(null);
        Form.setUsername(null);
        Form.setTrangThaiDangNhap(null);
        Menu.giaoDienKhachHang();
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
            } else if (Form.getTrangThaiDangNhap().equals(TrangThaiDangNhap.TroGiang)) {
                Menu.giaoDienTroGiang();
            }else if (Form.getTrangThaiDangNhap().equals(TrangThaiDangNhap.HocVien)) {
                Menu.giaoDienHocVien();
            }else if (Form.getTrangThaiDangNhap().equals(TrangThaiDangNhap.CongTacVien)) {
                Menu.giaoDienCongTacVien();
            }else if (Form.getTrangThaiDangNhap().equals(TrangThaiDangNhap.QuanLy)) {
                Menu.giaoDienQuanLy();
            }else if (Form.getTrangThaiDangNhap().equals(TrangThaiDangNhap.GiamDoc)) {
                Menu.giaoDienGiamDoc();
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
            Form.setId(taiKhoan.getId());
            Form.setTrangThaiDangNhap(Form.checkTrangThai(Form.getId()));
            return true;
        }
    }

    @SuppressWarnings("all") //Bỏ qua tất ca các cảnh báo
    private static TrangThaiDangNhap checkTrangThai(String id){
        String mauCanTest = id.substring(0, 2);
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
        String sdt = ScannerUtils.inputString();

        System.out.println("Nhập địa chỉ");
        String diaChi = ScannerUtils.inputString();

        System.out.println("Nhập ngày tháng năm sinh: ");
        System.out.println("Ngày: ");
        int ngay = ScannerUtils.inputInt("Bạn chỉ được nhập số ngày");
        System.out.println("Tháng: ");

        int thang = ScannerUtils.inputInt("Bạn chỉ được nhập số tháng phù hợp");
        System.out.println("Năm: ");

        int nam = ScannerUtils.inputInt("Bạn chỉ được nhập số năm phù hợp");
        NgayThang ngayThang = new NgayThang(ngay, thang, nam);



        KhachHang khachHang = new KhachHang(hoTen, email, gioiTinh, sdt, ngayThang, diaChi);
        QLKhachHang.getDsKhachHang().add(khachHang);
        LichPhongVan lichPhongVan = new LichPhongVan(khachHang);
        QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);
        System.out.println(QLLichPhongVan.getDsLichPhongVan());
        System.out.println("Bạn đã đăng ký thành công !!");
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
        Menu.giaoDienKhachHang();
    }
}
