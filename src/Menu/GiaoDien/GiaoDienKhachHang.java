package Menu.GiaoDien;

import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import Menu.Session;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;

import java.time.LocalDate;

public class GiaoDienKhachHang extends GiaoDien {
    public void giaoDien() {
        int choice;
        do {
            System.out.println("*".repeat(100));
            System.out.printf("*%75s%24s\n", "CHÀO MỪNG BẠN ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88", "*");
            System.out.println("*".repeat(100));
            System.out.printf("*  %-96s*\n", "1. Xem danh sách giảng viên");
            System.out.printf("*  %-96s*\n", "2. Xem danh sách chương trình học");
            System.out.printf("*  %-96s*\n", "3. Xem danh sách các lớp đang học");
            System.out.printf("*  %-96s*\n", "4. Xem danh sách các lớp sắp khai giảng");
            System.out.printf("*  %-96s*\n", "5. Xem danh sách các cơ sở đang hoạt động");
            System.out.printf("*  %-96s*\n", "6. Đăng ký phổng vấn");
            System.out.printf("*  %-96s*\n", "7. Đăng nhập");
            System.out.printf("*  %-96s*\n", "8. Thoát chương trình");
            System.out.printf("*  %-96s*\n", "Bạn đã có lựa chọn chưa ?");
            System.out.println("*".repeat(100));
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 8) {
                System.out.println("Bạn chỉ được nhập các lựa chọn trên màn hình");
            }

            switch (choice) {
                case 1:
                    xemDanhSachGiangVien();
                    backTo();
                    break;
                case 2:
                    xemDanhSachChuongTrinhHoc();
                    backTo();
                    break;
                case 3:
                    xemDanhSachCacLopDangHoc();
                    backTo();
                    break;
                case 4:
                    xemDanhSachLopSapKhaiGiang();
                    backTo();
                    break;
                case 5:
                    xemDanhSachCoSoDangHoatDong();
                    backTo();
                    break;
                case 6:
                    dangKyPhongVan();
                    break;
                case 7:
                    Session.login();
                    break;
                case 8:
                    exit();
                    break;
            }
        } while (true);
    }



    public void dangKyPhongVan(){
        User khachHang = new User();
        QLUser.getDsUser().add(khachHang);
        LichPhongVan lichPhongVan = new LichPhongVan(khachHang);
        QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);
        System.out.println("Bạn đã đăng ký thành công !!");
        System.out.println("Hình thức test là online thông qua Zoom (Premium)");
        System.out.println("Bạn sẽ nhận được thông tin chi tiết qua email và điện thoại trong thời gian tới !!");
    }


    public void xemDanhSachGiangVien(){
        QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true));
    }

    public void xemDanhSachChuongTrinhHoc(){
        QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
    }

    public void xemDanhSachCacLopDangHoc(){
        QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
    }

    public void xemDanhSachLopSapKhaiGiang(){
        QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang));
    }

    public void xemDanhSachCoSoDangHoatDong(){
        QLCoSo.inDSCoSo(QLCoSo.getDsCoSo());
    }
}