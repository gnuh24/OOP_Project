package QuanLyDoiTuong;

import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import NguoiDung.CaNhan;
import NguoiDung.GiangVien;
import NguoiDung.KhachHang;
import ThoiGian.Gio;
import ThoiGian.NgayThang;
import Utils.DocGhiFile;

import java.util.ArrayList;

public class QLKhachHang extends CaNhan {
    private static ArrayList<KhachHang> dsKhachHang = new ArrayList<>();

    public static ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public static void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        QLKhachHang.dsKhachHang = dsKhachHang;
    }

//    public static void loadDuLieu(){
//        ArrayList<String> duLieu= DocGhiFile.docDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlLichPhongVan.txt");
//        xuLyDuLieu(duLieu);
//    }
//
//    public static void xuLyDuLieu(ArrayList<String> duLieu) {
//        // duyệt qua duLieu và bắt đầu xử lý!
//        for (String dong : duLieu) {
//            // tách chuỗi tam
//            String[] cacThuocTinh = dong.split("#");
//
//
//
//            String maCa = cacThuocTinh[0];
//
//            String maGiangVien = cacThuocTinh[1];
//            GiangVien giangVien = ;
//
//            int ngay = Integer.parseInt(cacThuocTinh[2]);
//            int thang = Integer.parseInt(cacThuocTinh[3]);
//            int nam = Integer.parseInt(cacThuocTinh[4]);
//            NgayThang ngayThang = new NgayThang(ngay, thang, nam);
//
//            int gio =  Integer.parseInt(cacThuocTinh[5]);
//            int phut =  Integer.parseInt(cacThuocTinh[6]);
//            Gio thoiGian = new Gio(gio, phut);
//
//            String maKhach = cacThuocTinh[7];
//            KhachHang khachHang = ;
//
//            TrangThaiPhongVan trangThai = null;
//            switch (cacThuocTinh[8]){
//                case "1":
//                    trangThai = TrangThaiPhongVan.CHO_DUYET;
//                    break;
//                case "2":
//                    trangThai = TrangThaiPhongVan.CHO_PHONGVAN;
//                    break;
//                case "3":
//                    trangThai = TrangThaiPhongVan.DA_PHONGVAN;
//                    break;
//                case "4":
//                    trangThai = TrangThaiPhongVan.HUY;
//                    break;
//            }
//
//            LichPhongVan lichPhongVan = new LichPhongVan(maCa, giangVien, ngayThang, thoiGian, khachHang, trangThai);
//            QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);
//
//        }
//    }

//    public static void luuDuLieu() {
//        ArrayList<String> duLieu = xuLyDuLieuDeLuu();
//        if(DocGhiFile.ghiDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlPhongHoc.txt",duLieu)){
//            System.out.println("Da luu du lieu");
//        }
//    }
//    public static ArrayList<String> xuLyDuLieuDeLuu() {
//        // duyệt qua duLieu và bắt đầu xử lý!
//        ArrayList<String> duLieu=new ArrayList<String>();
//        for (PhongHoc phongHoc:dsPhongHoc) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(phongHoc.getMaPhongHoc());sb.append("#");
//            sb.append(phongHoc.getTrangThai());sb.append("#");
//            sb.append(phongHoc.getCoSoTrucThuoc().getMaCoSo());sb.append(System.lineSeparator());
//            duLieu.add(sb.toString());
//        }
//        return duLieu;
//    }
}
