package NguoiDung;

import QuanLyDoiTuong.QLUser;
import Utils.ScannerUtils;

import java.time.LocalDate;

public class User {

    private String maUser;
    private String hoTen;
    private String email;
    private boolean gioiTinh;

    private LocalDate ngaySinh;

    private String soDienThoai;
    private String diaChi;

    private VaiTro vaiTro;

    private boolean trangThai;

    public User(String maUser, String hoTen, String email, boolean gioiTinh, LocalDate ngaySinh, String soDienThoai,
            String diaChi, VaiTro vaiTro, boolean trangThai) {
        this.maUser = maUser;
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    public User(String hoTen, String email, boolean gioiTinh, LocalDate ngaySinh, String soDienThoai, String diaChi,
            VaiTro vaiTro) {
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.vaiTro = vaiTro;

        this.trangThai = true;
        autoIncrementID(getVaiTro());
    }

    public User(String hoTen, String email, boolean gioiTinh, LocalDate ngaySinh, String soDienThoai, String diaChi) {
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;

        this.vaiTro = VaiTro.KhachHang;
        this.trangThai = true;
        autoIncrementID(getVaiTro());

    }

    public User() {
        nhapThongTinBoiKhachHang();
        this.vaiTro = VaiTro.KhachHang;
        this.trangThai = true;
        autoIncrementID(getVaiTro());
    }

    private void autoIncrementID(VaiTro vaiTro) {
        int so = QLUser.demUserTheoVaiTro(vaiTro) + 1;
        this.maUser = VaiTro.toCode(getVaiTro()) + so;
    }

    public void nhapThongTinBoiKhachHang(){
        System.out.println("Nhập họ và tên: ");
        this.hoTen = ScannerUtils.inputString();

        System.out.println("Nhập email: ");
        this.email = ScannerUtils.inputEmail();

        System.out.println("Nhập giới tính: ");
        System.out.println("1. Nam");
        System.out.println("Các số còn lại Nữ");
        String gioiTinh = ScannerUtils.inputString();
        if (gioiTinh.equals("1")){
            this.gioiTinh = true;
        }else {
            this.gioiTinh = false;
        }

        this.ngaySinh = ScannerUtils.inputDate();
        this.soDienThoai = ScannerUtils.inputSDT();

        this.diaChi = ScannerUtils.inputString();
    }
//    public void nhapThongTinBoiCongTacVien() {
//
//        System.out.println("Nhập họ và tên: ");
//        this.hoTen = ScannerUtils.inputString();
//
//        System.out.println("Nhập email: ");
//        this.email = ScannerUtils.inputEmail();
//
//        System.out.println("Nhập giới tính: ");
//        System.out.println("1. Nam");
//        System.out.println("Các số còn lại Nữ");
//        String gioiTinh = ScannerUtils.inputString();
//        if (gioiTinh.equals("1")){
//            this.gioiTinh = true;
//        }else {
//            this.gioiTinh = false;
//        }
//
//        this.ngaySinh = ScannerUtils.inputDate();
//        this.soDienThoai = ScannerUtils.inputSDT();
//
//        this.diaChi = ScannerUtils.inputString();
//
//        System.out.println("Hãy phân loại người dùng. ");
//        System.out.println("1. Khách hàng");
//        System.out.println("2. Hoc viên");
//        System.out.println("3. Trợ giảng");
//        System.out.println("4. Giảng viên");
//        System.out.println("5. Cộng tác viên");
//        System.out.println("6. Quản lý");
//        System.out.println("7. Giám đốc");
//        int vaiTro = ScannerUtils.inputInt();
//        boolean isValid = false;
//        while (isValid){
//             switch (vaiTro){
//                 case 1:
//                     this.vaiTro = VaiTro.KhachHang;
//                     isValid = true;
//                     break;
//
//                 case 2:
//                     this.vaiTro = VaiTro.HocVien;
//                     isValid = true;
//                     break;
//
//                 case 3:
//                     this.vaiTro = VaiTro.TroGiang;
//                     isValid = true;
//                     break;
//
//                 case 4:
//                     this.vaiTro = VaiTro.GiangVien;
//                     isValid = true;
//                     break;
//
//                 case 5:
//                     this.vaiTro = VaiTro.CongTacVien;
//                     isValid = true;
//                     break;
//
//                 case 6:
//                     this.vaiTro = VaiTro.QuanLy;
//                     isValid = true;
//                     break;
//
//                 case 7:
//                     this.vaiTro = VaiTro.GiamDoc;
//                     isValid = true;
//                     break;
//
//                 default:
//                     System.out.println("Bạn chỉ được nhập các giá trị chỉ định !!!");
//                     vaiTro = ScannerUtils.inputInt();
//
//         }
//
//
//
//        }
//
//
//    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public VaiTro getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(VaiTro vaiTro) {
        this.vaiTro = vaiTro;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
