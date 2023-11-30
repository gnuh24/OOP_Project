package Menu.Actor;

import Menu.Form;
import Menu.Menu;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.QLChuongTrinhHoc;
import QuanLyDoiTuong.QLUser;
import Utils.ScannerUtils;

public class ActorKhachHang {
    public static void giaoDienKhachHang() {
        int choice;
        do {
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem danh sách giảng viên");
            System.out.println("2. Xem danh sách chương trình học");
            System.out.println("3. Xem danh sách các lớp đang học");
            System.out.println("4. Xem danh sách các lớp sắp khai giảng");
            System.out.println("5. Đăng ký phổng vấn");
            System.out.println("6. Đăng nhập");
            System.out.println("7. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 7) {
                System.out.println("Bạn chỉ được nhập các lựa chọn trên màn hình");
            }

            switch (choice) {
                case 1:
                    QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true));
                    break;
                case 2:
                    QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
                    break;
//                case 3:
//                    QLLop.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
//                    break;
//                case 4:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang));
//                    break;
                case 5:
                    Form.dangKyPhongVan();
                    break;
                case 6:
                    Form.login();
                    break;
                case 7:
                    Menu.exit();
                    break;
            }
        } while (true);
    }

    private void hello(){
        System.out.println("Hello");
    }


}
