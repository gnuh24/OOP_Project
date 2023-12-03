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
    System.out.println("*".repeat(123));
    System.out.printf("%-25s* %-10s* %-10s* %-50s*\n",
        "Tên học viên", "Tên lớp học", "Điểm", "Đánh giá");
    System.out.println("*".repeat(123));

    for (KetQua ketQua : dsKetQua) {
      System.out.printf("%-25s* %-10s* %-10s* %-50s*\n",
          ketQua.getHocVien().getHoTen(),
          ketQua.getLopHoc().getTenLop(),
          ketQua.getDiem(),
          ketQua.getDanhGia());
      System.out.println("*".repeat(123));
    }
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
                switch (ketQua.getLopHoc().getKhoa().getNgayKetThuc().getMonthValue()) {
                    case 1: demHocVien[1]++; break;
                    case 2: demHocVien[2]++; break;
                    case 3: demHocVien[3]++; break;
                    case 4: demHocVien[4]++; break;
                    case 5: demHocVien[5]++; break;
                    case 6: demHocVien[6]++; break;
                    case 7: demHocVien[7]++; break;
                    case 8: demHocVien[8]++; break;
                    case 9: demHocVien[9]++; break;
                    case 10: demHocVien[10]++; break;
                    case 11: demHocVien[11]++; break;
                    case 12: demHocVien[12]++; break;
                }
            }
        }

        System.out.println("Số học viên năm "+nam+" "+demHocVien[0]);
        System.out.println("----------------------------------------------------------------------------------------");
        for(int i=1; i<demHocVien.length; i++){
            System.out.printf("%-10s","Tháng"+i+"|"+demHocVien[i]+"| ");
            for(int j=0; j<demHocVien[i]; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void thongKeHocVienTheoKhoa(){
      int demHocVien=0;
      QLKhoaKhaiGiang.inDanhSachKhoaKhaiGiang(QLKhoaKhaiGiang.getDsKhoaKhaiGiang());
      System.out.println("Nhập mã Khóa");
      String maKhoa = ScannerUtils.inputString();
      for(KetQua ketQua:QLKetQua.getDsKetQua()){
          if(ketQua.getLopHoc().getKhoa().getMaKhoa().equals(maKhoa)){
              demHocVien++;
          }
      }
      System.out.println("Số học viên của khóa: "+demHocVien);
    }


    public static void thongKeTheoNam(){
      QLKetQua.dsKetQua.sort(new Comparator<KetQua>(){
        @Override
        public int compare(KetQua o1, KetQua o2) {
          return o1.getLopHoc().getKhoa().getNgayKetThuc().compareTo(o2.getLopHoc().getKhoa().getNgayKetThuc());
        }

      });
      int demHocVien=0, nam=getDsKetQua().get(0).getLopHoc().getKhoa().getNgayKetThuc().getYear();
      for (KetQua ketQua : dsKetQua) {
        if(ketQua.getLopHoc().getKhoa().getNgayKetThuc().getYear()==nam){
            demHocVien++;
        }
        else{
          System.out.println("Năm: "+nam+" | Học viên: "+demHocVien);
          demHocVien=0;
          nam=ketQua.getLopHoc().getKhoa().getNgayKetThuc().getYear();
        }
      }
    }




//   public static void main(String[] args) {

//     loadDuLieu();
//     inDanhSach(dsKetQua);
//   }
// }
}
