package QuanLyDoiTuong;

import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
import HeThongGiaoDuc.LopHoc.KetQua;
import HeThongGiaoDuc.LopHoc.LopHoc;
import NguoiDung.User;
import ThoiGian.CaHoc;
import ThoiGian.Thu;
import Utils.Convert;
import Utils.DocGhiFile;

import java.time.LocalTime;
import java.util.ArrayList;

public class QLHocVienLopHoc {
  // data
  public static ArrayList<HocVienLopHoc> dsHocVienLopHoc = new ArrayList<>();

  // getter
  public static ArrayList<HocVienLopHoc> getDsHocVienLophoc() {
    return dsHocVienLopHoc;
  }

  // setter
  public static void setDsHocVienLophoc(ArrayList<HocVienLopHoc> dsHocVienLopHoc) {
    QLHocVienLopHoc.dsHocVienLopHoc = dsHocVienLopHoc;
  }

  // xử lý dữ liệu từ chuỗi thành đối tượng
  // CẤU TRÚC MỘT DÒNG DỮ LIỆU TRONG FILE:
  // "(MÃ USER)#(MÃ LỚP HỌC)"
  public static void xuLyDuLieu(ArrayList<String> duLieu) {
    // duyệt qua duLieu và bắt đầu xử lý!
    for (var tam : duLieu) {
      // tách chuỗi tam
      String[] cacThuocTinh = tam.split("#");

      // thiết lập các thuộc tính cho đối tượng
      User hocVien = QLUser.timUserTheoMa(cacThuocTinh[0]);
      LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(cacThuocTinh[1]);

      // tạo ra đối tượng và thêm vào danh sách
      dsHocVienLopHoc.add(new HocVienLopHoc(hocVien, lopHoc));
    }
  }

  // Hàm load dữ liệu từ file
  public static void loadDuLieu() {
    // Sửa đường dẫn này:
    String filePath = "src\\Data\\qlHocVienLopHoc.txt";

    ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
    xuLyDuLieu(duLieu);
    System.out.println("Đã tải xong Học viên Lớp học");
  }

  // xử lý dữ liệu từ đối tượng thành chuỗi để lưu
  public static ArrayList<String> trichXuatDuLieu() {
    ArrayList<String> duLieu = new ArrayList<>();

    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      StringBuilder sb = new StringBuilder();

      sb
          .append(hocVienLopHoc.getHocVien().getMaUser()).append("#")
          .append(hocVienLopHoc.getLopHoc().getMaLop())
          .append(System.lineSeparator());

      duLieu.add(sb.toString());
    }

    return duLieu;
  }

  // Hàm save dữ liệu vào file
  public static void saveDuLieu() {
    // sửa đường dẫn này:
    String filePath = "src\\Data\\qlHocVienLopHoc.txt";

    ArrayList<String> duLieu = trichXuatDuLieu();
    DocGhiFile.ghiDuLieuFile(filePath, duLieu);
    System.out.println("Đã lưu xong Học viên Lớp Học");
  }

  // hàm in ra danh sách HocVienLopHoc
  public static void inDanhSach(ArrayList<HocVienLopHoc> dHocVienLopHoc) {
    System.out.println("*".repeat(68));
    System.out.printf("%-30s* %-35s*\n",
        "Tên học viên", "Tên lớp học");
    System.out.println("*".repeat(68));

    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      System.out.printf("%-30s* %-35s*\n",
          hocVienLopHoc.getHocVien().getHoTen(),
          hocVienLopHoc.getLopHoc().getTenLop());
      System.out.println("*".repeat(68));
    }
  }

  public static HocVienLopHoc timKiemTheoMaHocVienMaLopHoc(String maHocVien, String maLopHoc) {
    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      if (hocVienLopHoc.getHocVien().getMaUser().equals(maHocVien)
          && hocVienLopHoc.getLopHoc().getMaLop().equals(maLopHoc)) {
        return hocVienLopHoc;
      }
    }

    return null;
  }

  public static ArrayList<HocVienLopHoc> danhSachTheoHocVien(String maHocVien) {
    ArrayList<HocVienLopHoc> ketQuaTimKiem = new ArrayList<>();

    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      if (hocVienLopHoc.getHocVien().getMaUser().equals(maHocVien)) {
        ketQuaTimKiem.add(hocVienLopHoc);
      }
    }
    return ketQuaTimKiem;
  }

  public static ArrayList<HocVienLopHoc> danhSachTheoLopHoc(String maLopHoc) {
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

  // test
  public static void main(String[] args) {
    loadDuLieu();
  }
}
