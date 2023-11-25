package HeThongGiaoDuc.DangKy;

import HeThongGiaoDuc.LopHoc.LopHoc;
import NguoiDung.User;

public class YeuCauDangKy {
    private String maDangKy;
    private User hocVien;

    private LopHoc lopHoc;

    private int soTienPhaiDong;

    private TrangThaiDangKy trangThaiDangKy;



    public YeuCauDangKy(String maDangKy, User hocVien, LopHoc lopHoc, int soTienPhaiDong, TrangThaiDangKy trangThaiDangKy) {
        this.maDangKy = maDangKy;
        this.hocVien = hocVien;
        this.lopHoc = lopHoc;
        this.soTienPhaiDong = soTienPhaiDong;
        this.trangThaiDangKy = trangThaiDangKy;
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
}
