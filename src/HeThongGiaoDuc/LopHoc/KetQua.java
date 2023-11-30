// MTTK
package HeThongGiaoDuc.LopHoc;

import NguoiDung.User;
import QuanLyDoiTuong.QLKetQua;

public class KetQua {
  User hocVien;
  LopHoc lopHoc;
  double diem;
  String danhGia;
  

  // Constructor nay chi duoc su dung ben trong class

  public KetQua() {
  }
  
  public KetQua(User hocVien, LopHoc lopHoc) {
    this.hocVien = hocVien;
    this.lopHoc = lopHoc;
    this.diem=-1;
    this.danhGia="Chưa có đánh giá";
  }

  public KetQua(User hocVien, LopHoc lopHoc, double diem, String danhGia) {
    this.hocVien = hocVien;
    this.lopHoc = lopHoc;
    this.diem = diem;
    this.danhGia = danhGia;
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
  public double getDiem() {
    return diem;
  }
  public void setDiem(double diem) {
    this.diem = diem;
  }
  public String getDanhGia() {
    return danhGia;
  }
  public void setDanhGia(String danhGia) {
    this.danhGia = danhGia;
  }


}