package Menu;

import QuanLyDoiTuong.*;

public class LoadDuLieu {
    public static void loading(){
        QLGiangVien.loadDuLieu();
        QLTroGiang.loadDuLieu();
        QLChuongTrinhHoc.loadDuLieu();
        QLCoSo.loadDuLieu();
        QLPhongHoc.loadDuLieu();
    }

    public static void main(String[] args) {
        LoadDuLieu.loading();
        QLCoSo.inDSCoSo(QLCoSo.getDsCoSo());
        QLPhongHoc.inDSPhongHoc(QLPhongHoc.getDsPhongHoc());
    }

    public static void saving(){

    }
}
