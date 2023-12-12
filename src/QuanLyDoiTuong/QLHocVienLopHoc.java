package QuanLyDoiTuong;

import java.util.ArrayList;
import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import Menu.Session;
import NguoiDung.User;
import NguoiDung.VaiTro;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

public class QLHocVienLopHoc {
  // data
  private static ArrayList<HocVienLopHoc> dsHocVienLopHoc = new ArrayList<HocVienLopHoc>();

  // getter
  public static ArrayList<HocVienLopHoc> getDsKetQua() {
    return dsHocVienLopHoc;
  }

  // setter
  public static void setDsKetQua(ArrayList<HocVienLopHoc> dsHocVienLopHoc) {
    QLHocVienLopHoc.dsHocVienLopHoc = dsHocVienLopHoc;
  }

  // hàm xử lý dữ liệu từ chuỗi thành đối tượng
  // CẤU TRÚC MỘT DÒNG DỮ LIỆU TRONG FILE:
  // "(MÃ USER)#(MÃ LỚP HỌC)#(ĐIỂM)#(ĐÁNH GIÁ)"
  public static void xuLyDuLieu(ArrayList<String> duLieu) {
    // duyệt qua duLieu và bắt đầu xử lý!
    for (String temp : duLieu) {
      // tách chuỗi tam
      String[] cacThuocTinh = temp.split("#");

      // thiết lập các thuộc tính cho đối tượng HocVienLopHoc
      String maHocVien = cacThuocTinh[0];
      String maLopHoc = cacThuocTinh[1];
      User hocVien = QLUser.timUserTheoMa(maHocVien);
      LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLopHoc);
      double diem = Double.parseDouble(cacThuocTinh[2]);
      String danhGia = cacThuocTinh[3];

      // tạo ra dối tượng và thêm vào dsHocVienLopHoc
      dsHocVienLopHoc.add(
          new HocVienLopHoc(hocVien, lopHoc, diem, danhGia));
    }
  }

  // hàm load dữ liệu từ file
  public static void loadDuLieu() {
    // sửa đường dẫn này:
    String filePath = "src\\Data\\qlHocVienLopHoc.txt";

    ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
    xuLyDuLieu(duLieu);
    System.out.println("Đã tải xong HocVienLopHoc");
  }

  // xử lý dữ liệu từ đối tượng thành chuỗi để lưu
  public static ArrayList<String> trichXuatDuLieu() {
    ArrayList<String> duLieu = new ArrayList<>();

    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      StringBuilder sb = new StringBuilder();
      sb
          .append(hocVienLopHoc.getHocVien().getMaUser()).append("#")
          .append(hocVienLopHoc.getLopHoc().getMaLop()).append("#")
          .append(hocVienLopHoc.getDiem()).append("#")
          .append(hocVienLopHoc.getDanhGia())
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
    System.out.println("Đã lưu xong HocVienLopHoc");
  }

  // hàm in ra danh sách kết quả
  public static void inDanhSach(ArrayList<HocVienLopHoc> dsHocVienLopHoc) {
      System.out.println("*".repeat(148));
    System.out.printf("* %-10s* %-25s* %-20s* %-10s* %-50s* %-20s*\n",
        "STT", "Tên học viên", "Tên lớp học", "Điểm", "Đánh giá","Trạng thái");
      System.out.println("*".repeat(148));
    int index = 1;
    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      System.out.printf("* %-10s* %-25s* %-20s* %-10s* %-50s* %-20s*\n",
          index++,
          hocVienLopHoc.getHocVien().getHoTen(),
          hocVienLopHoc.getLopHoc().getTenLop(),
          hocVienLopHoc.getDiem() == -1.0 ? "": hocVienLopHoc.getDiem(),
          hocVienLopHoc.getDanhGia(),
          TrangThaiLop.toString(hocVienLopHoc.getLopHoc().getTrangThai())   );
    }
      System.out.println("*".repeat(148));

  }

  public static ArrayList<HocVienLopHoc> timKiemTheoHocVien(String maHocVien) {
    ArrayList<HocVienLopHoc> hocVienLopHocTimKiem = new ArrayList<>();

    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      if (hocVienLopHoc.getHocVien().getMaUser().equals(maHocVien)) {
        hocVienLopHocTimKiem.add(hocVienLopHoc);
      }
    }

    return hocVienLopHocTimKiem;
  }


  public static ArrayList<HocVienLopHoc> timKiemTheoLopHoc(String malopHoc) {
    ArrayList<HocVienLopHoc> hocVienLopHocTimKiem = new ArrayList<>();

    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      if (hocVienLopHoc.getLopHoc().getMaLop().equals(malopHoc)) {
        hocVienLopHocTimKiem.add(hocVienLopHoc);
      }
    }

    return hocVienLopHocTimKiem;
  }

  public static int demHocVienTheoLopHoc(String maLop) {
    int dem = 0;
    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      if (hocVienLopHoc.getLopHoc().getMaLop().equals(maLop)) {
        dem++;
      }
    }

    return dem;
  }


    public static void thongKeHocVienTheoChuongTrinh(){
        int demHocVien=0;
        System.out.println("*".repeat(43));

        System.out.printf("*  %-18s*  %-18s*\n","Mã chương trình","Số lượng học viên");
        System.out.println("*".repeat(43));
        for(ChuongTrinhHoc chuongTrinhHoc:QLChuongTrinhHoc.getDsChuongTrinhHoc()){
            for(HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc){
                if (hocVienLopHoc.getLopHoc().getChuongTrinh().getMaChuongTrinh().equals(chuongTrinhHoc.getMaChuongTrinh())) {
                    demHocVien++;
                }
            }

            System.out.printf("*  %-18s*  %-18s*\n",chuongTrinhHoc.getMaChuongTrinh(), demHocVien);
            demHocVien=0;
        }
        System.out.println("*".repeat(43));

    }

    public static void thongKeHocVienTheoKhoa(){
        int demHocVien = 0;
        System.out.println("*".repeat(83));

        System.out.printf("*  %-10s*  %-20s*  %-20s*  %-20s*\n", "Mã khóa","Ngày bắt đầu","Ngày kết thúc","Số lượng học viên");
        System.out.println("*".repeat(83));
        for(KhoaKhaiGiang khoaKhaiGiang:QLKhoaKhaiGiang.getDsKhoaKhaiGiang()){
            for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
                if (hocVienLopHoc.getLopHoc().getKhoa().getMaKhoa().equals(khoaKhaiGiang.getMaKhoa())) {
                    demHocVien++;
                }
            }
            System.out.printf("*  %-10s*  %-20s*  %-20s*  %-20s*\n",khoaKhaiGiang.getMaKhoa(),khoaKhaiGiang.getNgayBatDau(),khoaKhaiGiang.getNgayKetThuc(), demHocVien);
            demHocVien=0;
        }
        System.out.println("*".repeat(83));
    }



    public static void xemTKBCacLopDangHoc(User user) {
        ArrayList<LopHoc> lopHocs = new ArrayList<>();
        for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
            if (hocVienLopHoc.getHocVien().getMaUser().equals(user.getMaUser())) {
                if(hocVienLopHoc.getLopHoc().getTrangThai().equals(TrangThaiLop.Dang_Hoc)){
                    lopHocs.add(hocVienLopHoc.getLopHoc());
                }
            }
        }
        QLLopHoc.inDanhSach(lopHocs);
    }

    public static void xemTKBCacLopSapKhaiGiang(User user) {
        ArrayList<LopHoc> lopHocs = new ArrayList<>();
        for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
            if (hocVienLopHoc.getHocVien().getMaUser().equals(user.getMaUser())) {
                if(hocVienLopHoc.getLopHoc().getTrangThai().equals(TrangThaiLop.Sap_Khai_Giang)){
                    lopHocs.add(hocVienLopHoc.getLopHoc());
                }
            }
        }
        QLLopHoc.inDanhSach(lopHocs);
    }


    public static void chuyenLop(){
        /*
         * Quy tắc chuyên lớp
         * - Tìm học viên và in ra danh sách HọcVienLopHoc của học viên đó (Bao gồm lớp và học viên)
         * - Tìm danh sách các lớp có cùng chương trình
         * - Thay đổi kết quả cũ thành lớp mới đã được chọn
         * - Thay đổi lớp học trong đơn đăng ký thành lớp mới
         * */
        ArrayList<User> dsHocVien = QLUser.timUserTheoVaiTro(VaiTro.HocVien, true);

        QLUser.inThongTin(dsHocVien);
        //Tìm học sinh muốn chuyển lớp
        System.out.println("Hãy nhập mã học sinh muốn chuyển lớp !!");
        String maHV = ScannerUtils.inputString();
        ArrayList<HocVienLopHoc>  dsHocVienLopHoc = QLHocVienLopHoc.timKiemTheoHocVien(maHV);
        while (dsHocVienLopHoc.isEmpty()){
            System.err.println("Học viên này chưa tham gia bất cứ lớp nào !!");
            System.out.println("Bạn có nhập nhầm hong ? Nhập lại nhé ^^");
            System.out.println("Ấn 1 để thoát");
            maHV = ScannerUtils.inputString();
            if (maHV.equals("1")){
                return;
            }
            dsHocVienLopHoc = QLHocVienLopHoc.timKiemTheoHocVien(maHV);
        }


        //In danh sách các lớp học viên đó đang học
        QLHocVienLopHoc.inDanhSach(dsHocVienLopHoc);
        System.out.println("Hãy chọn lớp mà bạn muốn đổi theo thứ tự !!");
        System.out.println("Hãy ấn 0 để thoát !!");
        int sttLopCu = ScannerUtils.inputInt();
        if (sttLopCu == 0){
            return;
        }

        while (sttLopCu < 1 || sttLopCu > dsHocVienLopHoc.size()){
            System.err.println("Số thứ tự không hợp lệ !!");
            System.out.println("Hãy ấn 0 để thoát !!");
            sttLopCu = ScannerUtils.inputInt();
            if (sttLopCu == 0){
                return;
            }
        }
        LopHoc lopHocCu = dsHocVienLopHoc.get(sttLopCu - 1).getLopHoc();
        //Tìm các lớp học cùng trình độ ở trạng thái đang học
        ArrayList<LopHoc> dsLopHocMoiCungTrinhDo = QLLopHoc.timKiemLopTheoChuongTrinh(lopHocCu.getChuongTrinh().getMaChuongTrinh());
        ArrayList<LopHoc> dsLopHocMoiPhuHop = QLLopHoc.timKiemLopTheoTrangThai(dsLopHocMoiCungTrinhDo, TrangThaiLop.Dang_Hoc, TrangThaiLop.Sap_Khai_Giang);

        QLLopHoc.inDanhSach(dsLopHocMoiPhuHop);

        if (dsLopHocMoiPhuHop.isEmpty()){
            System.err.println("Rất tiếc. Không có lớp học cùng trình độ nào phù hợp !!");
            System.out.println("Hãy trở lại sau.");
            return;
        }

        System.out.println("Hãy chọn lớp học cùng trình độ mà bạn muốn đổi sang !!");
        System.out.println("Ấn 1 để thoát");
        String maLopMoi = ScannerUtils.inputString();
        if (maLopMoi.equals("1")){
            return;
        }
        LopHoc lopHocMoi = QLLopHoc.timKiemLopTheoMaLop(maLopMoi, dsLopHocMoiPhuHop);
        while (lopHocMoi == null || lopHocMoi.getMaLop().equals(lopHocCu.getMaLop())){
                if (lopHocMoi == null){
                        System.err.println("Mã lớp mới không hợp lệ !!!");

                }else{
                        System.err.println("Bạn không thể chuyển từ lớp học cũ sang lớp học cũ được !!");

                }
            System.out.println("Hãy chọn lớp học cùng trình độ mà bạn muốn đổi sang !!");
            System.out.println("Ấn 1 để thoát");
            maLopMoi = ScannerUtils.inputString();
            lopHocMoi = QLLopHoc.timKiemLopTheoMaLop(maLopMoi, dsLopHocMoiPhuHop);
            if (maLopMoi.equals("1")){
                return;
            }
        }

        //Thay kết quả cũ thành kết quả mới
        dsHocVienLopHoc.get(sttLopCu - 1).setLopHoc(lopHocMoi);
        //Thay đơn đăng ký lớp cu thành đơn đăng ký lớp mới
        QLYeuCauDangKy.timKiemChinhXacTheoHocVienVaLopHoc(maHV, lopHocCu.getMaLop()).setLopHoc(lopHocMoi);
        System.out.println("Chuyển lớp thành công !!!");
    }
    public static void nhapDiemChoHocVienLopHoc() {
        ArrayList<LopHoc> dsLopHoc = QLLopHoc.timKiemLopTheoGiangVien(Session.getTaiKhoan().getUser().getMaUser(), true );
        QLLopHoc.inDanhSach(dsLopHoc);
        System.out.println("Chọn lớp: ");
        System.out.println("Ấn 1 để thoát !!");
        String maLop = ScannerUtils.inputString();
        if (maLop.equals("1")){
            return;
        }
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLop, dsLopHoc);
        while (lopHoc == null || !lopHoc.getTrangThai().equals(TrangThaiLop.Da_Ket_Thuc)){
                if (lopHoc == null){
                        System.err.println("Mã lớp không hợp lệ !!! Nhập lại");
                }else{
                        System.err.println("Bạn chỉ có thể nhập điểm cho lớp học đã kết thúc !!");
                }
            System.out.println("Ấn 1 để thoát !!");
            maLop = ScannerUtils.inputString();
            if (maLop.equals("1")){
                return;
            }
            lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLop, dsLopHoc);
        }
        ArrayList<HocVienLopHoc> dsHocVienLopHoc = QLHocVienLopHoc.timKiemTheoLopHoc(maLop);
        QLHocVienLopHoc.inDanhSach(dsHocVienLopHoc);
        System.out.println("Bạn muốn nhập điểm cho học viên nào?:");
        System.out.println("Nhập -1 để thoát.");
        int id = ScannerUtils.inputInt();
        // thoát
        if (id == -1) {
            return;
        }

        while (id < 1 || id > dsHocVienLopHoc.size()){
            System.err.println("Lỗi không tìm thấy học viên!!! Nhập lại");
            System.out.println("Ấn -1 để thoát");
            id = ScannerUtils.inputInt();
            if (id == -1){
                return;
            }
        }

        HocVienLopHoc hocVienLopHoc = dsHocVienLopHoc.get(id - 1);

        String tenHocVien = hocVienLopHoc.getHocVien().getHoTen();
        String tenLop = hocVienLopHoc.getLopHoc().getTenLop();

        System.out.println("Nhập điểm cho " + tenHocVien + " tại lớp " + tenLop + " (ví dụ: 9.8)");
        System.out.println("Ấn 3.69 để thoát");

        double diem = ScannerUtils.inputDiem();

        if (diem==3.69) {
            return;
        }
        hocVienLopHoc.setDiem(diem);

        System.out.println("Nhập đánh giá về học viên này !!");
        hocVienLopHoc.setDanhGia(ScannerUtils.inputString());
        System.out.println("Nhập điểm thành công");

    }

    public static void xoaHocVienLopHoc(YeuCauDangKy yeuCauDangKy){
        for (HocVienLopHoc hocVienLopHoc: QLHocVienLopHoc.getDsKetQua()){
            if (hocVienLopHoc.getHocVien().getMaUser().equals(yeuCauDangKy.getHocVien().getMaUser()) &&
                hocVienLopHoc.getLopHoc().getMaLop().equals(yeuCauDangKy.getLopHoc().getMaLop())){
                QLHocVienLopHoc.getDsKetQua().remove(hocVienLopHoc);
                break;
            }
        }
    }

}
