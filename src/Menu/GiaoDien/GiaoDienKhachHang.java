package Menu.GiaoDien;

import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import Menu.Session;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;

public class GiaoDienKhachHang extends GiaoDien {
    @Override
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
                System.err.println("Bạn chỉ được nhập các lựa chọn trên màn hình");
            }

            switch (choice) {
                case 1:
                    xemDanhSachGiangVien();
                    break;
                case 2:
                    xemDanhSachChuongTrinhHoc();
                    break;
                case 3:
                    xemDanhSachCacLopDangHoc();
                    break;
                case 4:
                    xemDanhSachLopSapKhaiGiang();
                    break;
                case 5:
                    xemDanhSachCoSoDangHoatDong();
                    break;
                case 6:
                    QLLichPhongVan.dangKyPhongVan();
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


    public void xemDanhSachGiangVien(){
        QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true));
        backTo();
    }

    public void xemDanhSachChuongTrinhHoc(){
        QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
        backTo();
    }

    public void xemDanhSachCacLopDangHoc(){
        QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
        backTo();
    }

        public void xemDanhSachLopSapKhaiGiang(){
            QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang));
            backTo();
        }

        public void xemDanhSachCoSoDangHoatDong(){
            QLCoSo.inDSCoSo(QLCoSo.getDsCoSo());
            backTo();
        }
}