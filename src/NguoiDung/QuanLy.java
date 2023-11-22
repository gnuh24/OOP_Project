package NguoiDung;

import NguoiDung.CongTacVien;
import ThoiGian.NgayThang;

public class QuanLy extends CongTacVien {
    public QuanLy(){}
    public QuanLy(String hoTen,
                  String email,
                  boolean gioiTinh,
                  String soDienThoai,
                  NgayThang ngaySinh,
                  String diaChi,
                  String ma,
                  boolean trangThai) {

        super(hoTen, email, gioiTinh, soDienThoai, ngaySinh, diaChi, ma, trangThai);

    }

    public void themKhoaHocMoi(){
    }

    public void themLop(){

    }

    public void suaLop(){

    }

}
