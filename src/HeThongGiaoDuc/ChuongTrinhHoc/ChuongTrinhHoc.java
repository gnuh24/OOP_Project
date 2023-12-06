package HeThongGiaoDuc.ChuongTrinhHoc;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChuongTrinhHoc {
    private String maChuongTrinh;

    private String theLoai;

    private String trinhDo;

    private String khoaHoc;
    private int thoiLuong;
    private double hocPhi;

    public ChuongTrinhHoc() {
    }

    public ChuongTrinhHoc(String maChuongTrinh,String theLoai, String trinhDo, String khoaHoc, int thoiLuong,  double hocPhi) {
        this.maChuongTrinh = maChuongTrinh;
        this.theLoai = theLoai;
        this.trinhDo = trinhDo;
        this.khoaHoc = khoaHoc;
        this.thoiLuong = thoiLuong;
        this.hocPhi = hocPhi;
    }

    public String getMaChuongTrinh() {
        return maChuongTrinh;
    }

    public void setMaChuongTrinh(String maChuongTrinh) {
        this.maChuongTrinh = maChuongTrinh;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

}
