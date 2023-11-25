package QuanLyDoiTuong;

import HeThongGiaoDuc.LopHoc.HocVienLopHoc;

import java.util.ArrayList;

public class QLHocVienLopHoc {
  public static ArrayList<HocVienLopHoc> dsHocVienLopHoc;

  public static ArrayList<HocVienLopHoc> getDsHocVienLophoc() {
    return dsHocVienLopHoc;
  }

  public static void setDsHocVienLophoc(ArrayList<HocVienLopHoc> dsHocVienLopHoc) {
    QLHocVienLopHoc.dsHocVienLopHoc = dsHocVienLopHoc;
  }

  public static HocVienLopHoc timKienTheHocVien(String maHocVien) {
    for (HocVienLopHoc hocVienLophoc : dsHocVienLopHoc) {
      if (hocVienLophoc.getHocVien().getMaUser().equals(maHocVien)) {
        return hocVienLophoc;
      }
    }
    return null;
  }

  public static ArrayList<HocVienLopHoc> timDSHocVienTheoLopHoc(String maLopHoc) {
    ArrayList<HocVienLopHoc> dsHocVien = new ArrayList<>();
    for (HocVienLopHoc hocVienLophoc : dsHocVienLopHoc) {
      if (hocVienLophoc.getLopHoc().getMaLop().equals(maLopHoc)) {
        dsHocVien.add(hocVienLophoc);
      }
    }
    return dsHocVien;
  }

  public static int demHocVienTheoLopHoc(String maLop) {
    int dem = 0;
    for (HocVienLopHoc hocVienLophoc : dsHocVienLopHoc) {
      if (hocVienLophoc.getLopHoc().getMaLop().equals(maLop)) {
        dem++;
      }
    }
    return dem;
  }
}
