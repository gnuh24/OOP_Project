package QuanLyDoiTuong;

import HeThongGiaoDuc.CoSoVatChat.CoSo;
import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import NguoiDung.GiangVien;
import NguoiDung.KhachHang;
import ThoiGian.Gio;
import ThoiGian.NgayThang;
import Utils.DocGhiFile;

import java.util.ArrayList;

public class QLLichPhongVan {
    public static ArrayList<LichPhongVan> dsLichPhongVan = new ArrayList<>();

    public static ArrayList<LichPhongVan> getDsLichPhongVan() {
        return dsLichPhongVan;
    }

    public static void setDsLichPhongVan(ArrayList<LichPhongVan> dsLichPhongVan) {
        QLLichPhongVan.dsLichPhongVan = dsLichPhongVan;
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
//            GiangVien giangVien = QLGiangVien.timKiemGiangVienTheoMa(maGiangVien);
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
//            KhachHang khachHang = QLKhachHang.timKhachHangTheoMa(maKhach);
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
//        for (PhongHoc phongHoc: QLPhongHoc.getDsPhongHoc()) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(phongHoc.getMaPhongHoc());sb.append("#");
//            sb.append(phongHoc.getTrangThai());sb.append("#");
//            sb.append(phongHoc.getCoSoTrucThuoc().getMaCoSo());sb.append(System.lineSeparator());
//            duLieu.add(sb.toString());
//        }
//        return duLieu;
//    }

    public static void inDSLichPhongVan(ArrayList<LichPhongVan> lichPhongVan){
        System.out.println("*".repeat(143));
        System.out.printf("* %-10s* %-30s* %-15s* %-15s* %-30s* %-30s*\n", "Mã PV", "Tên người phổng vấn", "Ngày tháng", "Thời gian","Tên khách hàng", "Trạng thái");
        System.out.println("*".repeat(143));
        for (LichPhongVan lichPhongVan1: QLLichPhongVan.getDsLichPhongVan()){
            String pvMa, pvHoTenGiangVien, pvNgayThang, pvGio, pvHoTenKhachHang, pvTrangThai;
            pvMa = lichPhongVan1.getMaCaPhongVan();

            if (lichPhongVan1.getGiangVien() == null){
                pvHoTenGiangVien = "Chưa cập nhật";
            }else {
                pvHoTenGiangVien = lichPhongVan1.getGiangVien().getHoTen();
            }

            if (lichPhongVan1.getNgayThang() == null){
                pvNgayThang = "Chưa cập nhật";
            }else {
                pvNgayThang = lichPhongVan1.getNgayThang().toString();
            }

            if (lichPhongVan1.getGioPV() == null){
                pvGio = "Chưa cập nhật";
            } else {
                pvGio = lichPhongVan1.getGioPV().toString();
            }

            pvHoTenKhachHang = lichPhongVan1.getKhachHang().getHoTen();

            if (lichPhongVan1.getTrangThaiPhongVan().equals(TrangThaiPhongVan.CHO_DUYET)){
                pvTrangThai = "Đang chờ duyệt";
            } else if (lichPhongVan1.getTrangThaiPhongVan().equals(TrangThaiPhongVan.CHO_PHONGVAN)) {
                pvTrangThai = "Đang chờ phổng vấn";
            }   else if (lichPhongVan1.getTrangThaiPhongVan().equals(TrangThaiPhongVan.DA_PHONGVAN)) {
                pvTrangThai = "Đã phổng vấn";
            } else {
                pvTrangThai = "Đã bị hủy";
            }

            System.out.printf("* %-10s* %-30s* %-15s* %-15s* %-30s* %-30s*\n",
                    pvMa,
                    pvHoTenGiangVien,
                    pvNgayThang,
                    pvGio,
                    pvHoTenKhachHang,
                    pvTrangThai);
        }
        System.out.println("*".repeat(143));

    }

    public static void main(String[] args) {
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
    }

    public static ArrayList<LichPhongVan>  timKiemLichPhongVanTheoGV(String IDgiangVien){
        ArrayList<LichPhongVan> ketQua = new ArrayList<>();

        for(LichPhongVan lichPhongVan: QLLichPhongVan.getDsLichPhongVan()){
            if (lichPhongVan.getGiangVien().getMa().equals(IDgiangVien)){
                ketQua.add(lichPhongVan);
            }
        }

        return ketQua;
    }
    public static ArrayList<LichPhongVan>  timKiemTheoNgay(NgayThang ngayThang){
        ArrayList<LichPhongVan> ketQua = new ArrayList<>();

        for(LichPhongVan lichPhongVan: QLLichPhongVan.getDsLichPhongVan()){
            if (lichPhongVan.getNgayThang().getNgay() == ngayThang.getNgay() &&
                    lichPhongVan.getNgayThang().getThang() == ngayThang.getThang() &&
                    lichPhongVan.getNgayThang().getNam() == ngayThang.getNam()){
                ketQua.add(lichPhongVan);
            }
        }

        return ketQua;
    }
    public static ArrayList<LichPhongVan>  timKiemTheoTrangThai( TrangThaiPhongVan trangThai){
        ArrayList<LichPhongVan> ketQua = new ArrayList<>();

        for(LichPhongVan lichPhongVan: QLLichPhongVan.getDsLichPhongVan()){
            if (lichPhongVan.getTrangThaiPhongVan().equals(trangThai)){
                ketQua.add(lichPhongVan);
            }
        }

        return ketQua;
    }

}
