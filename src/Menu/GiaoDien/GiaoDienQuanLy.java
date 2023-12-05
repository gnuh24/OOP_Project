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
                    //QLKhoaKhaiGiang.taoKhoaMoi();
                    taoKhoaMoi();
                    break;

                case 2:
                    //QLLopHoc.taoLopMoi();
                    taoLopMoi();
                    break;

                case 3:
                    //QLHocVienLopHoc.thongKeHocVienTheoChuongTrinh();
                    thongKeHocVienTheoChuongTrinh();
                    backTo();
                    break;

                case 4:
                    //QLHocVienLopHoc.thongKeHocVienTheoKhoa();
                    thongKeHocVienTheoKhoa();
                    backTo();
                    break;

                case 5:
                    //QLHocVienLopHoc.thongKeHocVienTheoThang();
                    thongKeHocVienTheoThang();
                    backTo();
                    break;

                case 6:
                    //QLHocVienLopHoc.thongKeTheoNam();
                    thongKeHocVienTheoNam();
                    backTo();
                    break;

                case 7:
                    //QLBienLai.thongKeDoanhThuTheoChuongTrinh();
                    thongKeDoanhThuTheoChuongTrinh();
                    backTo();
                    break;

                case 8:
                    //QLBienLai.thongKeDoanhThuTheoKhoa();
                    thongKeDoanhThuTheoKhoa();
                    backTo();
                    break;

                case 9:
                    //QLBienLai.thongKeDoanhThuTheoThang();
                    thongKeDoanhThuTheoThang();
                    backTo();
                    break;

                case 10:
                    //QLBienLai.thongKeTheoNam();
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

    public void taoKhoaMoi(){
        QLKhoaKhaiGiang.taoKhoaMoi();
    }

    public void taoLopMoi(){
        QLLopHoc.taoLopMoi();
    }

    public void thongKeHocVienTheoChuongTrinh(){
        QLHocVienLopHoc.thongKeHocVienTheoChuongTrinh();
    }

    public void thongKeHocVienTheoKhoa(){
        QLHocVienLopHoc.thongKeHocVienTheoKhoa();
    }

    public void thongKeHocVienTheoThang(){
        QLYeuCauDangKy.thongKeHocVienTheoThang();
    }

    public void thongKeHocVienTheoNam(){
        QLYeuCauDangKy.thongKeTheoNam();
    }

    public void thongKeDoanhThuTheoChuongTrinh(){
        QLBienLai.thongKeDoanhThuTheoChuongTrinh();
    }

    public void thongKeDoanhThuTheoKhoa(){
        QLBienLai.thongKeDoanhThuTheoKhoa();
    }

    public void thongKeDoanhThuTheoThang(){
        QLBienLai.thongKeDoanhThuTheoThang();
    }

    public void thongKeDoanhThuTheoNam(){
        QLBienLai.thongKeTheoNam();
    }

}