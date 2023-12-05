// MTTK 29/11

package QuanLyDoiTuong;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import Menu.LoadDuLieu;
import NguoiDung.User;
import ThoiGian.CaHoc;
import ThoiGian.Thu;
import Utils.Convert;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

import java.time.LocalTime;
import java.util.ArrayList;

public class QLLopHoc {
  public static ArrayList<LopHoc> dsLopHoc = new ArrayList<>();

  public static ArrayList<LopHoc> getDsLopHoc() {
    return dsLopHoc;
  }

  public static void setDsLopHoc(ArrayList<LopHoc> dsLopHoc) {
    QLLopHoc.dsLopHoc = dsLopHoc;
  }

  // xử lý dữ liệu từ chuỗi thành đối tượng
  public static void xuLyDuLieu(ArrayList<String> duLieu) {
    // duyệt qua duLieu và bắt đầu xử lý!
    for (String temp : duLieu) {
      // tách chuỗi tam
      String[] cacThuocTinh = temp.split("#");

      // thiết lập các thuộc tính cho đối tượng LopHoc
      String maLop = cacThuocTinh[0];
      String tenLop = cacThuocTinh[1];
      TrangThaiLop trangThai = TrangThaiLop.toTrangThaiLop(cacThuocTinh[2]);

      Thu thu1 = null;
      if (!cacThuocTinh[3].equals("")){
          thu1 = Thu.toThu(cacThuocTinh[3]);
      }

      LocalTime gioVaoHoc1 = null;
      if (!cacThuocTinh[4].equals("")){
          gioVaoHoc1 = Convert.stringToTime(cacThuocTinh[4]);
      }

      LocalTime gioTanHoc1 = null;
      if (!cacThuocTinh[5].equals("")){
          gioTanHoc1 = Convert.stringToTime(cacThuocTinh[5]);
      }

      CaHoc caHoc1 = new CaHoc(thu1, gioVaoHoc1, gioTanHoc1);


      Thu thu2 = null;
      if (!cacThuocTinh[6].equals("")){
          thu2 = Thu.toThu(cacThuocTinh[6]);
      }

      LocalTime gioVaoHoc2 = null;
      if (!cacThuocTinh[7].equals("")){
        gioVaoHoc2 = Convert.stringToTime(cacThuocTinh[7]);
      }

      LocalTime gioTanHoc2 = null;
      if (!cacThuocTinh[8].equals("")){
        gioTanHoc2 = Convert.stringToTime(cacThuocTinh[8]);
      }
      CaHoc caHoc2 = new CaHoc(thu2, gioVaoHoc2, gioTanHoc2);

      ArrayList<CaHoc> caHocMacDinh = new ArrayList<>();
      caHocMacDinh.add(caHoc1);
      caHocMacDinh.add(caHoc2);

      KhoaKhaiGiang khoaKhaiGiang = QLKhoaKhaiGiang.timKiemTheoMaKhoa(cacThuocTinh[9]);
      ChuongTrinhHoc chuongTrinhHoc = QLChuongTrinhHoc.timKiemTheoMa(cacThuocTinh[10]);

      PhongHoc phongHoc = null;
      if (!cacThuocTinh[11].equals(" ")){
          phongHoc = QLPhongHoc.timKiemTheoMaPhongHoc(cacThuocTinh[11]);
      }

      User giangVien = null;
      if (!cacThuocTinh[12].equals(" ")) {
          giangVien = QLUser.timUserTheoMa(cacThuocTinh[12]);
      }

      User troGiang = null;
      if (!cacThuocTinh[13].equals(" ")) {
        troGiang = QLUser.timUserTheoMa(cacThuocTinh[13]);
      }

      // tạo ra dối tượng và thêm vào dsLopHoc
      dsLopHoc.add(
          new LopHoc(maLop, tenLop, trangThai, caHocMacDinh, khoaKhaiGiang, chuongTrinhHoc, phongHoc, giangVien,
              troGiang));
    }
  }

  // hàm load dữ liệu từ file
  public static void loadDuLieu() {
    // sửa đường dẫn này:
    String filePath = "src\\Data\\qlLopHoc.txt";

    ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
    xuLyDuLieu(duLieu);
    System.out.println("Đã tải xong LopHoc");
  }

