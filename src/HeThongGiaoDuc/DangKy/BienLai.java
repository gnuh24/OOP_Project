package HeThongGiaoDuc.DangKy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BienLai {
    private String maBienLai;
    private YeuCauDangKy yeuCauDangKy;
    private int soTienDaDong;
    private LocalDateTime ngayThanhToan;
    public BienLai() {
    }
    public BienLai(String maBienLai, YeuCauDangKy yeuCauDangKy, int soTienDaDong, LocalDateTime ngayThanhToan) {
        this.maBienLai = maBienLai;
        this.yeuCauDangKy = yeuCauDangKy;
        this.soTienDaDong = soTienDaDong;
        this.ngayThanhToan = ngayThanhToan;
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
    public int getSoTienDaDong() {
        return soTienDaDong;
    }
    public void setSoTienDaDong(int soTienDaDong) {
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

    // public static void main(String[] args) {
    //     DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    //     LocalDateTime day = LocalDateTime.now();
    // }

}
