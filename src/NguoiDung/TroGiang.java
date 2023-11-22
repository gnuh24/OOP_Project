package NguoiDung;

import ThoiGian.NgayThang;




public class TroGiang extends CaNhanTrungTam {

    public TroGiang(String hoTen,
                    String email,
                    boolean gioiTinh,
                    String soDienThoai,
                    NgayThang ngaySinh,
                    String diaChi,
                    String ma,
                    boolean trangThai) {
        super(hoTen, email, gioiTinh, soDienThoai, ngaySinh, diaChi, ma, trangThai);
    }

    public void xemLichDayKhoaHienTai() {
    }

    public void xemLichDayKhoaSapKhaiGiang() {
    }

    public void xemDanhSachHocVienTheoLop(String maLop) {
    }
}
