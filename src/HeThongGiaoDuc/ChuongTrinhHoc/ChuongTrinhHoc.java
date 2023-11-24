package HeThongGiaoDuc.ChuongTrinhHoc;


public class ChuongTrinhHoc {
    private String maChuongTrinh;

    private String theLoai;

    private String trinhDo;

    private String khoaHoc;
    private int thoiLuong;
    private int hocPhi;

    public ChuongTrinhHoc() {
    }

    public static void main(String[] args) {
        System.out.println("Nguyễn Nhật Trường".equals("Nguyễn Nhật Trường"));
    }


    public ChuongTrinhHoc(String maChuongTrinh,String theLoai, String trinhDo, String khoaHoc, int thoiLuong,  int hocPhi) {
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

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }
}
