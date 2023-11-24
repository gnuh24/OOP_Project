package NguoiDung;

import ThoiGian.NgayThang;


public abstract class CaNhanTrungTam extends CaNhan {
    private String ma;
    private boolean trangThai;

    public CaNhanTrungTam(){}

    public CaNhanTrungTam(String hoTen,
                          String email,
                          boolean gioiTinh,
                          String soDienThoai,
                          NgayThang ngaySinh,
                          String diaChi,
                          boolean trangThai) {

        super(hoTen, email,  gioiTinh,  soDienThoai, ngaySinh, diaChi);
        this.trangThai = trangThai;
    }


    public CaNhanTrungTam(String hoTen,
                   String email,
                   boolean gioiTinh,
                          String soDienThoai,
                          NgayThang ngaySinh,
                   String diaChi,
                   String ma,
                   boolean trangThai) {

        super(hoTen, email,  gioiTinh,  soDienThoai, ngaySinh, diaChi);
        this.ma = ma;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}