  // xử lý dữ liệu từ đối tượng thành chuỗi để lưu
  public static ArrayList<String> trichXuatDuLieu() {
    ArrayList<String> duLieu = new ArrayList<>();

    for (LopHoc lopHoc : dsLopHoc) {
      String maLop = lopHoc.getMaLop();
      String tenLop = lopHoc.getTenLop();
      String trangThai = TrangThaiLop.toString(lopHoc.getTrangThai());
      String maKhoa = lopHoc.getKhoa().getMaKhoa();
      String maChuongTrinh = lopHoc.getChuongTrinh().getMaChuongTrinh();


      CaHoc caHoc1 = lopHoc.getCaHocMacDinh().get(0);
      String thu1 = Thu.toString(caHoc1.getThu());
      String gioVaoHoc1 = (caHoc1.getGioVaoHoc() != null) ? Convert.timeToString(caHoc1.getGioVaoHoc()) : "";
      String gioTanHoc1 = (caHoc1.getGioTanHoc() != null) ? Convert.timeToString(caHoc1.getGioTanHoc()) : "";

      CaHoc caHoc2 = lopHoc.getCaHocMacDinh().get(1);
      String thu2 = Thu.toString(caHoc2.getThu());
      String gioVaoHoc2 = (caHoc2.getGioVaoHoc() != null) ? Convert.timeToString(caHoc2.getGioVaoHoc()) : "";
      String gioTanHoc2 = (caHoc2.getGioTanHoc() != null) ? Convert.timeToString(caHoc2.getGioTanHoc()) : "";

      String maPhong = (lopHoc.getPhongHocMacDinh() != null) ? lopHoc.getPhongHocMacDinh().getMaPhongHoc() : " ";
      String maGiangVien = (lopHoc.getGiangVien() != null) ? lopHoc.getGiangVien().getMaUser() : " ";
      String maTroGiang = (lopHoc.getTroGiang() != null) ? lopHoc.getTroGiang().getMaUser() : " ";


      StringBuilder sb = new StringBuilder();
      sb
          .append(maLop).append("#")
          .append(tenLop).append("#")
          .append(trangThai).append("#")
          .append(thu1).append("#")
          .append(gioVaoHoc1).append("#")
          .append(gioTanHoc1).append("#")
          .append(thu2).append("#")
          .append(gioVaoHoc2).append("#")
          .append(gioTanHoc2).append("#")
          .append(maKhoa).append("#")
          .append(maChuongTrinh).append("#")
          .append(maPhong).append("#")
          .append(maGiangVien).append("#")
          .append(maTroGiang)
          .append(System.lineSeparator());

      duLieu.add(sb.toString());
    }

    return duLieu;
  }

  // Hàm save dữ liệu vào file
  public static void saveDuLieu() {
    // sửa đường dẫn này:
    String filePath = "src\\Data\\qlLopHoc.txt";

    ArrayList<String> duLieu = trichXuatDuLieu();
    DocGhiFile.ghiDuLieuFile(filePath, duLieu);
    System.out.println("Đã lưu xong LopHoc");
  }

  // hàm in ra danh sách lớp học
  public static void inDanhSach(ArrayList<LopHoc> dsLopHoc) {
    System.out.println("*".repeat(265));
    System.out.printf("* %-10s* %-20s* %-30s* %-30s* %-10s* %-20s* %-20s* %-20s* %-20s* %-20s* %-20s* %-20s*\n",
        "Mã lớp", "Tên lớp", "Ca học 1", "Ca học 2", "Tên khóa", "Tên chương trình",
        "Mã phòng", "Tên cơ sở", "Số lượng học viên", "Trạng thái", "Giảng viên", "Trợ giảng");
    System.out.println("*".repeat(265));

    for (LopHoc lopHoc : dsLopHoc) {
      System.out.printf("* %-10s* %-20s* %-30s* %-30s* %-10s* %-20s* %-20s* %-20s* %-20s* %-20s* %-20s* %-20s*\n",
          lopHoc.getMaLop(),
          lopHoc.getTenLop(),
          lopHoc.getCaHocMacDinh().get(0).toString(),
          lopHoc.getCaHocMacDinh().get(1).toString(),
          lopHoc.getKhoa().getMaKhoa(),
          lopHoc.getChuongTrinh().getKhoaHoc(),


          lopHoc.getPhongHocMacDinh() != null ? lopHoc.getPhongHocMacDinh().getMaPhongHoc(): "Chưa cập nhật",
          lopHoc.getPhongHocMacDinh() != null ? lopHoc.getPhongHocMacDinh().getCoSoTrucThuoc().getTenCoSo(): "Chưa cập nhật",
          QLHocVienLopHoc.demHocVienTheoLopHoc(lopHoc.getMaLop()),
          TrangThaiLop.toString(lopHoc.getTrangThai()),

          lopHoc.getGiangVien() != null ? lopHoc.getGiangVien().getHoTen() : "Chưa cập nhật",
              lopHoc.getTroGiang() != null ? lopHoc.getTroGiang().getHoTen() : "Chưa cập nhật");
    }
    System.out.println("*".repeat(265));
  }

