package Menu;


import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.LienHe;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;


public class Menu {
    public static void main(String[] args) {
       LoadDuLieu.loading();
        Menu.giaoDienKhachHang();

    }

    public static void exit(){
        System.out.println("Bạn chuẩn bị thoát chương trình");
        System.out.println("Hẹn gặp lại bạn vào 1 ngày không xa :3");
        LoadDuLieu.saving();
        System.exit(0);
    }



    public static void giaoDienKhachHang() {
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
//                case 3:
//                    QLLop.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
//                    break;
//                case 4:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang));
//                    break;
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
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem lịch dạy của khóa hiện tại");
            System.out.println("2. Xem lịch dạy của khóa sắp khai giảng");
            System.out.println("3. Xem danh sách học sinh của các lớp");
            System.out.println("4. Xem danh sách lịch phổng vấn");
            System.out.println("5. Nhập điểm cho thí sinh phổng vấn");
            System.out.println("6. Nhập điểm cho học viên các lớp");
            System.out.println("7. Đăng xuất");
            System.out.println("8. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 8 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
            }

            switch (choice){


//                case 1:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoGiangVien(Form.getId()), TrangThaiLop.Dang_Hoc));
//                    break;
//                case 2:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoGiangVien(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
//                    break;


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

                    QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.timKiemLichPhongVanTheoGV(QLUser.timUserTheoMa(Form.getTaiKhoan().getUser().getMaUser()).getMaUser()));
                    break;

                case 5:
                    QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.timKiemLichPhongVanTheoGV(QLUser.timUserTheoMa(Form.getTaiKhoan().getUser().getMaUser()).getMaUser()));
                    System.out.println("Hãy chọn buổi phổng vấn bạn muốn nhập điểm (Nhập ID)");
                    System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");

                    String id = ScannerUtils.inputString();

