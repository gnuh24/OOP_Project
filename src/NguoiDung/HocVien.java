package NguoiDung;

import QuanLyDoiTuong.QLHocVien;
import ThoiGian.NgayThang;

public class HocVien extends CaNhanTrungTam {
    // Constructors
    public HocVien() {}

    public HocVien(String hoTen, String email, boolean gioiTinh, String soDienThoai,
                   NgayThang ngaySinh, String diaChi, boolean trangThai) {
        super(hoTen, email,  gioiTinh,  soDienThoai, ngaySinh, diaChi, trangThai);
        int dauCuoi = QLHocVien.getDsHocVien().size() + 1;
        this.setMa("HV" + dauCuoi);
    }

    public HocVien(String hoTen, String email, boolean gioiTinh, String soDienThoai,
                   NgayThang ngaySinh, String diaChi, String ma, boolean trangThai) {
        super(hoTen, email,  gioiTinh,  soDienThoai, ngaySinh, diaChi, ma, trangThai);
    }

}