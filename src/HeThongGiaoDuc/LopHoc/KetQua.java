// MTTK
package HeThongGiaoDuc.LopHoc;

import QuanLyDoiTuong.QLKetQua;

public class KetQua {
  String maKetQua;
  HocVienLopHoc hocVienLopHoc;
  double diem;
  String danhGia;

  // Constructor nay chi duoc su dung ben trong class
  public KetQua(String maKetQua, HocVienLopHoc hocVienLopHoc, double diem, String danhGia) {
    this.maKetQua = maKetQua;
    this.hocVienLopHoc = hocVienLopHoc;
    this.diem = diem;
    this.danhGia = danhGia;
  }

  public KetQua(HocVienLopHoc hocVienLopHoc, double diem, String danhGia) {
    this.maKetQua = autoIncreament();
  }



  private String autoIncreament(){
      int size = QLKetQua.getDsKetQua().size() + 1;
      return "KQ" + size;
  }


  public String getMaKetQua() {
    return maKetQua;
  }

  public void setMaKetQua(String maKetQua) {
    this.maKetQua = maKetQua;
  }

  public HocVienLopHoc getHocVienLopHoc() {
    return hocVienLopHoc;
  }

  public void setHocVienLopHoc(HocVienLopHoc hocVienLopHoc) {
    this.hocVienLopHoc = hocVienLopHoc;
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