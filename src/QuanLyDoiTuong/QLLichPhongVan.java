package QuanLyDoiTuong;

import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import NguoiDung.User;
import Utils.Convert;
import Utils.DocGhiFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class QLLichPhongVan {

//    public static void main(String[] args) {
//        QLUser.loadDuLieu();
//        QLLichPhongVan.loadDuLieu();
//        inDSLichPhongVan(dsLichPhongVan);
//        QLUser.saveDuLieu();
//        QLLichPhongVan.loadDuLieu();
//    }
    public static ArrayList<LichPhongVan> dsLichPhongVan = new ArrayList<>();

    public static ArrayList<LichPhongVan> getDsLichPhongVan() {
        return dsLichPhongVan;
    }

    public static void setDsLichPhongVan(ArrayList<LichPhongVan> dsLichPhongVan) {
        QLLichPhongVan.dsLichPhongVan = dsLichPhongVan;
    }

    public static void loadDuLieu(){
        ArrayList<String> duLieu= DocGhiFile.docDuLieuFile("src\\Data\\qlLichPhongVan.txt");
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
            User giangVien = QLUser.timUserTheoMa(maGiangVien);

            LocalDate ngayThang = null;
            if ( !cacThuocTinh[2].equals("") ){
                ngayThang = Convert.stringToDate(cacThuocTinh[2]);
            }

            LocalTime thoiGian = null;
            if (!cacThuocTinh[3].equals("")){

                thoiGian = Convert.stringToTime(cacThuocTinh[3]);
            }


            String maKhach = cacThuocTinh[4];
            User khachHang = QLUser.timUserTheoMa(maKhach);
            TrangThaiPhongVan trangThai = TrangThaiPhongVan.toEnum(cacThuocTinh[5]);

            LichPhongVan lichPhongVan = new LichPhongVan(maCa, giangVien, ngayThang, thoiGian, khachHang, trangThai);
            QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);

        }
    }

    public static void saveDuLieu() {
        ArrayList<String> duLieu = xuLyDuLieuDeLuu();
        DocGhiFile.ghiDuLieuFile("src\\Data\\qlLichPhongVan.txt",duLieu);
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
                sb.append(lichPhongVan.getGiangVien().getMaUser());sb.append("#");
            }

            if (lichPhongVan.getNgayThang() == null){
                sb.append("#");
            }else {
                sb.append( Convert.dateToString(lichPhongVan.getNgayThang() ) )
                ;sb.append("#");
            }


            if (lichPhongVan.getGioPV() == null){
                sb.append("#");

            }else {
                sb.append( Convert.timeToString(lichPhongVan.getGioPV()) );sb.append("#");
            }

            sb.append(lichPhongVan.getKhachHang().getMaUser());sb.append("#");

            sb.append(TrangThaiPhongVan.toString(lichPhongVan.getTrangThaiPhongVan()));
            sb.append(System.lineSeparator());
            duLieu.add(sb.toString());
        }
        return duLieu;
    }

    public static void inDSLichPhongVan(ArrayList<LichPhongVan> lichPhongVan){
        System.out.println("*".repeat(128));
        System.out.printf("* %-10s* %-30s* %-30s* %-15s* %-15s* %-15s*\n", "Mã PV", "Tên khách hàng", "Tên người phổng vấn", "Ngày tháng", "Thời gian", "Trạng thái");
        System.out.println("*".repeat(128));
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
                pvNgayThang = Convert.dateToString( lichPhongVan1.getNgayThang() );
            }

            if (lichPhongVan1.getGioPV() == null){
                pvGio = "Chưa cập nhật";
            } else {
                pvGio = Convert.timeToString(lichPhongVan1.getGioPV());
            }

            pvHoTenKhachHang = lichPhongVan1.getKhachHang().getHoTen();

            pvTrangThai = TrangThaiPhongVan.toString(lichPhongVan1.getTrangThaiPhongVan());

            System.out.printf("* %-10s* %-30s* %-30s* %-15s* %-15s* %-15s*\n",
                    pvMa,
                    pvHoTenKhachHang,
                    pvHoTenGiangVien,
                    pvNgayThang,
                    pvGio,
                    pvTrangThai);
        }
        System.out.println("*".repeat(128));

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
            if (lichPhongVan.getGiangVien().getMaUser().equals(IDgiangVien)){
                ketQua.add(lichPhongVan);
            }
        }

        return ketQua;
    }
    public static ArrayList<LichPhongVan>  timKiemTheoNgay(LocalDate ngayThang){
        ArrayList<LichPhongVan> ketQua = new ArrayList<>();

        for(LichPhongVan lichPhongVan: QLLichPhongVan.getDsLichPhongVan()){
            if (lichPhongVan.getNgayThang().getDayOfMonth() == ngayThang.getDayOfMonth() &&
                    lichPhongVan.getNgayThang().getMonthValue() == ngayThang.getMonthValue() &&
                    lichPhongVan.getNgayThang().getYear() == ngayThang.getYear()){
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
