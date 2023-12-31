package Menu.GiaoDien;

import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import Menu.Session;
import QuanLyDoiTuong.QLHocVienLopHoc;
import QuanLyDoiTuong.QLLopHoc;
import Utils.ScannerUtils;

import java.util.ArrayList;

public class GiaoDienTroGiang extends GiaoDienNhanVienDungLop {
    @Override
    public void giaoDien() {
        int choice;
        do {
            System.out.println("*".repeat(100));
            System.out.printf("*%75s%24s\n", "CHÀO MỪNG BẠN ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88", "*");
            System.out.println("*".repeat(100));
            System.out.printf("*   %-95s*\n","1. Xem lịch dạy của khóa hiện tại");
            System.out.printf("*   %-95s*\n","2. Xem lịch dạy của khóa sắp khai giảng");
            System.out.printf("*   %-95s*\n","3. Xem danh sách học sinh của các lớp");
            System.out.printf("*   %-95s*\n","4. Đăng xuất");
            System.out.printf("*   %-95s*\n","5. Thoát chương trình");
            System.out.printf("*   %-95s*\n","Bạn đã có lựa chọn chưa ?");
            System.out.println("*".repeat(100));
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
            }

            switch (choice) {
                case 1:
                    xemDanhSachLopHoc();
                    break;
                case 2:
                    xemDanhSachLopSapKhaiGiang();
                    break;

                case 3:
                    xemDanhSachHocVien();
                    break;

                case 4:
                    Session.logout();
                    break;

                case 5:
                    exit();
                    break;
            }
        } while (true);
    }

    @Override
    protected void xemDanhSachLopHoc() {
        QLLopHoc.inDanhSach(
                QLLopHoc.timKiemLopTheoTrangThai(
                        QLLopHoc.timKiemLopTheoTroGiang(Session.getTaiKhoan().getUser().getMaUser()),
                        TrangThaiLop.Dang_Hoc));
        backTo();
    }
    @Override
    protected void xemDanhSachLopSapKhaiGiang() {
        QLLopHoc.inDanhSach(
                QLLopHoc.timKiemLopTheoTrangThai(
                        QLLopHoc.timKiemLopTheoTroGiang(Session.getTaiKhoan().getUser().getMaUser()),
                        TrangThaiLop.Sap_Khai_Giang)
        );
        backTo();

    }

    @Override
    protected void xemDanhSachHocVien() {
        ArrayList<LopHoc> dsLopHoc = QLLopHoc.timKiemLopTheoTroGiang(Session.getTaiKhoan().getUser().getMaUser());
        QLLopHoc.inDanhSach(dsLopHoc);
        System.out.println("Chọn lớp: ");
        System.out.println("Ấn 1 để thoát !!");
        String maLop = ScannerUtils.inputString();
        if (maLop.equals("1")){
            return;
        }
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLop, dsLopHoc);
        while (lopHoc == null){
            System.err.println("Mã lớp không hợp lệ !!!");
            System.out.println("Ấn 1 để thoát !!");
            maLop = ScannerUtils.inputString();
            if (maLop.equals("1")){
                return;
            }
            lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLop, dsLopHoc);
        }
        QLHocVienLopHoc.inDanhSach(QLHocVienLopHoc.timKiemTheoLopHoc(maLop));
        backTo();
    }
}