                    if (!id.equals("1")){
                        LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(id);
                        if (lichPhongVan == null){
                            System.out.println("Mã không tồn tại !!!");
                            Menu.giaoDienGiangVien();
                        }
                        else if(!lichPhongVan.getTrangThaiPhongVan().equals(TrangThaiPhongVan.DA_PHONGVAN)){
                            System.out.println("Bạn không thể chấm điểm khi buổi phổng vấn chưa diễn ra !!");
                            Menu.giaoDienGiangVien();
                        }
                        else{
                            System.out.printf("Bạn đã chọn lịch phổng vấn %s \n", lichPhongVan.getMaCaPhongVan());
                            double diem = ScannerUtils.inputDiem();

                            System.out.println("Bạn muốn đe xuất chương trình nào cho khách ?");
                            QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());

                            String maChuongTrinh = ScannerUtils.inputString();
                            ChuongTrinhHoc chuongTrinhHoc = QLChuongTrinhHoc.timKiemTheoMa(maChuongTrinh);
                            if (chuongTrinhHoc == null){
                                System.out.println("Không tìm thấy chương trình !!");
                            }else{
                                KetQuaPhongVan ketQuaPhongVan = new KetQuaPhongVan(lichPhongVan, diem, chuongTrinhHoc);
                                QLKetQuaPhongVan.getDsKetQuaPhongVan().add(ketQuaPhongVan);
                                System.out.println("Đã chấm điểm thành công !!");
                            }
                        }
                    }else{
                        Menu.giaoDienGiangVien();
                    }

                case 7:
                    Form.logout();
                    break;

                case 8:
                    Menu.exit();
                    break;
            }
        } while (true);
    }

    public  static void giaoDienTroGiang(){
        int choice;
        do{
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem lịch dạy của khóa hiện tại");
            System.out.println("2. Xem lịch dạy của khóa sắp khai giảng");
            System.out.println("3. Xem danh sách học sinh của các lớp");
            System.out.println("4. Đăng xuất");
            System.out.println("5. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
            }

            switch (choice){


//                case 1:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
//                    break;
//                case 2:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
//                    break;
//
//                case 3:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
//                    break;

                case 4:
                    Form.logout();
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
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem thời khóa biểu các lớp đang học và sắp khai giảng");
            System.out.println("2. Xem điểm");
            System.out.println("3. Đóng học phí");
            System.out.println("4. Đăng ký khóa học mới");
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 5 trên màn hình");
            }

            switch (choice){
//                case 1:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
//                    break;
//                case 2:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
//                    break;
//
//                case 3:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
//                    break;

                case 5:
                    Form.logout();
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
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Sắp xếp lịch phổng vấn.");
            System.out.println("2. Thay đổi trạng thái lịch phổng vấn ");
            System.out.println("3. Xem danh sách các cuộc phổng vấn đã có kết quả");
            System.out.println("4. Đăng ký khóa học mới");
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
            }

            switch (choice){
                case 1:
                    QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                    System.out.println("Bạn muốn xét thay đổi lịch phổng vấn nào (Nhập ID)");
                    System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");

                    String id = ScannerUtils.inputString();

                    if (id.equals("1")){
                        Menu.giaoDienCongTacVien();
                    }

                    else{
                        LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(id);
                        if (lichPhongVan == null){
                            System.out.println("Mã không tồn tại !!!");
                            Menu.giaoDienCongTacVien();
                        }
                        else{
                            System.out.printf("Bạn đã chọn lịch phổng vấn %s \n", lichPhongVan.getMaCaPhongVan());
                            System.out.println("Hãy chọn giảng viên phù hợp :33");
                            System.out.println("Nếu muốn thoát hãy ấn 1");
                            QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true));
                            String idGV = ScannerUtils.inputString();

                            if (idGV.equals("1")){
                                Menu.giaoDienCongTacVien();
                            }

                            else {
                                User giangVien = QLUser.timUserTheoMa(idGV);
                                if (giangVien == null){
                                    System.out.println("Giang viên không tồn tại !!");
                                    Menu.giaoDienCongTacVien();
                                }
                                else{
                                    lichPhongVan.setGiangVien(giangVien);
                                    System.out.println("Đã thêm giảng vie6n thành công !!");
                                }

                                LocalDate ngayThang = ScannerUtils.inputDate();
                                lichPhongVan.setNgayThang(ngayThang);
                                System.out.println("Đã thêm ngày tháng thành công !!");


                                LocalTime gioHoc = ScannerUtils.inputTime();
                                lichPhongVan.setGioPV(gioHoc);
                                System.out.println("Đã thêm giờ thành công !!");

                                if (lichPhongVan.isValid()){
                                    lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.CHO_PHONGVAN);
                                    System.out.println("Đã duyệt thành công cho mã phổng vấn " + lichPhongVan.getMaCaPhongVan());
                                    QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                                    Menu.giaoDienCongTacVien();
                                }
                            }
                        }
                    }



                    break;
                case 2:
                    QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                    System.out.println("Bạn muốn xét thay đổi lịch phổng vấn nào (Nhập ID)");
                    System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");

                    String idPV = ScannerUtils.inputString();

                    if (idPV.equals("1")){
                        Menu.giaoDienCongTacVien();
                    }

                    else{
                        LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(idPV);
                        if (lichPhongVan == null){
                            System.out.println("Mã không tồn tại !!!");
                            Menu.giaoDienCongTacVien();
                        }
                        else{
                            System.out.printf("Bạn đã chọn lịch phổng vấn %s \n", lichPhongVan.getMaCaPhongVan());
                            System.out.println("Hãy chọn trạng thái bạn muốn thay đổi :33");
                            System.out.println("1. Chờ duyệt");
                            System.out.println("2. Chờ phổng vấn");
                            System.out.println("3. Đã phổng vấn");
                            System.out.println("4. Hủy");
                            System.out.println("Ấn bất cứ nút nào khác để thoát về màn hình chính !!");



                            String case2Choice = ScannerUtils.inputString();

                            if (case2Choice.equals("1")){
                                lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.CHO_DUYET);
                                System.out.println("Đã thay đổi thành công !!");
                                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                            }
                            else if (case2Choice.equals("2")){
                                lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.CHO_PHONGVAN);
                                System.out.println("Đã thay đổi thành công !!");
                                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());

                            }
                            else if (case2Choice.equals("3")){
                                lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.DA_PHONGVAN);
                                System.out.println("Đã thay đổi thành công !!");
                                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());

                            }
                            else if (case2Choice.equals("4")){
                                lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.HUY);
                                System.out.println("Đã thay đổi thành công !!");
                                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                            }
                        }
                    }



                    break;

                case 3:
                    QLKetQuaPhongVan.inDSKetQuaPhongVan(QLKetQuaPhongVan.getDsKetQuaPhongVan());
                    System.out.println("Bạn có muốn thay đổi ca phổng vấn nào ? (Mã ID)");
                    System.out.println("Ấn phím 1 để thoát ra màn hình chính ");

                    String inputCase3 = ScannerUtils.inputString();
                    if (!inputCase3.equals("1")){
                        KetQuaPhongVan ketQuaPhongVan = QLKetQuaPhongVan.timKetQuaPhongVanTheoMa(inputCase3);
                        if (ketQuaPhongVan != null){
                            // Bạn đã thử liên hệ chưa ? Họ nói gì ?
                            System.out.println("1. Đã liên hệ"); //Đã liên hệ và họ muốn ghi danh
                            System.out.println("2. Đã từ chối");
                            System.out.println("Ấn bất cứ số nào khác 2 số trên để thoát !!");
                            int case3choice = ScannerUtils.inputInt();
                            if (case3choice == 1){
                                System.out.println("");
                            }
                            else if (case3choice == 2){
                                ketQuaPhongVan.setLienHe(LienHe.DaTuChoi);
                            }
                        }
                        else{
                            System.out.println("Không tìm thấy mã bạn yêu cầu !!");
                        }
                    }
                    Menu.giaoDienCongTacVien();
                    break;

                case 5:
                    Form.logout();
                    break;

                case 6:
                    Menu.exit();
                    break;
            }
        } while (true);
    }

