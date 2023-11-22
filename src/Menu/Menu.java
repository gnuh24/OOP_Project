package Menu;

import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import QuanLyDoiTuong.QLChuongTrinhHoc;
import QuanLyDoiTuong.QLGiangVien;
import QuanLyDoiTuong.QLLopHoc;
import Utils.ScannerUtils;

public class Menu {
    public static void main(String[] args) {
        LoadDuLieu.loading();
        Menu.giaoDienKhachHang();



    }

    public static void giaoDienKhachHang(){
        int choice;
        do{
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem danh sách giảng viên");
            System.out.println("2. Xem danh sách chương trình học");
            System.out.println("3. Xem danh sách các lớp đang học");
            System.out.println("4. Xem danh sách các lớp sắp khai giảng");
            System.out.println("5. Đăng ký phổng vấn");
            System.out.println("6. Đăng nhập");
            System.out.println("7. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt("Bạn chỉ được nhập các số nguyên là các lựa chọn trên màn hình !!");

            if (choice < 1 || choice > 7 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 7 trên màn hình");
            }

            switch (choice){
                case 1:
                    QLGiangVien.inThongTinGiangVien(QLGiangVien.getDsGiangVien());
                    break;
                case 2:
                    QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
                    break;
                case 3:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
                    break;
                case 4:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang));
                    break;
                case 5:
                    Form.dangKyPhongVan();
                    break;
                case 6:
                    Form.login();
                    break;
                case 7:
                    System.out.println("Bạn chuẩn bị thoát chương trình");
                    System.out.println("Hẹn gặp lại bạn vào 1 ngày không xa :3");
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
