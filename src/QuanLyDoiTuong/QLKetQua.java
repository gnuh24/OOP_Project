package QuanLyDoiTuong;

import java.util.ArrayList;
import java.util.List;

import HeThongGiaoDuc.LopHoc.KetQua;

public class QLKetQua {
  private static ArrayList<KetQua> dsKetQua = new ArrayList<>();

  public static ArrayList<KetQua> getDsKetQua() {
    return dsKetQua;
  }

  public static void setDsKetQua(ArrayList<KetQua> dsKetQua) {
    QLKetQua.dsKetQua = dsKetQua;
  }

  public static KetQua timKiemTheoMa(String maKetQua) {
    for (KetQua ketQua : dsKetQua) {
      if (ketQua.getMaKetQua().equals(maKetQua)) {
        return ketQua;
      }
    }

    return null;
  }

  public static List<KetQua> timKiemTheoHocVien(String maHocVien) {
    ArrayList<KetQua> ketQuaTimKiem = new ArrayList<>();
    for (KetQua ketQua : dsKetQua) {
      if (ketQua.getHocVienLopHoc().getHocVien().getMaUser().equals(maHocVien)) {
        ketQuaTimKiem.add(ketQua);
      }
    }

    return ketQuaTimKiem;
  }

  public static List<KetQua> timKiemTheoLopHoc(String malopHoc) {
    ArrayList<KetQua> ketQuaTimKiem = new ArrayList<>();
    for (KetQua ketQua : dsKetQua) {
      if (ketQua.getHocVienLopHoc().getLopHoc().getMaLop().equals(malopHoc)) {
        ketQuaTimKiem.add(ketQua);
      }
    }

    return ketQuaTimKiem;
  }
}
