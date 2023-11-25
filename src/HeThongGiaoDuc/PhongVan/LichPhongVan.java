package HeThongGiaoDuc.PhongVan;

import NguoiDung.User;
import QuanLyDoiTuong.QLLichPhongVan;

import java.time.LocalDate;
import java.time.LocalTime;

public class LichPhongVan {
    private String maCaPhongVan;

    private User giangVien;

    private LocalDate ngayThang;

    private LocalTime gioPV;

    private User khachHang;

    private TrangThaiPhongVan trangThaiPhongVan;

    public LichPhongVan(){}

    public LichPhongVan(User khachHang){
        int id = QLLichPhongVan.getDsLichPhongVan().size() + 1;
        this.maCaPhongVan = "LPV" + id;
        this.khachHang = khachHang;
        this.trangThaiPhongVan = TrangThaiPhongVan.CHO_DUYET;
    }

    public LichPhongVan(String maCaPhongVan, User giangVien, LocalDate ngayThang, LocalTime gioPV, User khachHang, TrangThaiPhongVan trangThaiPhongVan) {
        this.maCaPhongVan = maCaPhongVan;
        this.giangVien = giangVien;
        this.ngayThang = ngayThang;
        this.gioPV = gioPV;
        this.khachHang = khachHang;
        this.trangThaiPhongVan = trangThaiPhongVan;
    }

    public String getMaCaPhongVan() {
        return maCaPhongVan;
    }

    public void setMaCaPhongVan(String maCaPhongVan) {
        this.maCaPhongVan = maCaPhongVan;
    }

    public User getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(User giangVien) {
        this.giangVien = giangVien;
    }

    public LocalDate getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(LocalDate ngayThang) {
        this.ngayThang = ngayThang;
    }

    public LocalTime getGioPV() {
        return gioPV;
    }

    public void setGioPV(LocalTime gioPV) {
        this.gioPV = gioPV;
    }

    public User getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(User khachHang) {
        this.khachHang = khachHang;
    }

    public TrangThaiPhongVan getTrangThaiPhongVan() {
        return trangThaiPhongVan;
    }

    public void setTrangThaiPhongVan(TrangThaiPhongVan trangThaiPhongVan) {
        this.trangThaiPhongVan = trangThaiPhongVan;
    }

    public boolean isValid(){
        return this.getGiangVien() != null && this.getNgayThang() != null && this.getGioPV() != null;
    }
}
