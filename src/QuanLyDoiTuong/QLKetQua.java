package QuanLyDoiTuong;

import java.time.LocalTime;
import java.util.ArrayList;
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


  public void thongKeHocVienTheoChuongTrinh(){
    int []demSoHocVienCTH=new int[17];
    for(int i=0; i<demSoHocVienCTH.length;i++){
        demSoHocVienCTH[i]=0;
    }
    for(KetQua ketQua:QLKetQua.getDsKetQua()){
        switch (ketQua.getLopHoc().getChuongTrinh().getMaChuongTrinh()) {
            case "CTH001":  demSoHocVienCTH[0]++; break;
            case "CTH002":  demSoHocVienCTH[1]++; break;
            case "CTH003":  demSoHocVienCTH[2]++; break;
            case "CTH004":  demSoHocVienCTH[3]++; break;
            case "CTH005":  demSoHocVienCTH[4]++; break;
            case "CTH006":  demSoHocVienCTH[5]++; break;
            case "CTH007":  demSoHocVienCTH[6]++; break;
            case "CTH008":  demSoHocVienCTH[7]++; break;
            case "CTH009":  demSoHocVienCTH[8]++; break;
            case "CTH010":  demSoHocVienCTH[9]++; break;
            case "CTH011": demSoHocVienCTH[10]++; break;
            case "CTH012": demSoHocVienCTH[11]++; break;
            case "CTH013": demSoHocVienCTH[12]++; break;
            case "CTH014": demSoHocVienCTH[13]++; break;
            case "CTH015": demSoHocVienCTH[14]++; break;
            case "CTH016": demSoHocVienCTH[15]++; break;
            case "CTH017": demSoHocVienCTH[16]++; break;
        }
    }
    int min=demSoHocVienCTH[0];
    for(int i=1; i<demSoHocVienCTH.length;i++){
        if(min>demSoHocVienCTH[i])
            min=demSoHocVienCTH[i];
    }
    if(min==0) min=1;
    System.out.println("----------------------------------------------------------------------------------------");
    for(int i=0; i<demSoHocVienCTH.length; i++){
        System.out.printf("%-10s","CTH"+i+"|"+demSoHocVienCTH[i]+"| ");
        for(int j=0; j<(demSoHocVienCTH[i]/min); j++){
            System.out.print("*");
        }
        System.out.println("");
    }
    System.out.println("----------------------------------------------------------------------------------------");
}


  public void thongKeHocVienTheoNam(){
        int []demHocVien=new int[13];
        for(int i=0; i<demHocVien.length; i++){
            demHocVien[i]=0;
        }
        System.out.println("Nhập năm muốn kiểm tra: ");
        int nam = ScannerUtils.inputInt();
        for(KetQua ketQua:QLKetQua.getDsKetQua()){
            if(ketQua.getLopHoc().getKhoa().getNgayBatDau().getYear()==nam){
                demHocVien[0]++;
                switch (ketQua.getLopHoc().getKhoa().getNgayBatDau().getMonthValue()) {
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

    public void thongKeHocVienTheoKhoa(){
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

  public static void main(String[] args) {

    loadDuLieu();
    inDanhSach(dsKetQua);
  }
}
