package Menu;

import QuanLyDoiTuong.*;
import TaiKhoan.QLTaiKhoan;

public class LoadDuLieu {
    public static void loading(){
        //Dữ liệu đơn BẮT BUỘC PHẢI LOAD lên trước
        QLGiangVien.loadDuLieu();
        QLTroGiang.loadDuLieu();
        QLChuongTrinhHoc.loadDuLieu();

        QLCoSo.loadDuLieu();
        QLPhongHoc.loadDuLieu();

        QLKhachHang.loadDuLieu();
        QLTaiKhoan.loadDuLieu();

        //Dữ liệu phức tạp có các trường là các đối tượng
        QLLichPhongVan.loadDuLieu();
    }

    public static void main(String[] args) {
        LoadDuLieu.loading();
        QLCoSo.inDSCoSo(QLCoSo.getDsCoSo());
        QLPhongHoc.inDSPhongHoc(QLPhongHoc.getDsPhongHoc());
    }

    public static void saving(){
        QLChuongTrinhHoc.luuDuLieu();
        QLTroGiang.luuDuLieu();
        QLGiangVien.saveDuLieu();

        QLCoSo.luuDuLieu();
        QLPhongHoc.luuDuLieu();
        QLTaiKhoan.saveDuLieu();

        QLKhachHang.saveDuLieu();


        QLLichPhongVan.saveDuLieu();
    }
}
