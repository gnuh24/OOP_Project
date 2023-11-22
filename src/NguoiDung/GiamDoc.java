package NguoiDung;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import ThoiGian.NgayThang;

public class GiamDoc extends QuanLy {

    public GiamDoc(){}
    public GiamDoc(String hoTen,
                  String email,
                  boolean gioiTinh,
                  String soDienThoai,
                  NgayThang ngaySinh,
                  String diaChi,
                  String ma,
                  boolean trangThai) {

        super(hoTen, email, gioiTinh, soDienThoai, ngaySinh, diaChi, ma, trangThai);

    }



    // public void capNhatHocPhi(){
    //     System.out.println("Chon chuong trinh cap nhat");
    //     System.out.printf("%-4s %-10s %-10s\n","Stt","Ma chuong trinh","Hoc phi");
    //     int i=1;
    //     for(ChuongTrinhHoc chuongTrinhHoc:QuanLyChuongTrinhHoc.dsChuongTrinhHoc){
    //         System.out.printf("%-4s %-10s %-10s\n",i++,chuongTrinhHoc.getMaChuongTrinhHoc(), chuongTrinhHoc.getHocPhi());
    //     }
    //     System.out.println("Nhap so thu tu khong co trong danh sach de thoat");
    //     Scanner scan = new Scanner(System.in);
    //     int value=Integer.parseInt(scan.nextLine());
    //     switch (value) {
    //         case 1:
    //             System.out.println("Nhap hoc phi moi cho "+QuanLyChuongTrinhHoc.dsChuongTrinhHoc[1].getMaChuongTrinhHoc);
    //             QuanLyChuongTrinhHoc.dsChuongTrinhHoc[1].setHocPhi();
    //             break;
    //         case 2:
                
    //             break;
    //         case 3:
                
    //             break;
    //         case 4:
                
    //             break;
    //         case 5:
                
    //             break;
        
    //         default:
    //             break;
    //     }
    // }

    public void capNhatHocPhi(){
        
    }

    public void themChuongTrinhHocMoi(){

    }

    public void thongKeDoanhThuTheoThoiGian(NgayThang ngayThangBatDau, NgayThang ngayThangKetThuc){

    }

    public void thongKeDoanhThuTheoKhoa(KhoaKhaiGiang khoa){

    }

    public void thongKeDoanhThuTheoChuongTrinh(ChuongTrinhHoc chuongTrinhHoc){

    }

    public void thongKeSoLuongHocSinhTheoKhoa(KhoaKhaiGiang khoa){

    }

    public void thongKeSoLuongHocSinhTheoChuongTrinhHoc(ChuongTrinhHoc chuongTrinhHoc){

    }
}
