package QuanLyDoiTuong;

import java.util.ArrayList;
import java.util.Comparator;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import NguoiDung.User;
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
    System.out.println("*".repeat(114));
    System.out.printf("* %-10s* %-25s* %-20s* %-10s* %-50s*\n",
        "STT", "Tên học viên", "Tên lớp học", "Điểm", "Đánh giá");
    System.out.println("*".repeat(114));
    int index = 1;
    for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
      System.out.printf("* %-10s* %-25s* %-20s* %-10s* %-50s*\n",
          index++,
          hocVienLopHoc.getHocVien().getHoTen(),
          hocVienLopHoc.getLopHoc().getTenLop(),
          hocVienLopHoc.getDiem() == -1.0 ? "": hocVienLopHoc.getDiem(),
          hocVienLopHoc.getDanhGia());
    }
    System.out.println("*".repeat(114));

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


  public static void thongKeHocVienTheoThang(){
        int []demHocVien=new int[13];
        for(int i=0; i<demHocVien.length; i++){
            demHocVien[i]=0;
        }
        System.out.println("Nhập năm muốn kiểm tra: ");
        int nam = ScannerUtils.inputInt();
        for(HocVienLopHoc hocVienLopHoc : QLHocVienLopHoc.getDsKetQua()){
            if(hocVienLopHoc.getLopHoc().getKhoa().getNgayKetThuc().getYear()==nam){
                demHocVien[0]++;
                demHocVien[hocVienLopHoc.getLopHoc().getKhoa().getNgayKetThuc().getMonthValue()]++;
            }
        }

        System.out.println("Tổng số học viên: "+demHocVien[0]);
        System.out.printf("%-20s %-20s\n","Tháng","Số học viên");
        System.out.println("*".repeat(40));
        for(int i=1; i<demHocVien.length; i++){
            System.out.printf("%-20s %-20s\n",i,demHocVien[i]);
        }
        System.out.println("*".repeat(40));
    }

    public static void thongKeHocVienTheoKhoa(){
        int demHocVien = 0;
        System.out.println("*".repeat(83));

        System.out.printf("*  %-10s*  %-20s*  %-20s*  %-20s*\n", "Mã khóa","Ngày bắt đầu","Ngày kết thúc","Số lượng học viên");
        System.out.println("*".repeat(90));
        for(KhoaKhaiGiang khoaKhaiGiang:QLKhoaKhaiGiang.getDsKhoaKhaiGiang()){
            for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
                if (hocVienLopHoc.getLopHoc().getKhoa().getMaKhoa().equals(khoaKhaiGiang.getMaKhoa())) {
                    demHocVien++;
                }
            }
            System.out.printf("*  %-10s*  %-20s*  %-20s*  %-20s*\n",khoaKhaiGiang.getMaKhoa(),khoaKhaiGiang.getNgayBatDau(),khoaKhaiGiang.getNgayKetThuc(), demHocVien);
            demHocVien=0;
        }
        System.out.println("*".repeat(90));

    }


    public static void thongKeTheoNam(){
      QLHocVienLopHoc.dsHocVienLopHoc.sort(new Comparator<HocVienLopHoc>(){
        @Override
        public int compare(HocVienLopHoc o1, HocVienLopHoc o2) {
          return o1.getLopHoc().getKhoa().getNgayBatDau().compareTo(o2.getLopHoc().getKhoa().getNgayKetThuc());
        }

      });
      int demHocVien=0, nam=getDsKetQua().get(0).getLopHoc().getKhoa().getNgayKetThuc().getYear();
      System.out.printf("%-20s -20s\n","Năm","Số học viên");
      System.out.println("*".repeat(40));
      for (HocVienLopHoc hocVienLopHoc : dsHocVienLopHoc) {
        if(hocVienLopHoc.getLopHoc().getKhoa().getNgayKetThuc().getYear()==nam){
            demHocVien++;
        }
        else{
          System.out.printf("%-20s %-20s", hocVienLopHoc.getLopHoc().getKhoa().getNgayKetThuc().getYear(), demHocVien);
          demHocVien=0;
          nam= hocVienLopHoc.getLopHoc().getKhoa().getNgayKetThuc().getYear();
        }
      }
      System.out.println("*".repeat(40));
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




//   public static void main(String[] args) {

//     loadDuLieu();
//     inDanhSach(dsHocVienLopHoc);
//   }
// }
}
