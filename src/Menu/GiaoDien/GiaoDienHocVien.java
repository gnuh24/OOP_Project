package Menu.GiaoDien;

import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import Menu.Session;
import QuanLyDoiTuong.QLKetQua;
import QuanLyDoiTuong.QLLopHoc;
import Utils.ScannerUtils;

<<<<<<< HEAD:src/Menu/GiaoDien/GiaoDienHocVien.java
public class GiaoDienHocVien extends GiaoDien {
    public  void giaoDien(){
=======
public class ActorHocVien extends Actor {
    public void giaoDien() {
>>>>>>> 2a6a7d989f59edf39194fbe3de34ff3746348965:src/Menu/Actor/ActorHocVien.java
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
        QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc);
    }

    private void xemTKBCacLopSapKhaiGiang() {
        QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang);
    }

    private void xemDiem() {
        QLKetQua.inDanhSach(QLKetQua.timKiemTheoHocVien(Session.getTaiKhoan().getUser().getMaUser()));
    }
}
