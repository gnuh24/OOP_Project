// MTTK 29/11

package QuanLyDoiTuong;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import NguoiDung.User;
import NguoiDung.VaiTro;
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
      if (lopHoc.getTrangThai().equals(TrangThaiLop.Cho_Sap_Xep)){
        continue;
      }
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

  public static ArrayList<LopHoc> timKiemLopTheoPhongHoc(String maPhong, boolean flag){
    if(flag){
      ArrayList<LopHoc> dsLopHocin = new ArrayList<>();

      for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
        if(lopHoc.getTrangThai().equals(TrangThaiLop.Cho_Sap_Xep)){
          continue;
        }
        if (lopHoc.getPhongHocMacDinh().getMaPhongHoc().equals(maPhong) &&
                ( lopHoc.getTrangThai().equals(TrangThaiLop.Dang_Hoc) ||
            lopHoc.getTrangThai().equals(TrangThaiLop.Sap_Khai_Giang)) ) {
              dsLopHocin.add(lopHoc);
        }
      }

      return dsLopHocin;
    }

    return timKiemLopTheoPhongHoc(maPhong);
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
        System.out.println("Ấn 1 để thoát");
        khoa = ScannerUtils.inputString();
        if (khoa.equals("1")){
          return;
        }

        KhoaKhaiGiang khoaKhaiGiang = QLKhoaKhaiGiang.timKiemTheoMaKhoa(khoa);
        while (khoaKhaiGiang == null){
          System.err.println("Khóa không tồn tại !!! Nhập lại !!");
          System.out.println("Ấn 1 để thoát");
          khoa = ScannerUtils.inputString();
          if (khoa.equals("1")){
            return;
          }
          khoaKhaiGiang = QLKhoaKhaiGiang.timKiemTheoMaKhoa(khoa);
        }

        QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
        System.out.println("Nhập mã khóa chương trình học");
        System.out.println("Ấn 1 để thoát");
        chuongTrinhHoc = ScannerUtils.inputString();
        if (chuongTrinhHoc.equals("1")){
          return;
        }
        ChuongTrinhHoc chuongTrinhHoc1 = QLChuongTrinhHoc.timKiemTheoMa(chuongTrinhHoc);
        while (chuongTrinhHoc1 == null){
            System.err.println("Chương trình học không tồn tại !!! Nhập lại !!");
            System.out.println("Ấn 1 để thoát");
            chuongTrinhHoc = ScannerUtils.inputString();
            if (chuongTrinhHoc.equals("1")){
              return;
            }
          chuongTrinhHoc1 = QLChuongTrinhHoc.timKiemTheoMa(chuongTrinhHoc);
        }



        System.out.println("Nhập tên lớp: ");
        tenLop = ScannerUtils.inputString();


        LopHoc lopHoc = new LopHoc(tenLop, khoaKhaiGiang, chuongTrinhHoc1);

        QLLopHoc.getDsLopHoc().add(lopHoc);
        System.out.println("Đã thêm lớp");
    }




  public static void sapXepLopHoc(){
    ArrayList<LopHoc> dsLopHoc = QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Cho_Sap_Xep);
    QLLopHoc.inDanhSach(dsLopHoc);
    System.out.println("Bạn chọn lớp nào để sắp xếp ?");
    System.out.println("Ấn 1 để trở về giao diện chính.");
    String choice = ScannerUtils.inputString();
    LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(choice, dsLopHoc);
    if (choice.equals("1")){
      return;
    }

    while (lopHoc == null ){
      System.err.println("Không tìm thấy mã lớp !!!");
      System.out.println("Ấn 1 để trở về giao diện chính.");
      choice = ScannerUtils.inputString();
      if (choice.equals("1")){
        return;
      }
      lopHoc = QLLopHoc.timKiemLopTheoMaLop(choice, dsLopHoc);
    }
      ArrayList<User> dsGiangVien = QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true);
      ArrayList<User> dsTroGiang = QLUser.timUserTheoVaiTro(VaiTro.TroGiang, true);


      ArrayList<CaHoc> dsCaHoc = new ArrayList<>();
      QLCaHoc.inDanhSach(QLCaHoc.getDsCaHoc());
      System.out.println("Hãy chọn ca học thứ 1 mà bạn muốn ?");
      System.out.println("Ấn -1 để thoát !!");
      int choiceCaHoc1 = ScannerUtils.inputInt();
      if (choiceCaHoc1 == -1){
        return;
      }
      while (choiceCaHoc1 < 1 || choiceCaHoc1 > QLCaHoc.getDsCaHoc().size()){
        System.err.println("Ca học không hợp lẹ !! Nhập lại");
        System.out.println("Nhập -1 để thoát !!");
        if (choiceCaHoc1 == -1){
          return;
        }
        choiceCaHoc1 = ScannerUtils.inputInt();
      }

      dsCaHoc.add(QLCaHoc.getDsCaHoc().get(choiceCaHoc1 - 1));


      QLCaHoc.inDanhSach(QLCaHoc.getDsCaHoc());
      System.out.println("Hãy chọn ca học thứ 2 mà bạn muốn ?");
      System.out.println("Ấn -1 để thoát !!");
      int choiceCaHoc2 = ScannerUtils.inputInt();
      if (choiceCaHoc2 == -1){
        return;
      }
      while (choiceCaHoc2 < 1 || choiceCaHoc2 > QLCaHoc.getDsCaHoc().size() || choiceCaHoc2 == choiceCaHoc1){
        if (choiceCaHoc2 < 1 || choiceCaHoc2 > QLCaHoc.getDsCaHoc().size()){
          System.err.println("Ca học không hợp lệ !! Nhập lại");
        }else{
          System.err.println("Bạn không được chọn 2 ca học giống nhau !!");
        }
        System.out.println("Ấn -1 để thoát !!");
        choiceCaHoc2 = ScannerUtils.inputInt();
        if (choiceCaHoc2 == -1){
          return;
        }
      }
      dsCaHoc.add(QLCaHoc.getDsCaHoc().get(choiceCaHoc2 - 1));

      lopHoc.setCaHocMacDinh(dsCaHoc);

      QLUser.inThongTin(dsGiangVien);
      System.out.println("Hãy chọn giảng viên phù hợp.");
      System.out.println("Ấn 1 để trở về giao diện chính.");
      String maGV = ScannerUtils.inputString();
      User giangVien = QLUser.timUserTheoMa(maGV, dsGiangVien);
      if (maGV.equals("1")){
        return;
      }

      while (giangVien == null ||
              giangVien.isThisTeacherBusy(dsCaHoc.get(0)) ||
              giangVien.isThisTeacherBusy(dsCaHoc.get(1)) ){
        if(giangVien == null){
          System.err.println("Mã giảng viên không hợp lẹ !!");
        } else if (giangVien.isThisTeacherBusy(dsCaHoc.get(0))){
          System.err.printf("Giảng viên bị trùng lịch vào %s !!!\n", dsCaHoc.get(0));
        } else  {
          System.err.printf("Giảng viên bị trùng lịch vào %s !!!\n", dsCaHoc.get(1));
        }
        System.out.println("Hãy chọn giảng viên phù hợp.");
        System.out.println("Ấn 1 để trở về giao diện chính.");

        maGV = ScannerUtils.inputString();
        giangVien = QLUser.timUserTheoMa(maGV, dsGiangVien);
        if (maGV.equals("1")){
          return;
        }
      }

      lopHoc.setGiangVien(giangVien);
      System.out.println("Đã thêm giảng viên thành công !!");

      QLUser.inThongTin(dsTroGiang);
      System.out.println("Hãy chọn trợ giảng phù hợp.");

      String maTG = ScannerUtils.inputString();
      User troGiang = QLUser.timUserTheoMa(maTG, dsTroGiang);
      System.out.println("Ấn 1 để trở về giao diện chính.");
      if (maTG.equals("1")){
        return;
      }

      while (troGiang == null ||
              troGiang.isThisTutorBusy(dsCaHoc.get(0)) ||
              troGiang.isThisTutorBusy(dsCaHoc.get(1)) ){
        if(troGiang == null){
          System.err.println("Mã trợ giảng không hợp lệ !!");
        }else if (troGiang.isThisTutorBusy(dsCaHoc.get(0))){
          System.err.printf("Trợ giảng bị trùng lịch vào %s !!!\n", dsCaHoc.get(0));
        } else  {
          System.err.printf("Trợ giảng bị trùng lịch vào %s !!!\n", dsCaHoc.get(1));
        }
        System.out.println("Hãy chọn trợ giảng phù hợp.");
        maTG = ScannerUtils.inputString();
        troGiang = QLUser.timUserTheoMa(maTG, dsTroGiang);
        System.out.println("Ấn 1 để trở về giao diện chính.");
        if (maTG.equals("1")){
            return;
        }
      }

      lopHoc.setTroGiang(troGiang);
      System.out.println("Đã thêm trợ giảng thành công !!");


      QLPhongHoc.inDSPhongHoc(QLPhongHoc.getDsPhongHoc());
      System.out.println("Hãy chọn phòng học phù hợp.");
      String maPhong = ScannerUtils.inputString();
      PhongHoc phongHoc = QLPhongHoc.timKiemTheoMaPhongHoc(maPhong);
      System.out.println("Ấn 1 để trở về giao diện chính.");
      if (maPhong.equals("1")){
        return;
      }

      while (phongHoc == null ||
              phongHoc.isBusy(lopHoc.getCaHocMacDinh().get(0))||
              phongHoc.isBusy(lopHoc.getCaHocMacDinh().get(1)) ||
              !phongHoc.getTrangThai()){
        if (phongHoc == null){
            System.err.println("Phòng học không hợp lệ !!");
        } else if ( phongHoc.isBusy(lopHoc.getCaHocMacDinh().get(0))) {
          System.err.printf("Phòng học này đã có lớp học tại thời điểm %s", lopHoc.getCaHocMacDinh().get(0));
        } else if ( phongHoc.isBusy(lopHoc.getCaHocMacDinh().get(1))) {
          System.err.printf("Phòng học này đã có lớp học tại thời điểm %s", lopHoc.getCaHocMacDinh().get(1));
        }else{
          System.err.println("Phòng học đang bảo trì !! Vui lòng chọn phòng khác");
        }
        System.out.println("Hãy chọn phòng học phù hợp.");
        System.out.println("Ấn 1 để trở về giao diện chính.");

        maPhong = ScannerUtils.inputString();
        phongHoc = QLPhongHoc.timKiemTheoMaPhongHoc(maPhong);
        if (maPhong.equals("1")){
          return;
        }
      }

      lopHoc.setPhongHocMacDinh(phongHoc);
      System.out.println("Đã thêm phòng học thành công !!");

      lopHoc.setTrangThai(TrangThaiLop.Sap_Khai_Giang);
      System.out.println("Đã sắp xếp thành công cho lớp học  !!");

  }

  public static void thayDoiTrangThaiLop(){
    QLLopHoc.inDanhSach(QLLopHoc.getDsLopHoc());

    System.out.println("Nhập mã lớp học mà bạn muốn thấy đổi trạng thái. (Nhập ID)");
    System.out.println("Nhấn 1 để thoát !!");
    String idLop = ScannerUtils.inputString();
    if (idLop.equals("1")){
      return;
    }

    LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(idLop);
    while (lopHoc == null || lopHoc.getTrangThai().equals(TrangThaiLop.Huy) || lopHoc.getTrangThai().equals(TrangThaiLop.Cho_Sap_Xep)){
      if (lopHoc == null ){
        System.err.println("Lớp học không tồn tại !!!");
      }else {
        System.err.println("Bạn không thể thay đổi trạng thaái lớp của lớp đã bị hủy hoặc đang chờ sắp xếp !!");
      }
      System.out.println("Nhập mã lớp học mà bạn muốn thấy đổi trạng thái. (Nhập ID)");
      System.out.println("Nhấn 1 để thoát !!");
      idLop = ScannerUtils.inputString();
      if (idLop.equals("1")){
        return;
      }
      lopHoc = QLLopHoc.timKiemLopTheoMaLop(idLop);
    }

    lopHoc.setTrangThai(TrangThaiLop.nhapTrangThaiLop());
    System.out.println("Thay đổi trạng thái lớp thành công :3");
  }
}
