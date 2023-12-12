package Menu.GiaoDien;

import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import Menu.Session;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;
import java.util.ArrayList;

public class GiaoDienGiangVien extends GiaoDienNhanVienDungLop {
    @Override
    public void giaoDien() {
        int choice;
        do {
            System.out.println("*".repeat(100));
            System.out.printf("*%75s%24s\n", "CHÀO MỪNG BẠN ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88", "*");
            System.out.println("*".repeat(100));
            System.out.printf("*   %-95s*\n" ,"1. Xem lịch dạy của lớp hiện tại");
            System.out.printf("*   %-95s*\n" ,"2. Xem lịch dạy của lớp sắp khai giảng");
            System.out.printf("*   %-95s*\n" ,"3. Xem danh sách học sinh của các lớp");
            System.out.printf("*   %-95s*\n" ,"4. Xem danh sách lịch phổng vấn");
            System.out.printf("*   %-95s*\n" ,"5. Nhập điểm cho thí sinh phổng vấn");
            System.out.printf("*   %-95s*\n" ,"6. Nhập điểm cho học viên các lớp");
            System.out.printf("*   %-95s*\n" ,"7. Đăng xuất");
            System.out.printf("*   %-95s*\n" ,"8. Thoát chương trình");
            System.out.printf("*   %-95s*\n" ,"Bạn đã có lựa chọn chưa ?");
            System.out.println("*".repeat(100));

            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 8) {
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
                    xemLichPhongVan();
                    break;

                case 5:
                    nhapDiemChoThiSinhPhongVan();
                    break;

                case 6:
                    nhapDiemChoHocVienLopHoc();
                    break;
                case 7:
                    Session.logout();
                    break;

                case 8:
                    exit();
                    break;
            }
        } while (true);
    }
    @Override
    protected void xemDanhSachLopHoc() {
        QLLopHoc.inDanhSach(
                QLLopHoc.timKiemLopTheoTrangThai(
                        QLLopHoc.timKiemLopTheoGiangVien(Session.getTaiKhoan().getUser().getMaUser()),
                        TrangThaiLop.Dang_Hoc));
    backTo();

}

    @Override
    protected void xemDanhSachLopSapKhaiGiang() {
        QLLopHoc.inDanhSach(
                QLLopHoc.timKiemLopTheoTrangThai(
                        QLLopHoc.timKiemLopTheoGiangVien(Session.getTaiKhoan().getUser().getMaUser()),
                        TrangThaiLop.Sap_Khai_Giang)
        );
        backTo();

    }

    private void xemLichPhongVan() {
        QLLichPhongVan.inDSLichPhongVan(
                QLLichPhongVan.timKiemLichPhongVanTheoGV(Session.getTaiKhoan().getUser().getMaUser()));
        backTo();

    }

    private void nhapDiemChoThiSinhPhongVan(){
        QLLichPhongVan.nhapDiemChoThiSinhPhongVan();
    }

    @Override
    protected void xemDanhSachHocVien() {
        ArrayList<LopHoc> dsLopHoc = QLLopHoc.timKiemLopTheoGiangVien(Session.getTaiKhoan().getUser().getMaUser());
        QLLopHoc.inDanhSach(dsLopHoc);
        System.out.println("Chọn lớp: ");
        System.out.println("Ấn -1 để thoát !!");
        String maLop = ScannerUtils.inputString();
        if (maLop.equals("-1")){
            return;
        }
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLop, dsLopHoc);
        while (lopHoc == null){
            System.err.println("Mã lớp không hợp lệ !!!");
            System.out.println("Ấn -1 để thoát !!");
            maLop = ScannerUtils.inputString();
            if (maLop.equals("-1")){
                return;
            }
            lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLop, dsLopHoc);
        }
        QLHocVienLopHoc.inDanhSach(QLHocVienLopHoc.timKiemTheoLopHoc(maLop));
        backTo();

    }

    private void nhapDiemChoHocVienLopHoc() {
        QLHocVienLopHoc.nhapDiemChoHocVienLopHoc();
    }
}
