package HeThongGiaoDuc.LopHoc;

import NguoiDung.User;

public class HocVienLopHoc {
  User hocVien;
  LopHoc lopHoc;

  public HocVienLopHoc() {
  }

  public HocVienLopHoc(User hocVien, LopHoc lopHoc) {
    this.hocVien = hocVien;
    this.lopHoc = lopHoc;
  }

  public User getHocVien() {
    return hocVien;
  }

  public LopHoc getLopHoc() {
    return lopHoc;
  }

  public void setHocVien(User hocVien) {
    this.hocVien = hocVien;
  }

  public void setLopHoc(LopHoc lopHoc) {
    this.lopHoc = lopHoc;
  }

}
