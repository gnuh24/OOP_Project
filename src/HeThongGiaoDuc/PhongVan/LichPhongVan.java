package HeThongGiaoDuc.PhongVan;

import QuanLyDoiTuong.QLLichPhongVan;
import ThoiGian.Gio;
import ThoiGian.NgayThang;

public class LichPhongVan {
    private String maCaPhongVan;

    private GiangVien giangVien;

    private NgayThang ngayThang;

    private Gio gioPV;

    private KhachHang khachHang;

    private TrangThaiPhongVan trangThaiPhongVan;

    public LichPhongVan(){}

    public LichPhongVan(KhachHang khachHang){
        int id = QLLichPhongVan.getDsLichPhongVan().size() + 1;
        this.maCaPhongVan = "LPV" + id;
        this.khachHang = khachHang;
        this.trangThaiPhongVan = TrangThaiPhongVan.CHO_DUYET;
    }

    public LichPhongVan(String maCaPhongVan, GiangVien giangVien, NgayThang ngayThang, Gio gioPV, KhachHang khachHang, TrangThaiPhongVan trangThaiPhongVan) {
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

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public NgayThang getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(NgayThang ngayThang) {
        this.ngayThang = ngayThang;
    }

    public Gio getGioPV() {
        return gioPV;
    }

    public void setGioPV(Gio gioPV) {
        this.gioPV = gioPV;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
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