  public static LopHoc timKiemLopTheoMaLop(String maLop) {
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getMaLop().equals(maLop)) {
        return lopHoc;
      }
    }
    return null;
  }

  public static LopHoc timKiemLopTheoMaLop(String maLop, ArrayList<LopHoc> dsLopHoc) {
    for (LopHoc lopHoc : dsLopHoc) {
      if (lopHoc.getMaLop().equals(maLop)) {
        return lopHoc;
      }
    }
    return null;
  }

  public static LopHoc timKiemLopTheoTenLop(String tenLop) {
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


  //Lấy trực tiếp ra những lớp Đang học hoặc Sắp Khai Giảng
  public static ArrayList < LopHoc > timKiemLopTheoGiangVien(String maGV) {
    ArrayList < LopHoc > dsLopHocin = new ArrayList<>();

    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getTrangThai().equals(TrangThaiLop.Cho_Sap_Xep)) {
        continue;
      }

      if (lopHoc.getGiangVien().getMaUser().equals(maGV)
              && (lopHoc.getTrangThai().equals(TrangThaiLop.Sap_Khai_Giang)
              || lopHoc.getTrangThai().equals(TrangThaiLop.Dang_Hoc))) {
        dsLopHocin.add(lopHoc);
      }
    }

    return dsLopHocin;
  }

  public static ArrayList<LopHoc> timKiemLopTheoGiangVien(String maGV, boolean flag) {
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();

    if (flag) {
      for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
        if (lopHoc.getTrangThai().equals(TrangThaiLop.Cho_Sap_Xep)) {
          continue;
        }
        if (lopHoc.getGiangVien().getMaUser().equals(maGV)) {
          dsLopHocin.add(lopHoc);
        }
      }
      return dsLopHocin;
    }
    dsLopHocin = timKiemLopTheoGiangVien(maGV);
    return dsLopHocin;
  }




  //Lấy trực tiếp ra những lớp Đang học hoặc Sắp Khai Giảng
  public static ArrayList<LopHoc> timKiemLopTheoTroGiang(String maTG) {
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getTroGiang().getMaUser().equals(maTG)
              && (lopHoc.getTrangThai().equals(TrangThaiLop.Sap_Khai_Giang) || lopHoc.getTrangThai().equals(TrangThaiLop.Dang_Hoc))) {
        dsLopHocin.add(lopHoc); // Bạn cần thêm dòng này để thêm lớp học vào danh sách
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

  public static ArrayList<LopHoc> timKiemLopTheoTrangThai(TrangThaiLop trangThai1, TrangThaiLop trangThai2) {
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();
    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if (lopHoc.getTrangThai().equals(trangThai1) || lopHoc.getTrangThai().equals(trangThai2)) {
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

  public static ArrayList<LopHoc> timKiemLopTheoTrangThai(ArrayList<LopHoc> dsLopHoc, TrangThaiLop trangThai1, TrangThaiLop trangThai2) {
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();
    for (LopHoc lopHoc : dsLopHoc) {
      if (lopHoc.getTrangThai().equals(trangThai1) || lopHoc.getTrangThai().equals(trangThai2)) {
        dsLopHocin.add(lopHoc);
      }
    }
    return dsLopHocin;
  }

  public static ArrayList<LopHoc> timKiemLopTheoPhongHoc(String maPhong){
    ArrayList<LopHoc> dsLopHocin = new ArrayList<>();

    for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
      if(lopHoc.getTrangThai().equals(TrangThaiLop.Cho_Sap_Xep)){
        continue;
      }
      if (lopHoc.getPhongHocMacDinh().getMaPhongHoc().equals(maPhong)) {
        dsLopHocin.add(lopHoc);
      }
    }
    return dsLopHocin;
  }


  public static void taoLopMoi(){
        String tenLop;
        String khoa;
        String chuongTrinhHoc;



        ArrayList<KhoaKhaiGiang> dsKhoaHopLe = QLKhoaKhaiGiang.timKiemKhoaChuaBatDau();
        QLKhoaKhaiGiang.inDanhSachKhoaKhaiGiang(dsKhoaHopLe);
        System.out.println("Nhập mã khóa khai giảng");
        khoa = ScannerUtils.inputString();

        QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
        System.out.println("Nhập mã khóa chương trình học");
        chuongTrinhHoc = ScannerUtils.inputString();

        System.out.println("Nhập tên lớp: ");
        tenLop = ScannerUtils.inputString();


        LopHoc lopHoc = new LopHoc(tenLop, QLKhoaKhaiGiang.timKiemTheoMaKhoa(khoa), QLChuongTrinhHoc.timKiemTheoMa(chuongTrinhHoc));

        QLLopHoc.getDsLopHoc().add(lopHoc);
        System.out.println("Đã thêm lớp");
    }


  // test
  public static void main(String[] args) {
    System.out.println("hi");
    LoadDuLieu.loading();
    System.out.println(dsLopHoc.size());
    inDanhSach(dsLopHoc);
    saveDuLieu();
  }

}
