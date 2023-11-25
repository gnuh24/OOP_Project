package HeThongGiaoDuc.DangKy;

import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import NguoiDung.User;
import QuanLyDoiTuong.QLYeuCauDangKy;

public class YeuCauDangKy {
    private String maDangKy;
    private User hocVien;

    private LopHoc lopHoc;

    private int soTienPhaiDong;

    private TrangThaiDangKy trangThaiDangKy;

    private KhuyenMai khuyenMai;




    public YeuCauDangKy(String maDangKy, User hocVien, LopHoc lopHoc, int soTienPhaiDong, TrangThaiDangKy trangThaiDangKy, KhuyenMai khuyenMai) {
        this.maDangKy = maDangKy;
        this.hocVien = hocVien;
        this.lopHoc = lopHoc;
        this.soTienPhaiDong = soTienPhaiDong;
        this.trangThaiDangKy = trangThaiDangKy;
        this.khuyenMai = khuyenMai;
    }


    private String autoIncrement(){
        int a = QLYeuCauDangKy.getDsYeuCauDangKy().size() + 1;
        return "YCDK" + a;
    }

    public String getMaDangKy() {
        return maDangKy;
    }

    public void setMaDangKy(String maDangKy) {
        this.maDangKy = maDangKy;
    }

    public User getHocVien() {
        return hocVien;
    }

    public void setHocVien(User hocVien) {
        this.hocVien = hocVien;
    }

    public LopHoc getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }

    public int getSoTienPhaiDong() {
        return soTienPhaiDong;
    }

    public void setSoTienPhaiDong(int soTienPhaiDong) {
        this.soTienPhaiDong = soTienPhaiDong;
    }

    public TrangThaiDangKy getTrangThaiDangKy() {
        return trangThaiDangKy;
    }

    public void setTrangThaiDangKy(TrangThaiDangKy trangThaiDangKy) {
        this.trangThaiDangKy = trangThaiDangKy;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
}
