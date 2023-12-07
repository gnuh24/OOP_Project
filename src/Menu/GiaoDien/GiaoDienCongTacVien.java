package Menu.GiaoDien;

import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import HeThongGiaoDuc.DangKy.BienLai;
import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.LienHe;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import Menu.LoadDuLieu;
import Menu.Session;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.*;
import TaiKhoan.QLTaiKhoan;
import ThoiGian.CaHoc;
import ThoiGian.Thu;
import Utils.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GiaoDienCongTacVien extends GiaoDien {


    @Override
    public  void giaoDien(){
        int choice;
        do{
            System.out.println("*".repeat(100));
            System.out.printf("*%75s%24s\n", "CHÀO MỪNG BẠN ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88", "*");
            System.out.println("*".repeat(100));
            System.out.printf("*  %-96s*\n","1. Sắp xếp lịch phổng vấn.");
            System.out.printf("*  %-96s*\n","2. Thay đổi trạng thái lịch phổng vấn ");
            System.out.printf("*  %-96s*\n","3. Xem danh sách các cuộc phổng vấn đã có kết quả");
            System.out.printf("*  %-96s*\n","4. Đăng ký khóa học mới");
            System.out.printf("*  %-96s*\n","5. Tạo tài khoản mới");
            System.out.printf("*  %-96s*\n","6. Thêm thông tin vào hệ thống");
            System.out.printf("*  %-96s*\n","7. Chuyển lớp cho học sinh");
            System.out.printf("*  %-96s*\n","8. Sắp xếp cho các lớp sắp khai giảng");
            System.out.printf("*  %-96s*\n","9. Thay đổi trạng thái lớp");
            System.out.printf("*  %-96s*\n","10. Quên mật khẩu ?");


            System.out.printf("*  %-96s*\n","11. Đăng xuất");
            System.out.printf("*  %-96s*\n","12. Thoát chương trình");
            System.out.printf("*  %-96s*\n","Bạn đã có lựa chọn chưa ?");
            System.out.println("*".repeat(100));

            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 12 ){
                System.err.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
            }

            switch (choice){
                case 1:
                    QLLichPhongVan.sapXepLichPhongVan();
                    break;
                case 2:
                    QLLichPhongVan.thayDoiTrangThaiLichPhongVan();
                    break;

                case 3:
                    QLKetQuaPhongVan.dieuChinhTrangThaiKetQuaPhongVan();
                    break;

                case 4:
                    dangKyMonHoc();
                    break;
                case 5:
                    QLTaiKhoan.taoTaiKhoanMoi();
                    break;

                case 6:
                    QLUser.themUserMoi();
                    break;
                case 7:
                    QLHocVienLopHoc.chuyenLop();
                    break;

                case 8:
                    QLLopHoc.sapXepLopHoc();
                    break;

                case 9:
                    QLLopHoc.thayDoiTrangThaiLop();
                    break;

                case 10:
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


    private void dangKyMonHoc(){
        System.out.println("Bạn muốn đăng ký môn học cho Học viên cũ hay Khách hàng mới ?");
        System.out.println("1. Học viên cũ");
        System.out.println("2. Khách hàng mới");
        System.out.println("Ấn các số còn lại để thoát !!");
        int case4choice = ScannerUtils.inputInt();
        switch (case4choice){
            case 1:
                QLYeuCauDangKy.dangKyMonHocChoHocVien();
                break;
            case 2:
                System.out.println("Theo quy định của Trung Tâm học viên mới bắt buộc phải thông qua phổng đầu vào để có thể tham gia vào học.");
                System.out.println("1. Đăng ký phổng vấn !!");
                System.out.println("2. Khách hàng mới đã phổng vấn");
                System.out.println("Ấn các số còn lại để thoát !!");
                int choice = ScannerUtils.inputInt();
                switch (choice){
                    case 1:
                        QLLichPhongVan.dangKyPhongVan();
                        break;
                    case 2:
                        QLKetQuaPhongVan.inDSKetQuaPhongVan(QLKetQuaPhongVan.getDsKetQuaPhongVan());
                        System.out.println("Hãy chọn kết quả phổng vấn tương ứng với khách hàng.");
                        String ma = ScannerUtils.inputString();
                        KetQuaPhongVan ketQuaPhongVan = QLKetQuaPhongVan.timKetQuaPhongVanTheoMa(ma);
                        while (ketQuaPhongVan == null){
                            System.out.println("Mã nhập không đúng xin mời nhập lại !!");
                            ma = ScannerUtils.inputString();
                            ketQuaPhongVan = QLKetQuaPhongVan.timKetQuaPhongVanTheoMa(ma);
                        }
                        QLYeuCauDangKy.dangKyMonHocChoKhachHang(ketQuaPhongVan);
                        break;

                }
        }
    }






}



