package NguoiDung;

import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import QuanLyDoiTuong.QLChuongTrinhHoc;
import QuanLyDoiTuong.QLKhoaKhaiGiang;
import ThoiGian.NgayThang;

public abstract class CaNhan {
    private String hoTen;
    private String email;
    private boolean gioiTinh;

    private NgayThang ngaySinh;

    private String soDienThoai;
    private String diaChi;

    public CaNhan() {
    }

    public CaNhan(String hoTen, String soDienThoai){
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }

    public CaNhan(String hoTen, String email, String soDienThoai){
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai  = soDienThoai;
    }


    public CaNhan(String hoTen, String email, boolean gioiTinh, String soDienThoai, NgayThang ngaySinh , String diaChi) {
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
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

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public NgayThang getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(NgayThang ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void xemChuongTrinhHoc(){
        QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
    }


    public void xemCacLopDangHoc(){

    }

    public void xemCacLopSapKhaiGiang(){

    }


    public void xemDanhSachCacGiangVien(){

    }

}
