package HeThongGiaoDuc.LopHoc;

import NguoiDung.User;

public class HocVienLopHoc {
  LopHoc lopHoc;
  User hocVien;

  public HocVienLopHoc() {
  }

  public HocVienLopHoc(LopHoc lopHoc, User hocVien) {
    this.lopHoc = lopHoc;
    this.hocVien = hocVien;
  }

  public LopHoc getLopHoc() {
    return lopHoc;
  }

  public void setLopHoc(LopHoc lopHoc) {
    this.lopHoc = lopHoc;
  }

  public User getHocVien() {
    return hocVien;
  }

  public void setHocVien(User hocVien) {
    this.hocVien = hocVien;
  }

}
