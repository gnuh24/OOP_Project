package NguoiDung;

import ThoiGian.NgayThang;

public class HocVien extends CaNhanTrungTam {
    // Constructors
    public HocVien() {}

    public HocVien(String hoTen, String email, boolean gioiTinh, String soDienThoai,
                   NgayThang ngaySinh, String diaChi, String ma, boolean trangThai) {
        super(hoTen, email,  gioiTinh,  soDienThoai, ngaySinh, diaChi, ma, trangThai);
    }

    // Non-static methods
    public void xemThoiKhoaBieu() {}
    public void thanhToanHocPhi() {}
    public void dangKyLopHocMoi() {}
    public void xemBangDiem() {}
}