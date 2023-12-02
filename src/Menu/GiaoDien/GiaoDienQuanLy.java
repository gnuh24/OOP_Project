package Menu.GiaoDien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.LopHoc.KetQua;
import HeThongGiaoDuc.LopHoc.LopHoc;
import QuanLyDoiTuong.QLBienLai;
import QuanLyDoiTuong.QLChuongTrinhHoc;
import QuanLyDoiTuong.QLKetQua;
import QuanLyDoiTuong.QLKhoaKhaiGiang;
import QuanLyDoiTuong.QLLopHoc;
import Utils.Convert;
import Utils.ScannerUtils;

public class GiaoDienQuanLy extends GiaoDienCongTacVien {
    public void giaoDien(){

        int choice;
        do{
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI THUG88-----------------------------------------------");
            System.out.println("1. Tạo khóa mới");
            System.out.println("2. Tạo lớp mới");
            System.out.println("3. Thống kê học sinh theo chương trình học");
            System.out.println("4. Thống kê học sinh theo khóa");
            System.out.println("5. Thống kê học sinh theo tháng trong năm");
            System.out.println("6. Thống kê học sinh theo năm");
            System.out.println("7. Thống kê doanh thu theo chương trình");
            System.out.println("8. Thống kê doanh thu theo khóa");
            System.out.println("9. Thống kê doanh thu theo tháng");
            System.out.println("10. THống kê doanh thu theo năm");
            System.out.println("11. Đăng xuất");
            System.out.println("Bạn đã có lựa chọn chưa?");
            do{
                choice = ScannerUtils.inputInt();
                if (choice < 1 || choice > 11){
                    System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
                }
            }while(choice < 1 || choice > 11);

            switch (choice){
                case 1:
                    QLKhoaKhaiGiang.taoKhoaMoi();
                    break;

                case 2:
                    QLLopHoc.taoLopMoi();
                    break;

                case 3:
                    QLKetQua.thongKeHocVienTheoChuongTrinh();
                    break;

                case 4:
                    QLKetQua.thongKeHocVienTheoKhoa();
                    break;

                case 5:
                    QLKetQua.thongKeHocVienTheoThang();
                    break;

                case 6:
                    QLKetQua.thongKeTheoNam();
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
                    System.out.println("Bạn thực sự muốn thoát");
                    exit();
                    break;
            }
        } while (true);
    }


}