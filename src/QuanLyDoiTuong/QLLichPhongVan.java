package QuanLyDoiTuong;

import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import ThoiGian.NgayThang;

import java.util.ArrayList;

public class QLLichPhongVan {
    public static ArrayList<LichPhongVan> dsLichPhongVan = new ArrayList<>();

    public static ArrayList<LichPhongVan> getDsLichPhongVan() {
        return dsLichPhongVan;
    }

    public static void setDsLichPhongVan(ArrayList<LichPhongVan> dsLichPhongVan) {
        QLLichPhongVan.dsLichPhongVan = dsLichPhongVan;
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
