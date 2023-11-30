package Menu;


import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.LienHe;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import Menu.Actor.ActorKhachHang;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;


public class Menu {
    private static final ActorKhachHang actorKhachHang = new ActorKhachHang();
    public static void main(String[] args) {
        LoadDuLieu.loading();
        actorKhachHang.giaoDien();
    }
}
