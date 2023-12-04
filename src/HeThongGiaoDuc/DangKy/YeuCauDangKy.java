package HeThongGiaoDuc.DangKy;

import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import NguoiDung.User;
import QuanLyDoiTuong.QLYeuCauDangKy;

import java.time.LocalDate;

public class YeuCauDangKy {
    private String maDangKy;
    private User hocVien;

    private LopHoc lopHoc;

    private double tongHocPhi;

    private TrangThaiDangKy trangThaiDangKy;

    private KhuyenMai khuyenMai;


    private LocalDate localDate;



    //Đơn đăng ký bình thường ( Dùng cho trường hơợp vừa đăng ký vừa đóng tiền)
    public YeuCauDangKy(User hocVien, LopHoc lopHoc, double soTienDaDong){
        this.maDangKy = autoIncrement();
        this.hocVien = hocVien;
        this.lopHoc = lopHoc;
        if (lopHoc.getTrangThai().equals(TrangThaiLop.Sap_Khai_Giang)){
            if (soTienDaDong == lopHoc.getChuongTrinh().getHocPhi() * 70 /100){
                this.tongHocPhi = lopHoc.getChuongTrinh().getHocPhi() * 70 /100;
                this.khuyenMai = KhuyenMai.GIAM30_HocPhi;
            }
            else{
                this.tongHocPhi = lopHoc.getChuongTrinh().getHocPhi() * 85 /100;
                this.khuyenMai = KhuyenMai.GIAM15_HocPhi;
            }
        }
        this.trangThaiDangKy = TrangThaiDangKy.DA_GHI_DANH;
        this.localDate = LocalDate.now();
    }



    //Đơn đăng ký bình thường ( Dùng cho trường hơợp chỉ đăng ký nhưng không đóng tiền)
    public YeuCauDangKy(User hocVien, LopHoc lopHoc){
        this.maDangKy = autoIncrement();
        this.hocVien = hocVien;
        this.lopHoc = lopHoc;
        this.tongHocPhi = lopHoc.getChuongTrinh().getHocPhi();
        this.trangThaiDangKy = TrangThaiDangKy.DA_GHI_DANH;
        this.khuyenMai = KhuyenMai.Qua_Luu_Niem;
        this.localDate = LocalDate.now();
    }


    public YeuCauDangKy(String maDangKy, User hocVien, LopHoc lopHoc, double tongHocPhi, TrangThaiDangKy trangThaiDangKy, KhuyenMai khuyenMai, LocalDate localDate) {
        this.maDangKy = maDangKy;
        this.hocVien = hocVien;
        this.lopHoc = lopHoc;
        this.tongHocPhi = tongHocPhi;
        this.trangThaiDangKy = trangThaiDangKy;
        this.khuyenMai = khuyenMai;
        this.localDate = localDate;
    }

    private String autoIncrement(){
        int a = QLYeuCauDangKy.getDsYeuCauDangKy().size() + 1;
        return "YCDK" + a;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
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

    public double getTongHocPhi() {
        return tongHocPhi;
    }

    public void setTongHocPhi(double tongHocPhi) {
        this.tongHocPhi = tongHocPhi;
    }

    public void setTongHocPhi(int tongHocPhi) {
        this.tongHocPhi = tongHocPhi;
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
