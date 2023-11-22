package HeThongGiaoDuc.LopHoc;

import NguoiDung.HocVien;

public class HocVienLopHoc {
    LopHoc lopHoc;
    HocVien hocVien;

    public HocVienLopHoc() {
    }

    public HocVienLopHoc(LopHoc lopHoc, HocVien hocVien) {
        this.lopHoc = lopHoc;
        this.hocVien = hocVien;
    }

    public LopHoc getLopHoc() {
        return lopHoc;
    }
    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }
    public HocVien getHocVien() {
        return hocVien;
    }
    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    
}
