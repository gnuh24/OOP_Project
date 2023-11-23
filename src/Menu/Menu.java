package Menu;

import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;

import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
        LoadDuLieu.loading();
//        Menu.giaoDienGiangVien();
        Menu.giaoDienKhachHang();
    }

    public static void exit(){
        System.out.println("Bạn chuẩn bị thoát chương trình");
        System.out.println("Hẹn gặp lại bạn vào 1 ngày không xa :3");
        LoadDuLieu.saving();
        System.exit(0);
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
                    Menu.exit();
                    break;
            }
        } while (true);
    }

    public  static void giaoDienGiangVien(){
        int choice;
        do{
            System.out.printf("-----------------------------------------------CHÀO MỪNG %s ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------\n", QLGiangVien.timKiemGiangVienTheoMa(Form.getId()).getHoTen());
            System.out.println("1. Xem lịch dạy của khóa hiện tại");
            System.out.println("2. Xem lịch dạy của khóa sắp khai giảng");
            System.out.println("3. Xem danh sách học sinh của các lớp");
            System.out.println("4. Xem danh sách lịch phổng vấn");
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt("Bạn chỉ được nhập các số nguyên là các lựa chọn trên màn hình !!");

            if (choice < 1 || choice > 6 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 6 trên màn hình");
            }

            switch (choice){


                case 1:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoGiangVien(Form.getId()), TrangThaiLop.Dang_Hoc));
                    break;
                case 2:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoGiangVien(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
                    break;


//                case 3:
//                    ArrayList<LopHoc> lopHoc = QLLopHoc.timKiemLopTheoGiangVien(Form.getId());
//
//                    for (int i=1; i< lopHoc.size(); i++){
//                        System.out.printf("%d. %s\n", i, lopHoc.get(i-1).getTenLop(),);
//                    }
//
//                    int case3Choice = ScannerUtils.inputInt("Bạn chỉ được nhập số nguyên !!");
//
//
//
//                    QLHocVienLopHoc.timDSHocVienTheoLopHoc(lopHoc.get(case3Choice - 1).getMaLop());
//                    QLHocVienLopHoc.inDSHocVienTheoLopHoc();
//                    break;

                case 4:
                    QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.timKiemLichPhongVanTheoGV(QLGiangVien.timKiemGiangVienTheoMa(Form.getId()).getMa()));
                    break;


                case 5:
                    Menu.giaoDienKhachHang();
                    break;

                case 6:
                    Menu.exit();
                    break;
            }
        } while (true);
    }

    public  static void giaoDienTroGiang(){
        int choice;
        do{
            System.out.printf("-----------------------------------------------CHÀO MỪNG %s ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------\n", QLTroGiang.timKiemTroGiangTheoMa( (Form.getId() ) ).getHoTen() );
            System.out.println("1. Xem lịch dạy của khóa hiện tại");
            System.out.println("2. Xem lịch dạy của khóa sắp khai giảng");
            System.out.println("3. Xem danh sách học sinh của các lớp");
            System.out.println("4. Đăng xuất");
            System.out.println("5. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt("Bạn chỉ được nhập các số nguyên là các lựa chọn trên màn hình !!");

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 5 trên màn hình");
            }

            switch (choice){


                case 1:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
                    break;
                case 2:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
                    break;

                case 3:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
                    break;

                case 4:
                    Menu.giaoDienKhachHang();
                    break;

                case 5:
                    Menu.exit();
                    break;
            }
        } while (true);
    }

    public  static void giaoDienHocVien(){
        int choice;
        do{
            System.out.printf("-----------------------------------------------CHÀO MỪNG %s ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------\n", Form.getId());
            System.out.println("1. Xem thời khóa biểu các lớp đang học và sắp khai giảng");
            System.out.println("2. Xem điểm");
            System.out.println("3. Đóng học phí");
            System.out.println("4. Đăng ký khóa học mới");
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt("Bạn chỉ được nhập các số nguyên là các lựa chọn trên màn hình !!");

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 5 trên màn hình");
            }

            switch (choice){
                case 1:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
                    break;
                case 2:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
                    break;

                case 3:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
                    break;

                case 5:
                    Menu.giaoDienKhachHang();
                    break;

                case 6:
                    Menu.exit();
                    break;
            }
        } while (true);
    }

    public  static void giaoDienCongTacVien(){
        int choice;
        do{
            System.out.printf("-----------------------------------------------CHÀO MỪNG %s ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------\n", Form.getId());
            System.out.println("1. Xem thời khóa biểu các lớp đang học và sắp khai giảng");
            System.out.println("2. Xem điểm");
            System.out.println("3. Đóng học phí");
            System.out.println("4. Đăng ký khóa học mới");
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt("Bạn chỉ được nhập các số nguyên là các lựa chọn trên màn hình !!");

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 5 trên màn hình");
            }

            switch (choice){
                case 1:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
                    break;
                case 2:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
                    break;

                case 3:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
                    break;

                case 5:
                    Menu.giaoDienKhachHang();
                    break;

                case 6:
                    Menu.exit();
                    break;
            }
        } while (true);
    }

    public  static void giaoDienQuanLy(){
        int choice;
        do{
            System.out.printf("-----------------------------------------------CHÀO MỪNG %s ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------\n", Form.getId());
            System.out.println("1. Xem thời khóa biểu các lớp đang học và sắp khai giảng");
            System.out.println("2. Xem điểm");
            System.out.println("3. Đóng học phí");
            System.out.println("4. Đăng ký khóa học mới");
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt("Bạn chỉ được nhập các số nguyên là các lựa chọn trên màn hình !!");

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 5 trên màn hình");
            }

            switch (choice){
                case 1:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
                    break;
                case 2:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
                    break;

                case 3:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
                    break;

                case 5:
                    Menu.giaoDienKhachHang();
                    break;

                case 6:
                    Menu.exit();
                    break;
            }
        } while (true);
    }

    public  static void giaoDienGiamDoc(){
        int choice;
        do{
            System.out.printf("-----------------------------------------------CHÀO MỪNG %s ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------\n", Form.getId());
            System.out.println("1. Xem thời khóa biểu các lớp đang học và sắp khai giảng");
            System.out.println("2. Xem điểm");
            System.out.println("3. Đóng học phí");
            System.out.println("4. Đăng ký khóa học mới");
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt("Bạn chỉ được nhập các số nguyên là các lựa chọn trên màn hình !!");

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 5 trên màn hình");
            }

            switch (choice){
                case 1:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
                    break;
                case 2:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
                    break;

                case 3:
                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
                    break;

                case 5:
                    Menu.giaoDienKhachHang();
                    break;

                case 6:
                    Menu.exit();
                    break;
            }
        } while (true);
    }



}
