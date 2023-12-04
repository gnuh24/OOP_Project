package HeThongGiaoDuc.DangKy;

import QuanLyDoiTuong.QLBienLai;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BienLai {
    private String maBienLai;
    private YeuCauDangKy yeuCauDangKy;
    private double soTienDaDong;
    private LocalDateTime ngayThanhToan;
    public BienLai() {
    }

    public BienLai(YeuCauDangKy yeuCauDangKy, double soTienDaDong) {
        this.maBienLai = autoIncrement();
        this.yeuCauDangKy = yeuCauDangKy;
        this.soTienDaDong = soTienDaDong;
        this.ngayThanhToan = LocalDateTime.now();
    }

    public BienLai(String maBienLai, YeuCauDangKy yeuCauDangKy, double soTienDaDong, LocalDateTime ngayThanhToan) {
        this.maBienLai = maBienLai;
        this.yeuCauDangKy = yeuCauDangKy;
        this.soTienDaDong = soTienDaDong;
        this.ngayThanhToan = ngayThanhToan;
    }

    private String autoIncrement(){
        int a = QLBienLai.getDsBienLai().size() + 1;
        return  "BL" + a;
    }
    public String getMaBienLai() {
        return maBienLai;
    }
    public void setMaBienLai(String maBienLai) {
        this.maBienLai = maBienLai;
    }
    public YeuCauDangKy getYeuCauDangKy() {
        return yeuCauDangKy;
    }
    public void setYeuCauDangKy(YeuCauDangKy yeuCauDangKy) {
        this.yeuCauDangKy = yeuCauDangKy;
    }
    public double getSoTienDaDong() {
        return soTienDaDong;
    }
    public void setSoTienDaDong(double soTienDaDong) {
        this.soTienDaDong = soTienDaDong;
    }
    public LocalDateTime getNgayThanhToan() {
        return ngayThanhToan;
    }
    public void setNgayThanhToan(LocalDateTime ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public void inBienLai(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        System.out.println("-----------Biên lai-----------");
        System.out.println("Mã biên lai: "+this.getMaBienLai());
        System.out.println("Học Viên: "+this.getYeuCauDangKy().getHocVien().getHoTen());
        System.out.println("Mã học viên: "+this.getYeuCauDangKy().getHocVien().getMaUser());
        System.out.println("Lớp: "+this.getYeuCauDangKy().getLopHoc().getMaLop());
        System.out.println("Số tiền: "+this.getSoTienDaDong());
        System.out.println("Ngày đóng: "+this.getNgayThanhToan().format(formatter));
    }

}
