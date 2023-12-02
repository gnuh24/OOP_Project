package Menu.GiaoDien;

import java.util.ArrayList;

import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.KetQua;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import Menu.Session;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.QLKetQua;
import QuanLyDoiTuong.QLLopHoc;
import QuanLyDoiTuong.QLUser;
import QuanLyDoiTuong.QLYeuCauDangKy;
import Utils.ScannerUtils;

public class GiaoDienHocVien extends GiaoDien {
    public void giaoDien() {
        int choice;
        do {
            System.out.println(
                    "-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem thời khóa biểu các lớp đang học");
            System.out.println("2. Xem thời khóa biểu các lớp sắp khai giảng");
            System.out.println("3. Xem điểm");
            System.out.println("4. Đóng học phí");
            System.out.println("5. Đăng ký khóa học mới");
            System.out.println("6. Đăng xuất");
            System.out.println("7. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 7 trên màn hình");
            }

            switch (choice) {
                case 1:
                    xemTKBCacLopDangHoc();
                    break;
                case 2:
                    xemTKBCacLopSapKhaiGiang();
                    break;

                case 3:
                    xemDiem();
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    Session.logout();
                    break;

                case 7:
                    exit();
                    break;
            }
        } while (true);
    }

    private void xemTKBCacLopDangHoc() {
        QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
    }

    private void xemTKBCacLopSapKhaiGiang() {
        QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang));
    }

    private void xemDiem() {
        QLKetQua.inDanhSach(QLKetQua.timKiemTheoHocVien(Session.getTaiKhoan().getUser().getMaUser()));
    }

    private void dangKyMonHocChoHocVien() {
        ArrayList<LopHoc> dsCacLopCacLopDangHoc = QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc);
        ArrayList<LopHoc> dsCacLopCacLopSapKhaiGiang = QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang);
        ArrayList<LopHoc> dsCacLopHocPhuHop = new ArrayList<>(dsCacLopCacLopDangHoc);

        QLLopHoc.inDanhSach(dsCacLopHocPhuHop);

        System.out.println("Bạn chọn lớp học nào ??");

        String malop = ScannerUtils.inputString();
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);

        while (lopHoc == null) {
            System.out.println("Bạn chỉ được nhập mã lớp đúng với các lớp được đề xuất !!!");
            malop = ScannerUtils.inputString();
            lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
        }

        System.out.println("Bạn có muốn thanh toán luôn học phí ?");
        System.out.println("1. Tôi muốn đóng ");
        System.out.println("2. Tôi chỉ muốn ghi danh");
        System.out.println("Ấn các số còn lại để thoát !!");

        int luaChon = ScannerUtils.inputInt();
        User hocVien = Session.getTaiKhoan().getUser();

        if (luaChon == 1) {
            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(hocVien, lopHoc, lopHoc.getChuongTrinh().getHocPhi());

            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLKetQua.getDsKetQua().add(new KetQua(hocVien, lopHoc));

            System.out.println("Đăng ký thành công !!");
        } else if (luaChon == 2) {
            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(hocVien, lopHoc);

            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLKetQua.getDsKetQua().add(new KetQua(hocVien, lopHoc));

            System.out.println("Đăng ký thành công !!");
        } else {
            giaoDien();
        }
    }
}
