package Menu.GiaoDien;

import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import Menu.Session;
import QuanLyDoiTuong.QLLopHoc;
import Utils.ScannerUtils;

public class GiaoDienHocVien extends GiaoDien {
    public  void giaoDien(){
        int choice;
        do{
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem thời khóa biểu các lớp đang học và sắp khai giảng");
            System.out.println("2. Xem điểm");
            System.out.println("3. Đóng học phí");
            System.out.println("4. Đăng ký khóa học mới");
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 5 trên màn hình");
            }

            switch (choice){
                case 1:
                    QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Session.getTaiKhoan().getUser().getMaUser()), TrangThaiLop.Dang_Hoc));
                    break;
                case 2:
                    QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Session.getTaiKhoan().getUser().getMaUser()), TrangThaiLop.Sap_Khai_Giang));
                    break;

                case 3:
                    QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
                    break;

                case 5:
                    Session.logout();
                    break;

                case 6:
                    exit();
                    break;
            }
        } while (true);
    }
}
