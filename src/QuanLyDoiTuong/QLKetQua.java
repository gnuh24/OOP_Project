package QuanLyDoiTuong;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
import HeThongGiaoDuc.LopHoc.KetQua;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import NguoiDung.User;
import ThoiGian.CaHoc;
import ThoiGian.Thu;
import Utils.Convert;
import Utils.DocGhiFile;

public class QLKetQua {
  // data
  private static ArrayList<KetQua> dsKetQua = new ArrayList<>();

  // getter
  public static ArrayList<KetQua> getDsKetQua() {
    return dsKetQua;
  }

  // setter
  public static void setDsKetQua(ArrayList<KetQua> dsKetQua) {
    QLKetQua.dsKetQua = dsKetQua;
  }

  // hàm xử lý dữ liệu từ chuỗi thành đối tượng
  // CẤU TRÚC MỘT DÒNG DỮ LIỆU TRONG FILE:
  // "(MÃ USER)#(MÃ LỚP HỌC)#(ĐIỂM)#(ĐÁNH GIÁ)"
  public static void xuLyDuLieu(ArrayList<String> duLieu) {
    // duyệt qua duLieu và bắt đầu xử lý!
    for (String temp : duLieu) {
      // tách chuỗi tam
      String[] cacThuocTinh = temp.split("#");

      // thiết lập các thuộc tính cho đối tượng KetQua
      String maHocVien = cacThuocTinh[0];
      String maLopHoc = cacThuocTinh[1];
      HocVienLopHoc hocVienLopHoc = QLHocVienLopHoc.timKiemTheoMaHocVienMaLopHoc(maHocVien, maLopHoc);
      double diem = Double.parseDouble(cacThuocTinh[2]);
      String danhGia = cacThuocTinh[3];

      // tạo ra dối tượng và thêm vào dsKetQua
      dsKetQua.add(
          new KetQua(hocVienLopHoc, diem, danhGia));
    }
  }

  // hàm load dữ liệu từ file
  public static void loadDuLieu() {
    // sửa đường dẫn này:
    String filePath = "D:\\learning\\do-an\\oop\\OOP_Project\\src\\Data\\qlKetQua.txt";

    ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
    xuLyDuLieu(duLieu);
    System.out.println("Đã tải xong KetQua");
  }

  // xử lý dữ liệu từ đối tượng thành chuỗi để lưu
  public static ArrayList<String> trichXuatDuLieu() {
    ArrayList<String> duLieu = new ArrayList<>();

    for (KetQua ketQua : dsKetQua) {
      StringBuilder sb = new StringBuilder();
      sb
          .append(ketQua.getHocVienLopHoc().getHocVien().getMaUser()).append("#")
          .append(ketQua.getHocVienLopHoc().getLopHoc().getMaLop())
          .append(System.lineSeparator());

      duLieu.add(sb.toString());
    }

    return duLieu;
  }

  // Hàm save dữ liệu vào file
  public static void saveDuLieu() {
    // sửa đường dẫn này:
    String filePath = "D:\\learning\\do-an\\oop\\OOP_Project\\src\\Data\\qlKetQua_save.txt";

    ArrayList<String> duLieu = trichXuatDuLieu();
    DocGhiFile.ghiDuLieuFile(filePath, duLieu);
    System.out.println("Đã lưu xong KetQua");
  }

  // hàm in ra danh sách kết quả
  public static void inDanhSach(ArrayList<KetQua> dsKetQua) {
    System.out.println("*".repeat(123));
    System.out.printf("%-20s* %-25s* %-10s* %-10s* %-50s*\n",
        "Mã kết quả", "Tên học viên", "Tên lớp học", "Điểm", "Đánh giá");
    System.out.println("*".repeat(123));

    for (KetQua ketQua : dsKetQua) {
      System.out.printf("%-20s* %-25s* %-10s* %-10s* %-50s*\n",
          ketQua.getMaKetQua(),
          ketQua.getHocVienLopHoc().getHocVien().getHoTen(),
          ketQua.getHocVienLopHoc().getLopHoc().getTenLop(),
          ketQua.getDiem(),
          ketQua.getDanhGia());
      System.out.println("*".repeat(123));
    }
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

  public static void main(String[] args) {
    loadDuLieu();
  }
}
