package Menu.Actor;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.LopHoc.KetQua;
import HeThongGiaoDuc.LopHoc.LopHoc;
import QuanLyDoiTuong.QLChuongTrinhHoc;
import QuanLyDoiTuong.QLKetQua;
import QuanLyDoiTuong.QLKhoaKhaiGiang;
import QuanLyDoiTuong.QLLopHoc;
import Utils.Convert;
import Utils.ScannerUtils;

public class ActorQuanLy extends ActorCongTacVien{
    public void giaoDien(){

        int choice;
        do{
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI THUG88-----------------------------------------------");
            System.out.println("1. Tạo khóa mới");
            System.out.println("2. Tạo lớp mới");
            System.out.println("3. Thống kê học sinh theo chương trình học");
            System.out.println("4. Thống kê học sinh theo khóa");
            System.out.println("5. Thống kê học sinh theo năm");
            System.out.println("6. Thống kê doanh thu theo chương trình");
            System.out.println("7. Thống kê doanh thu theo khóa");
            System.out.println("8. Thống kê doanh thu theo tháng");
            System.out.println("9. THống kê doanh thu theo năm");
            System.out.println("10. Đăng xuất");
            System.out.println("Bạn đã có lựa chọn chưa?");
            do{
                choice = ScannerUtils.inputInt();
                if (choice < 1 || choice > 11){
                    System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
                }
            }while(choice < 1 || choice > 11);

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
                    break;

                case 5:
                    thongKeHocVienTheoNam();
                    break;

                case 6:
                    
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
                    System.out.println("Bạn thực sự muốn thoát");
                    exit();
                    break;
            }
        } while (true);
    }


}
