package QuanLyDoiTuong;

import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
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

    public static void loadDuLieu(){
        ArrayList<String> duLieu= DocGhiFile.docDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlLichPhongVan.txt");
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong LỊCH PHỔNG VẤN");

    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String dong : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = dong.split("#");



            String maCa = cacThuocTinh[0];

            String maGiangVien = cacThuocTinh[1];
            GiangVien giangVien = QLGiangVien.timKiemGiangVienTheoMa(maGiangVien);

            NgayThang ngayThang = null;
            if (!cacThuocTinh[2].equals("") && !cacThuocTinh[3].equals("") && !cacThuocTinh[4].equals("")){
                int ngay = Integer.parseInt(cacThuocTinh[2]);
                int thang = Integer.parseInt(cacThuocTinh[3]);
                int nam = Integer.parseInt(cacThuocTinh[4]);
                ngayThang = new NgayThang(ngay, thang, nam);
            }

            Gio thoiGian = null;
            if (!cacThuocTinh[5].equals("") && !cacThuocTinh[6].equals("")){
                int gio =  Integer.parseInt(cacThuocTinh[5]);
                int phut =  Integer.parseInt(cacThuocTinh[6]);
                thoiGian = new Gio(gio, phut);
            }


            String maKhach = cacThuocTinh[7];
            KhachHang khachHang = QLKhachHang.timKhachHangTheoMa(maKhach);

            TrangThaiPhongVan trangThai = null;
            switch (cacThuocTinh[8]){
                case "1":
                    trangThai = TrangThaiPhongVan.CHO_DUYET;
                    break;
                case "2":
                    trangThai = TrangThaiPhongVan.CHO_PHONGVAN;
                    break;
                case "3":
                    trangThai = TrangThaiPhongVan.DA_PHONGVAN;
                    break;
                case "4":
                    trangThai = TrangThaiPhongVan.HUY;
                    break;
            }

            LichPhongVan lichPhongVan = new LichPhongVan(maCa, giangVien, ngayThang, thoiGian, khachHang, trangThai);
            QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);

        }
    }

    public static void saveDuLieu() {
        ArrayList<String> duLieu = xuLyDuLieuDeLuu();
        DocGhiFile.ghiDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlLichPhongVan.txt",duLieu);
        System.out.println("Đã lưu xong LỊCH PHỔNG VẤN");

    }
    public static ArrayList<String> xuLyDuLieuDeLuu() {
        // duyệt qua duLieu và bắt đầu xử lý!
        ArrayList<String> duLieu= new ArrayList<>();
        for (LichPhongVan lichPhongVan: QLLichPhongVan.getDsLichPhongVan()) {
            StringBuilder sb = new StringBuilder();
            sb.append(lichPhongVan.getMaCaPhongVan());sb.append("#");

            if (lichPhongVan.getGiangVien() == null){
                sb.append("#");
            }else {
                sb.append(lichPhongVan.getGiangVien().getMa());sb.append("#");

            }

            if (lichPhongVan.getNgayThang() == null){
                sb.append("#");
                sb.append("#");
                sb.append("#");

            }else {
                sb.append(lichPhongVan.getNgayThang().getNgay());sb.append("#");
                sb.append(lichPhongVan.getNgayThang().getThang());sb.append("#");
                sb.append(lichPhongVan.getNgayThang().getNam());sb.append("#");
            }


            if (lichPhongVan.getGioPV() == null){
                sb.append("#");
                sb.append("#");

            }else {
                sb.append(lichPhongVan.getGioPV().getGio());sb.append("#");
                sb.append(lichPhongVan.getGioPV().getPhut());sb.append("#");
            }

            sb.append(lichPhongVan.getKhachHang().getMaKhachHang());sb.append("#");

            if (lichPhongVan.getTrangThaiPhongVan().equals(TrangThaiPhongVan.CHO_DUYET)){
                sb.append("1");
            }else  if (lichPhongVan.getTrangThaiPhongVan().equals(TrangThaiPhongVan.CHO_PHONGVAN)){
                sb.append("2");
            } else  if (lichPhongVan.getTrangThaiPhongVan().equals(TrangThaiPhongVan.DA_PHONGVAN)){
                sb.append("3");
            }else{
                sb.append("4");
            }

            sb.append(System.lineSeparator());
            duLieu.add(sb.toString());
        }
        return duLieu;
    }

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

    public static LichPhongVan timKiemLichPhongVanTheoMa(String idPhongVan){
        LichPhongVan lichPhongVan = null;
        for(LichPhongVan lichPhongVan1: QLLichPhongVan.getDsLichPhongVan()){
            if (lichPhongVan1.getMaCaPhongVan().equals(idPhongVan)){
                return lichPhongVan1;
            }
        }
        return lichPhongVan;
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
