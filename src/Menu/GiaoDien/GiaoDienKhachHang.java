package Menu.GiaoDien;

import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import Menu.Session;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.QLChuongTrinhHoc;
import QuanLyDoiTuong.QLLichPhongVan;
import QuanLyDoiTuong.QLLopHoc;
import QuanLyDoiTuong.QLUser;
import Utils.ScannerUtils;

import java.time.LocalDate;

public class GiaoDienKhachHang extends GiaoDien {
    public void giaoDien() {
        int choice;
        do {
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem danh sách giảng viên");
            System.out.println("2. Xem danh sách chương trình học");
            System.out.println("3. Xem danh sách các lớp đang học");
            System.out.println("4. Xem danh sách các lớp sắp khai giảng");
            System.out.println("5. Đăng ký phổng vấn");
            System.out.println("6. Đăng nhập");
            System.out.println("7. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 7) {
                System.out.println("Bạn chỉ được nhập các lựa chọn trên màn hình");
            }

            switch (choice) {
                case 1:
                    QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true));
                    break;
                case 2:
                    QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
                    break;
                case 3:
                    QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
                    break;
                case 4:
                    QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang));
                    break;
                case 5:
                    dangKyPhongVan();
                    break;
                case 6:
                    Session.login();
                    break;
                case 7:
                    exit();
                    break;
            }
        } while (true);
    }

    public void dangKyPhongVan(){
//        String hoTen = ScannerUtils.inputName();
//        String email = ScannerUtils.inputEmail();
//        boolean gioiTinh = ScannerUtils.inputGioiTinh() ;
//        String sdt = ScannerUtils.inputSDT();
//        String diaChi = ScannerUtils.inputString();
//        System.out.println("Nhập ngày tháng năm sinh: ");
//        LocalDate ngayThang = ScannerUtils.inputDate();
        User khachHang = new User();
        QLUser.getDsUser().add(khachHang);
        LichPhongVan lichPhongVan = new LichPhongVan(khachHang);
        QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);
        System.out.println("Bạn đã đăng ký thành công !!");
        giaoDien();
    }
}
