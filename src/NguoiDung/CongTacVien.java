package NguoiDung;

import ThoiGian.NgayThang;


public class CongTacVien extends CaNhanTrungTam {
    public CongTacVien(){}


    public CongTacVien(String hoTen,
                     String email,
                     boolean gioiTinh,
                     String soDienThoai,
                     NgayThang ngaySinh,
                     String diaChi,
                     String ma,
                     boolean trangThai) {
        super(hoTen, email, gioiTinh, soDienThoai, ngaySinh, diaChi, ma, trangThai);
    }

//    public void xemDSLopTheoKhoa(String maKhoa){
//        System.out.printf("%-10s %-10s %-10s %-10s\n","Ma lop","Khoa","Chuong trinh","Ca hoc");
//        for(HeThongGiaoDuc.LopHoc.LopHoc lopHoc:QLLopHoc.dsLopHoc){
//            if(lopHoc.getKhoa().getMaKhoa().equals(maKhoa))
//                System.out.printf("%-10s %-10s %-10s\n",lopHoc.getMaLop(),lopHoc.getKhoa().getMaKhoa(),lopHoc.getChuongTrinh().getMaChuongTrinh(),lopHoc.getCaHocMacDinh().toString());
//        }
//    }
//
//    public void xemDSLopTheoKhoa(KhoaKhaiGiang khoa){
//        System.out.printf("%-10s %-10s %-10s %-10s\n","Ma lop","Khoa","Chuong trinh","Ca hoc");
//        for(HeThongGiaoDuc.LopHoc.LopHoc lopHoc:QuanLyLopHoc.dsLopHoc){
//            if(lopHoc.getKhoa().getMaKhoa().equals(khoa.getMaKhoa()))
//                System.out.printf("%-10s %-10s %-10s\n",lopHoc.getMaLop(),lopHoc.getKhoa().getMaKhoa(),lopHoc.getChuongTrinh().getMaChuongTrinh(),lopHoc.getCaHocMacDinh().toString());
//        }
//    }
//
//    public void xemDSLopTheoChuongTrinh(ChuongTrinhHoc chuongTrinhHoc){
//        System.out.printf("%-10s %-10s %-10s %-10s\n","Ma lop","Khoa","Chuong trinh","Ca hoc");
//        for (HeThongGiaoDuc.LopHoc.LopHoc lopHoc : QuanLyLopHoc.dsLopHoc) {
//            if(lopHoc.getChuongTrinh().getMaChuongTrinh().equals(chuongTrinhHoc.getMaChuongTrinh()))
//                System.out.printf("%-10s %-10s %-10s\n",lopHoc.getMaLop(),lopHoc.getKhoa().getMaKhoa(),lopHoc.getChuongTrinh().getMaChuongTrinh(),lopHoc.getCaHocMacDinh().toString());
//        }
//    }
//
//    public void xemDSHocVienTheoLop(HeThongGiaoDuc.LopHoc.LopHoc lopHoc){
//        System.out.printf("%-15s %-25s %-10\n","Ma hoc vien","Ten hoc vien","Gioi tinh");
//        for(HocVien hocVien:lopHoc.getDanhSachLop()){
//            System.out.printf("%-15s %-25s %-10\n",hocVien.getMaHocVien(),hocVien.getHoTen(),hocVien.getGioiTinh());
//        }
//    }
//
//
//    void thongKeHocVienTheoKhoa(String maKhoa){
//        System.out.printf("%-10s %-10s\n","Ma hoc vien","Ten hoc vien");
//        for(HocVien hocVien:QuanLyHocVien.dsHocVien){
//            if(hocVien.getKhoa().getMaKhoa().equals(maKhoa))
//                System.out.printf("%-10s %-10s\n",hocVien.getMaHocVien(),hocVien.getTenHocVien());
//        }
//    }


    public void xemDSHocVienConNo(){

    }

//    public boolean datLichPhongVan(){
//
//    }
//
//    public boolean chuyenLopChoHocVien(){
//
//    }

}
