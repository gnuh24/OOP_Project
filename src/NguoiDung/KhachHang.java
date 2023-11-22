package NguoiDung;

import ThoiGian.NgayThang;

public class KhachHang extends CaNhan {

    public KhachHang() {
    }

    public KhachHang(String hoTen, String soDienThoai){
        super(hoTen, soDienThoai);
    }

    public KhachHang(String hoTen, String email, String soDienThoai){
        super(hoTen, email, soDienThoai);
    }

    public KhachHang(String hoTen, String email, boolean gioiTinh,
                     String soDienThoai, NgayThang ngaySinh , String diaChi) {
        super(hoTen, email, gioiTinh, soDienThoai, ngaySinh, diaChi);
    }

    public void dangKyThamGiaPhongVan() {}
}