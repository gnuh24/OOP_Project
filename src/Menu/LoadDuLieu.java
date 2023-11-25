package Menu;

import QuanLyDoiTuong.*;
import TaiKhoan.QLTaiKhoan;

public class LoadDuLieu {
    public static void loading(){
        //Dữ liệu đơn BẮT BUỘC PHẢI LOAD lên trước

        QLChuongTrinhHoc.loadDuLieu();
        QLKhoaKhaiGiang.loadDuLieu();
        QLCoSo.loadDuLieu();
        QLPhongHoc.loadDuLieu();
        QLCaHoc.loadDuLieu();
        QLUser.loadDuLieu();


        //Dữ liệu phức tạp có các trường là các đối tượng
        QLTaiKhoan.loadDuLieu();
        QLLichPhongVan.loadDuLieu();
//        QLKetQuaPhongVan.loadDuLieu();

        //Dữ liệu cấp cao (Quan trọng và phụ thuộc vào các đối tượng rất nhiều)
    }

    public static void main(String[] args) {
        LoadDuLieu.loading();
    }

    public static void saving(){
        QLChuongTrinhHoc.luuDuLieu();
        QLKhoaKhaiGiang.saveDuLieu();
        QLCoSo.luuDuLieu();
        QLPhongHoc.luuDuLieu();
        QLTaiKhoan.saveDuLieu();
        QLUser.saveDuLieu();
        QLLichPhongVan.saveDuLieu();
//        QLKetQuaPhongVan.saveDuLieu();
    }
}
