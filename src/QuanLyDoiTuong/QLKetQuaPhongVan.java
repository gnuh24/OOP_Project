package QuanLyDoiTuong;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.LienHe;
import Utils.DocGhiFile;

import java.util.ArrayList;

public class QLKetQuaPhongVan {
    private static ArrayList<KetQuaPhongVan> dsKetQuaPhongVan = new ArrayList<>();

    public static ArrayList<KetQuaPhongVan> getDsKetQuaPhongVan() {
        return dsKetQuaPhongVan;
    }

    public static void setDsKetQuaPhongVan(ArrayList<KetQuaPhongVan> dsKetQuaPhongVan) {
        QLKetQuaPhongVan.dsKetQuaPhongVan = dsKetQuaPhongVan;
    }

    public static void inDSKetQuaPhongVan(ArrayList<KetQuaPhongVan> dsKetQuaPhongVan){
        System.out.println("*".repeat(100));
        System.out.printf("* %-20s* %-20s* %-20s* %-20s*", "Mã ca phổng vấn", "Điểm phổng vấn", "Chương Trình Phù Hợp", "Trạng thái");
        System.out.println("*".repeat(100));
        for (KetQuaPhongVan ketQuaPhongVan: dsKetQuaPhongVan){
            String lienHe;
            if(ketQuaPhongVan.getLienHe().equals(LienHe.ChuaLienHe)){
                lienHe = "Chưa liên hệ";
            } else if(ketQuaPhongVan.getLienHe().equals(LienHe.DaLienHe)){
                lienHe = "Đã liên hệ";
            } else lienHe = "Đã từ chối";

            System.out.printf("* %-20s* %-20s* %-20s* %-20s*", ketQuaPhongVan.getLichPhongVan().getMaCaPhongVan(), ketQuaPhongVan.getDiem(), ketQuaPhongVan.getChuongTrinhHocDeXuat().getKhoaHoc(), lienHe);
        }

    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String tam : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = tam.split("#");

            LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(cacThuocTinh[0]);
            float diem = Float.parseFloat(cacThuocTinh[1]);

            ChuongTrinhHoc chuongTrinhHoc = QLChuongTrinhHoc.timKiemTheoMa(cacThuocTinh[2]);

            LienHe lienHe = null;
            if(cacThuocTinh[3].equals("1")){
                lienHe = LienHe.ChuaLienHe;
            } else if(cacThuocTinh[3].equals("2")){
                lienHe = LienHe.DaTuChoi;
            } else if (cacThuocTinh[3].equals("3")) {
                lienHe = LienHe.DaLienHe;
            }

            // tạo ra dối tượng và thêm vào dsKhachHang
            QLKetQuaPhongVan.getDsKetQuaPhongVan().add(new KetQuaPhongVan(lichPhongVan, diem, chuongTrinhHoc, lienHe) );
        }
    }

    public static ArrayList<String> trichXuatDuLieu() {
        ArrayList<String> duLieu = new ArrayList<>();

        for (KetQuaPhongVan ketQuaPhongVan : QLKetQuaPhongVan.getDsKetQuaPhongVan()){

            String lienHe = null;
            if(ketQuaPhongVan.getLienHe().equals(LienHe.ChuaLienHe)){
                lienHe = "1";
            }  if(ketQuaPhongVan.getLienHe().equals(LienHe.DaTuChoi)){
                lienHe = "2";
            }  if(ketQuaPhongVan.getLienHe().equals(LienHe.DaLienHe)){
                lienHe = "3";
            }

            StringBuilder tam = new StringBuilder();
            tam.append(ketQuaPhongVan.getLichPhongVan().getMaCaPhongVan())
                    .append(ketQuaPhongVan.getDiem())
                    .append(ketQuaPhongVan.getChuongTrinhHocDeXuat().getMaChuongTrinh())
                    .append(lienHe)
                    .append(System.lineSeparator());

            duLieu.add(tam.toString());
        }

        return duLieu;
    }

    // Hàm load dữ liệu từ file
    public static void loadDuLieu() {
        String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlKetQuaPhongVan.txt";
        ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong KẾT QUẢ PHỔNG VẤN");

    }

    // Hàm save dữ liệu vào file
    public static void saveDuLieu() {
        String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlKetQuaPhongVan.txt";
        ArrayList<String> duLieu = trichXuatDuLieu();
        DocGhiFile.ghiDuLieuFile(filePath, duLieu);
        System.out.println("Đã lưu xong KẾT QUẢ PHỔNG VẤN");

    }
}
