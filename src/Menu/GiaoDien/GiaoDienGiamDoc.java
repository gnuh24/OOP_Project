package Menu.GiaoDien;

import Menu.Session;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;

public class GiaoDienGiamDoc extends GiaoDienQuanLy {
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
            System.out.printf("*  %-96s*\n","11. Thay đổi học phí chương trình");
            System.out.printf("*  %-96s*\n","12. Đăng xuất");
            System.out.printf("*  %-96s*\n","13. Thoát chương trình");

            System.out.printf("*  %-96s*\n", "Bạn đã có lựa chọn chưa?");
            System.out.println("*".repeat(100));
            do{
                choice = ScannerUtils.inputInt();
                if (choice < 1 || choice > 13){
                    System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
                }
            }while(choice < 1 || choice > 13);

            switch (choice){
                case 1:
                    super.taoKhoaMoi();
                    break;

                case 2:
                    super.taoLopMoi();
                    break;

                case 3:
                    super.thongKeHocVienTheoChuongTrinh();
                    break;

                case 4:
                    super.thongKeHocVienTheoKhoa();
                    break;

                case 5:
                    super.thongKeHocVienTheoThang();
                    break;

                case 6:
                    super.thongKeHocVienTheoNam();
                    break;

                case 7:
                    super.thongKeDoanhThuTheoChuongTrinh();
                    break;

                case 8:
                    super.thongKeDoanhThuTheoKhoa();
                    break;

                case 9:
                    super.thongKeDoanhThuTheoThang();
                    break;

                case 10:
                    super.thongKeDoanhThuTheoNam();
                    break;

                case 11:
                    thayDoiHocPhi();
                    break;
                case 12:
                    Session.logout();
                    break;
                case 13:
                    exit();
                    break;
            }
        } while (true);
    }

    private void thayDoiHocPhi(){
        QLChuongTrinhHoc.thayDoiHocPhi();
    }

}
