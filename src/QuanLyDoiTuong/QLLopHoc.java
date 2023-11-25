package QuanLyDoiTuong;

import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;

import java.util.ArrayList;

public class QLLopHoc {
  public static ArrayList<LopHoc> dsLopHoc = new ArrayList<>();

  public static ArrayList<LopHoc> getDsLopHoc() {
    return dsLopHoc;
  }

  public static void setDsLopHoc(ArrayList<LopHoc> dsLopHoc) {
    QLLopHoc.dsLopHoc = dsLopHoc;
  }

  public static void inDSLopHoc(ArrayList<LopHoc> dsLopHoc) {
    System.out.println("*".repeat(151));
    System.out.printf("* %-10s* %-10s* %-10s* %-10s* %-10s* %-20s* %-10s* %-10s* %-20s* %-20s*\n",
        "Mã lớp", "Tên lớp", "Ca học 1", "Ca học 2", "Tên khóa", "Ma chuong trinh",
        "Mã phòng", "Tên cơ sở", "Số lượng học viên", "Tình trạng");
    System.out.println("*".repeat(151));

    for (LopHoc lopHoc : dsLopHoc) {
      System.out.printf("* %-10s* %-10s* %-10s* %-10s* %-10s* %-20s* %-10s* %-10s* %-20s* %-20s*\n",
          lopHoc.getMaLop(), lopHoc.getTenLop(), lopHoc.getCaHocMacDinh().get(0).toString(),
          lopHoc.getCaHocMacDinh().get(1).toString(),
          lopHoc.getKhoa().getMaKhoa(), lopHoc.getChuongTrinh().getKhoaHoc(),
          lopHoc.getPhongHocMacDinh().getMaPhongHoc(),
          lopHoc.getPhongHocMacDinh().getCoSoTrucThuoc().getTenCoSo(),
          QLHocVienLopHoc.demHocVienTheoLopHoc(lopHoc.getMaLop()),
          lopHoc.getTrangThai());
    }
    System.out.println("*".repeat(151));

  }

  public static LopHoc tinKiemLopTheoMaLop(String maLop) {
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getMaLop().equals(maLop)) {
        return lopHoc;
      }
    }
    return null;
  }

  public static LopHoc tinKiemLopTheoTenLop(String tenLop) {
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getTenLop().equals(tenLop)) {
        return lopHoc;
      }
    }
    return null;
  }

  public static ArrayList<LopHoc> timKiemLopTheoKhoa(String maKhoa) {
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getKhoa().getMaKhoa().equals(maKhoa)) {
        dsLopHocin.add(lopHoc);
      }
    }
    return dsLopHocin;
  }

  public static ArrayList<LopHoc> timKiemLopTheoGiangVien(String maGV) {
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getGiangVien().getMaUser().equals(maGV)) {
        dsLopHocin.add(lopHoc);
      }
    }
    return dsLopHocin;
  }

  public static ArrayList<LopHoc> timKiemLopTheoTroGiang(String maTG) {
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getTroGiang().getMaUser().equals(maTG)) {
        dsLopHocin.add(lopHoc);
      }
    }
    return dsLopHocin;
  }

  public static ArrayList<LopHoc> timKiemLopTheoChuongTrinh(String maChuongTrinhHoc) {
    ArrayList<LopHoc> dsLopHoc = new ArrayList<>();
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getChuongTrinh().getMaChuongTrinh().equals(maChuongTrinhHoc)) {
        dsLopHoc.add(lopHoc);
      }
    }
    return dsLopHoc;
  }

  public static ArrayList<LopHoc> timKiemLopTheoTrangThai(TrangThaiLop trangThai) {
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getTrangThai().equals(trangThai)) {
        dsLopHocin.add(lopHoc);
      }
    }
    return dsLopHocin;
  }

  public static ArrayList<LopHoc> timKiemLopTheoTrangThai(ArrayList<LopHoc> dsLopHoc, TrangThaiLop trangThai) {
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();
    for (LopHoc lopHoc : dsLopHoc) {
      if (lopHoc.getTrangThai().equals(trangThai)) {
        dsLopHocin.add(lopHoc);
      }
    }
    return dsLopHocin;
  }

}
