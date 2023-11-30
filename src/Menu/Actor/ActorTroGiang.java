package Menu.Actor;

import java.text.Normalizer.Form;

import Menu.Session;
import QuanLyDoiTuong.QLLopHoc;
import Utils.ScannerUtils;

public class ActorTroGiang extends Actor {
    public void giaoDien() {
        int choice;
        do {
            System.out.println(
                    "-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem lịch dạy của khóa hiện tại");
            System.out.println("2. Xem lịch dạy của khóa sắp khai giảng");
            System.out.println("3. Xem danh sách học sinh của các lớp");
            System.out.println("4. Đăng xuất");
            System.out.println("5. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
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

    protected void xemDanhSachLopHoc() {
        QLLopHoc.inDSLopHoc(
                QLLopHoc.timKiemLopTheoTrangThai(
                        QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
    }

    protected void xemDanhSachLopSapKhaiGiang() {
        QLLopHoc.inDSLopHoc(
                QLLopHoc.timKiemLopTheoTrangThai(
                        QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
    }

    protected void xemDanhSachHocVien() {
        QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
    }
}
