package NguoiDung;

import ThoiGian.NgayThang;



public class GiangVien extends TroGiang {

    public GiangVien(String hoTen,
                    String email,
                     boolean gioiTinh,
                     String soDienThoai,
                     NgayThang ngaySinh,
                    String diaChi,
                    String ma,
                    boolean trangThai) {
        super(hoTen, email, gioiTinh, soDienThoai, ngaySinh, diaChi, ma, trangThai);
    }
    public void xemlichPhongVan() {

    }
}