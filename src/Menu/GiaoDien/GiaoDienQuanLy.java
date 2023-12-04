package Menu.GiaoDien;

import Menu.Session;
import QuanLyDoiTuong.QLBienLai;
import QuanLyDoiTuong.QLHocVienLopHoc;
import QuanLyDoiTuong.QLKhoaKhaiGiang;
import QuanLyDoiTuong.QLLopHoc;
import Utils.ScannerUtils;

public class GiaoDienQuanLy extends GiaoDienCongTacVien {
    public void giaoDien(){

        int choice;
        do{
            System.out.println("*".repeat(100));
            System.out.printf("*%75s%24s\n", "CHÀO MỪNG BẠN ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88", "*");
            System.out.println("*".repeat(100));
            System.out.printf("*  %-96s*\n","1. Tạo khóa mới");
            System.out.printf("*  %-96s*\n","2. Tạo lớp mới");
            System.out.printf("*  %-96s*\n","3. Thống kê học sinh theo chương trình học");
            System.out.printf("*  %-96s*\n","4. Thống kê học sinh theo khóa");
            System.out.printf("*  %-96s*\n","5. Thống kê học sinh theo tháng trong năm");
            System.out.printf("*  %-96s*\n","6. Thống kê học sinh theo năm");
            System.out.printf("*  %-96s*\n","7. Thống kê doanh thu theo chương trình");
            System.out.printf("*  %-96s*\n","8. Thống kê doanh thu theo khóa");
            System.out.printf("*  %-96s*\n","9. Thống kê doanh thu theo tháng");
            System.out.printf("*  %-96s*\n","10. THống kê doanh thu theo năm");
            System.out.printf("*  %-96s*\n","11. Đăng xuất");
            System.out.printf("*  %-96s*\n", "Bạn đã có lựa chọn chưa?");
            System.out.println("*".repeat(100));

            do{
                choice = ScannerUtils.inputInt();
                if (choice < 1 || choice > 12){
                    System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
                }
            }while(choice < 1 || choice > 12);

            switch (choice){
                case 1:
                    QLKhoaKhaiGiang.taoKhoaMoi();
                    break;

                case 2:
                    QLLopHoc.taoLopMoi();
                    break;

                case 3:
                    QLHocVienLopHoc.thongKeHocVienTheoChuongTrinh();
                    break;

                case 4:
                    QLHocVienLopHoc.thongKeHocVienTheoKhoa();
                    break;

                case 5:
                    QLHocVienLopHoc.thongKeHocVienTheoThang();
                    break;

                case 6:
                    QLHocVienLopHoc.thongKeTheoNam();
                    break;

                case 7:
                    QLBienLai.thongKeDoanhThuTheoChuongTrinh();
                    break;

                case 8:
                    QLBienLai.thongKeDoanhThuTheoKhoa();
                    break;

                case 9:
                    QLBienLai.thongKeDoanhThuTheoThang();
                    break;

                case 10:
                    QLBienLai.thongKeTheoNam();
                    break;

                case 11:
                    Session.logout();
                    break;
                case 12:
                    exit();
                    break;
            }
        } while (true);
    }


}