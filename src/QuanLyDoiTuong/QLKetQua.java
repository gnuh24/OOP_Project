package QuanLyDoiTuong;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import HeThongGiaoDuc.LopHoc.KetQua;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import NguoiDung.User;
import ThoiGian.CaHoc;
import ThoiGian.Thu;
import Utils.Convert;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

public class QLKetQua {
  // data
  private static ArrayList<KetQua> dsKetQua = new ArrayList<KetQua>();

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
      User hocVien = QLUser.timUserTheoMa(maHocVien);
      LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLopHoc);
      double diem = Double.parseDouble(cacThuocTinh[2]);
      String danhGia = cacThuocTinh[3];

      // tạo ra dối tượng và thêm vào dsKetQua
      dsKetQua.add(
          new KetQua(hocVien, lopHoc, diem, danhGia));
    }
  }

  // hàm load dữ liệu từ file
  public static void loadDuLieu() {
    // sửa đường dẫn này:
    String filePath = "src\\Data\\qlKetQua.txt";

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
          .append(ketQua.getHocVien().getMaUser()).append("#")
          .append(ketQua.getLopHoc().getMaLop()).append("#")
          .append(ketQua.getDiem()).append("#")
          .append(ketQua.getDanhGia())
          .append(System.lineSeparator());

      duLieu.add(sb.toString());
    }

    return duLieu;
  }

  // Hàm save dữ liệu vào file
  public static void saveDuLieu() {
    // sửa đường dẫn này:
    String filePath = "src\\Data\\qlKetQua.txt";

    ArrayList<String> duLieu = trichXuatDuLieu();
    DocGhiFile.ghiDuLieuFile(filePath, duLieu);
    System.out.println("Đã lưu xong KetQua");
  }

  // hàm in ra danh sách kết quả
  public static void inDanhSach(ArrayList<KetQua> dsKetQua) {
    System.out.println("*".repeat(114));
    System.out.printf("* %-25s* %-20s* %-10s* %-50s*\n",
        "Tên học viên", "Tên lớp học", "Điểm", "Đánh giá");
    System.out.println("*".repeat(114));

    for (KetQua ketQua : dsKetQua) {
      System.out.printf("* %-25s* %-20s* %-10s* %-50s*\n",
          ketQua.getHocVien().getHoTen(),
          ketQua.getLopHoc().getTenLop(),
          ketQua.getDiem() == -1.0 ? "": ketQua.getDiem(),
          ketQua.getDanhGia());
    }
    System.out.println("*".repeat(114));

  }

  public static ArrayList<KetQua> timKiemTheoHocVien(String maHocVien) {
    ArrayList<KetQua> ketQuaTimKiem = new ArrayList<>();

    for (KetQua ketQua : dsKetQua) {
      if (ketQua.getHocVien().getMaUser().equals(maHocVien)) {
        ketQuaTimKiem.add(ketQua);
      }
    }

    return ketQuaTimKiem;
  }


  public static ArrayList<KetQua> timKiemTheoLopHoc(String malopHoc) {
    ArrayList<KetQua> ketQuaTimKiem = new ArrayList<>();

    for (KetQua ketQua : dsKetQua) {
      if (ketQua.getLopHoc().getMaLop().equals(malopHoc)) {
        ketQuaTimKiem.add(ketQua);
      }
    }

    return ketQuaTimKiem;
  }

  public static int demHocVienTheoLopHoc(String maLop) {
    int dem = 0;
    for (KetQua ketQua : dsKetQua) {
      if (ketQua.getLopHoc().getMaLop().equals(maLop)) {
        dem++;
      }
    }

    return dem;
  }


    public static void thongKeHocVienTheoChuongTrinh(){
        int demHocVien=0;
        System.out.printf("%-18s %-18s\n","Mã chương trình","Số lượng học viên");
        System.out.println("*".repeat(40));
        for(ChuongTrinhHoc chuongTrinhHoc:QLChuongTrinhHoc.getDsChuongTrinhHoc()){
            for(KetQua ketQua:dsKetQua){
                if (ketQua.getLopHoc().getChuongTrinh().getMaChuongTrinh().equals(chuongTrinhHoc.getMaChuongTrinh())) {
                    demHocVien++;
                }
            }

            System.out.printf("%-18s %-18s\n",chuongTrinhHoc.getMaChuongTrinh(), demHocVien);
            demHocVien=0;
        }
    }


  public static void thongKeHocVienTheoThang(){
        int []demHocVien=new int[13];
        for(int i=0; i<demHocVien.length; i++){
            demHocVien[i]=0;
        }
        System.out.println("Nhập năm muốn kiểm tra: ");
        int nam = ScannerUtils.inputInt();
        for(KetQua ketQua:QLKetQua.getDsKetQua()){
            if(ketQua.getLopHoc().getKhoa().getNgayKetThuc().getYear()==nam){
                demHocVien[0]++;
                demHocVien[ketQua.getLopHoc().getKhoa().getNgayKetThuc().getMonthValue()]++;
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
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Mã khóa","Ngày bắt đầu","Ngày kết thúc","Số lượng học viên");
        System.out.println("*".repeat(40));
        for(KhoaKhaiGiang khoaKhaiGiang:QLKhoaKhaiGiang.getDsKhoaKhaiGiang()){
            for (KetQua ketQua:dsKetQua) {
                if (ketQua.getLopHoc().getKhoa().getMaKhoa().equals(khoaKhaiGiang.getMaKhoa())) {
                    demHocVien++;
                }
            }
            System.out.printf("%-10s %-10s %-10s %-10s\n",khoaKhaiGiang.getMaKhoa(),khoaKhaiGiang.getNgayBatDau(),khoaKhaiGiang.getNgayKetThuc(), demHocVien);
            demHocVien=0;
        }
        System.out.println("*".repeat(40));

    }


    public static void thongKeTheoNam(){
      QLKetQua.dsKetQua.sort(new Comparator<KetQua>(){
        @Override
        public int compare(KetQua o1, KetQua o2) {
          return o1.getLopHoc().getKhoa().getNgayKetThuc().compareTo(o2.getLopHoc().getKhoa().getNgayKetThuc());
        }

      });
      int demHocVien=0, nam=getDsKetQua().get(0).getLopHoc().getKhoa().getNgayKetThuc().getYear();
      System.out.printf("%-20s -20s\n","Năm","Số học viên");
      System.out.println("*".repeat(40));
      for (KetQua ketQua : dsKetQua) {
        if(ketQua.getLopHoc().getKhoa().getNgayKetThuc().getYear()==nam){
            demHocVien++;
        }
        else{
          System.out.printf("%-20s %-20s", ketQua.getLopHoc().getKhoa().getNgayKetThuc().getYear(), demHocVien);
          demHocVien=0;
          nam=ketQua.getLopHoc().getKhoa().getNgayKetThuc().getYear();
        }
      }
      System.out.println("*".repeat(40));
    }

    public static void xemTKBCacLopDangHoc(User user) {
        ArrayList<LopHoc> lopHocs = new ArrayList<>();
        for (KetQua ketQua :dsKetQua) {
            if (ketQua.getHocVien().getMaUser().equals(user.getMaUser())) {
                if(ketQua.getLopHoc().getTrangThai().equals(TrangThaiLop.Dang_Hoc)){
                    lopHocs.add(ketQua.getLopHoc());
                }
            }
        }
        QLLopHoc.inDanhSach(lopHocs);
    }

    public static void xemTKBCacLopSapKhaiGiang(User user) {
        ArrayList<LopHoc> lopHocs = new ArrayList<>();
        for (KetQua ketQua :dsKetQua) {
            if (ketQua.getHocVien().getMaUser().equals(user.getMaUser())) {
                if(ketQua.getLopHoc().getTrangThai().equals(TrangThaiLop.Sap_Khai_Giang)){
                    lopHocs.add(ketQua.getLopHoc());
                }
            }
        }
        QLLopHoc.inDanhSach(lopHocs);
    }




//   public static void main(String[] args) {

//     loadDuLieu();
//     inDanhSach(dsKetQua);
//   }
// }
}
