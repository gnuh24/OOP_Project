package Menu.GiaoDien;

import Menu.Session;
import QuanLyDoiTuong.QLBienLai;
import QuanLyDoiTuong.QLHocVienLopHoc;
import QuanLyDoiTuong.QLKhoaKhaiGiang;
import QuanLyDoiTuong.QLLopHoc;
import QuanLyDoiTuong.QLYeuCauDangKy;
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
            System.out.printf("*  %-96s*\n","12. Thoát chương trình");

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
                    taoKhoaMoi();
                    break;

                case 2:
                    taoLopMoi();
                    break;

                case 3:
                    thongKeHocVienTheoChuongTrinh();
                    break;

                case 4:
                    thongKeHocVienTheoKhoa();
                    backTo();
                    break;

                case 5:
                    thongKeHocVienTheoThang();
                    backTo();
                    break;

                case 6:
                    thongKeHocVienTheoNam();
                    backTo();
                    break;

                case 7:
                    thongKeDoanhThuTheoChuongTrinh();
                    backTo();
                    break;

                case 8:
                    thongKeDoanhThuTheoKhoa();
                    backTo();
                    break;

                case 9:
                    thongKeDoanhThuTheoThang();
                    backTo();
                    break;

                case 10:
                    thongKeDoanhThuTheoNam();
                    backTo();
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

    protected void taoKhoaMoi(){
        QLKhoaKhaiGiang.taoKhoaMoi();
    }

    protected void taoLopMoi(){
        QLLopHoc.taoLopMoi();
    }

    protected void thongKeHocVienTheoChuongTrinh(){
        QLHocVienLopHoc.thongKeHocVienTheoChuongTrinh();
        backTo();

    }

    protected void thongKeHocVienTheoKhoa(){
        QLHocVienLopHoc.thongKeHocVienTheoKhoa();
        backTo();

    }

    protected void thongKeHocVienTheoThang(){
        QLYeuCauDangKy.thongKeHocVienTheoThang();
        backTo();

    }

    protected void thongKeHocVienTheoNam(){
        QLYeuCauDangKy.thongKeTheoNam();
        backTo();

    }

    protected void thongKeDoanhThuTheoChuongTrinh(){
        QLBienLai.thongKeDoanhThuTheoChuongTrinh();
        backTo();
    }

    protected void thongKeDoanhThuTheoKhoa(){
        QLBienLai.thongKeDoanhThuTheoKhoa();
        backTo();
    }

    protected void thongKeDoanhThuTheoThang(){
        QLBienLai.thongKeDoanhThuTheoThang();
        backTo();
    }

    protected void thongKeDoanhThuTheoNam(){
        QLBienLai.thongKeTheoNam();
        backTo();
    }

}