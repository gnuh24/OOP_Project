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
        QLCaHoc.loadDuLieu();

        QLCongTacVien.loadDuLieu();
        QLQuanLy.loadDuLieu();
        QLGiamDoc.loadDuLieu();
        QLHocVien.loadDuLieu();

        QLKhachHang.loadDuLieu();
        QLTaiKhoan.loadDuLieu();

        //Dữ liệu phức tạp có các trường là các đối tượng
        QLLichPhongVan.loadDuLieu();
        QLKetQuaPhongVan.loadDuLieu();

        //Dữ liệu cấp cao (Quan trọng và phụ thuộc vào các đối tượng rất nhiều)
    }

    public static void main(String[] args) {
        LoadDuLieu.loading();
        QLHocVien.inDSHocVien(QLHocVien.dsHocVien);
    }

    public static void saving(){
        QLChuongTrinhHoc.luuDuLieu();
        QLTroGiang.luuDuLieu();
        QLGiangVien.saveDuLieu();

        QLGiamDoc.saveDuLieu();
        QLCongTacVien.saveDuLieu();
        QLQuanLy.saveDuLieu();
        QLHocVien.luuDuLieu();

        QLCoSo.luuDuLieu();
        QLPhongHoc.luuDuLieu();
        QLTaiKhoan.saveDuLieu();

        QLKhachHang.saveDuLieu();
        QLLichPhongVan.saveDuLieu();
        QLKetQuaPhongVan.saveDuLieu();
    }
}
