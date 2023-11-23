package NguoiDung;

import QuanLyDoiTuong.QLKhachHang;
import ThoiGian.NgayThang;

public class KhachHang extends CaNhan {
    private String maKhachHang;

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public KhachHang() {
    }

    public KhachHang(String hoTen, String soDienThoai){
        super(hoTen, soDienThoai);
    }

    public KhachHang(String hoTen, String email, String soDienThoai){
        super(hoTen, email, soDienThoai);
        int maCuoi = QLKhachHang.getDsKhachHang().size() + 1;
        this.maKhachHang =  "KH" + maCuoi;
    }

    public KhachHang(String hoTen, String email, boolean gioiTinh,
                     String soDienThoai, NgayThang ngaySinh , String diaChi) {

        super(hoTen, email, gioiTinh, soDienThoai, ngaySinh, diaChi);
        int maCuoi = QLKhachHang.getDsKhachHang().size() + 1;
        this.maKhachHang =  "KH" + maCuoi;
    }

    public void dangKyThamGiaPhongVan() {}
}