//    public  static void giaoDienQuanLy(){
//        int choice;
//        do{
//            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
//            System.out.println("1. Xem thời khóa biểu các lớp đang học và sắp khai giảng");
//            System.out.println("2. Xem điểm");
//            System.out.println("3. Đóng học phí");
//            System.out.println("4. Đăng ký khóa học mới");
//            System.out.println("5. Đăng xuất");
//            System.out.println("6. Thoát chương trình");
//            System.out.println("Bạn đã có lựa chọn chưa ?");
//            choice = ScannerUtils.inputInt("Bạn chỉ được nhập các số nguyên là các lựa chọn trên màn hình !!");
//
//            if (choice < 1 || choice > 5 ){
//                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 5 trên màn hình");
//            }
//
//            switch (choice){
//                case 1:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
//                    break;
//                case 2:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
//                    break;
//
//                case 3:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
//                    break;
//
//                case 5:
//                    Form.logout();
//                    break;
//
//                case 6:
//                    Menu.exit();
//                    break;
//            }
//        } while (true);
//    }
//
//    public  static void giaoDienGiamDoc(){
//        int choice;
//        do{
//            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
//            System.out.println("1. Xem thời khóa biểu các lớp đang học và sắp khai giảng");
//            System.out.println("2. Xem điểm");
//            System.out.println("3. Đóng học phí");
//            System.out.println("4. Đăng ký khóa học mới");
//            System.out.println("5. Đăng xuất");
//            System.out.println("6. Thoát chương trình");
//            System.out.println("Bạn đã có lựa chọn chưa ?");
//            choice = ScannerUtils.inputInt("Bạn chỉ được nhập các số nguyên là các lựa chọn trên màn hình !!");
//
//            if (choice < 1 || choice > 5 ){
//                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 5 trên màn hình");
//            }
//
//            switch (choice){
//                case 1:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Dang_Hoc));
//                    break;
//                case 2:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(QLLopHoc.timKiemLopTheoTroGiang(Form.getId()), TrangThaiLop.Sap_Khai_Giang));
//                    break;
//
//                case 3:
//                    QLLopHoc.inDSLopHoc(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc));
//                    break;
//
//                case 5:
//                    Form.logout();
//                    break;
//
//                case 6:
//                    Menu.exit();
//                    break;
//            }
//        } while (true);
//    }
//
//
//
}
