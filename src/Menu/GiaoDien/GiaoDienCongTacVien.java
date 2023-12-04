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
            System.out.printf("*  %-96s*\n","8. Sắp xep cho các lớp sắp khai giảng");
            System.out.printf("*  %-96s*\n","9. Đăng xuất");
            System.out.printf("*  %-96s*\n","10. Thoát chương trình");
            System.out.printf("*  %-96s*\n","Bạn đã có lựa chọn chưa ?");
            System.out.println("*".repeat(100));

            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
            }

            switch (choice){
                case 1:
                    sapXepLichPhongVan();
                    break;
                case 2:
                    thayDoiTrangThaiLichPhongVan();
                    break;

                case 3:
                    dieuChinhTrangThaiKetQuaPhongVan();
                    break;

                case 4:
                    dangKyMonHoc();
                    break;
                case 5:
                    taoTaiKhoanMoi();
                    break;

                case 6:
                    QLUser.themUserMoi();
                    break;
                case 7:
                    chuyenLop();
                    break;

                case 8:
                    sapXepLopHoc();
                    break;

                case 9:
                    Session.logout();
                    break;
                case 10:
                    exit();
                    break;
            }
        } while (true);
    }

    private void sapXepLichPhongVan(){
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
        System.out.println("Bạn muốn sắp xếp lịch phổng vấn nào ? (Nhập ID)");
        System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");
        String id = ScannerUtils.inputString();
        if (id.equals("1")){
           return;
        }
        LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(id);

        if (lichPhongVan == null){
            System.out.println("Mã không tồn tại !!!");
        }
        else{
            System.out.printf("Bạn đã chọn lịch phổng vấn %s \n", lichPhongVan.getMaCaPhongVan());

            LocalDate ngayThang = ScannerUtils.inputDate("Nhập ngày phổng vấn. ");
            lichPhongVan.setNgayThang(ngayThang);

            LocalTime gioPhongVan = ScannerUtils.inputTime("Nhập giờ phổng vấn");
            lichPhongVan.setGioPV(gioPhongVan);


            System.out.println("Hãy chọn giảng viên phù hợp :33");
            System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");
            QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true));
            String idGV = ScannerUtils.inputString();

            User giangVien = QLUser.timUserTheoMa(idGV);
            if (giangVien == null){
                System.err.println("Giang viên không tồn tại !!");
                return;
            }else if(giangVien.isBusy(Thu.formDayOfWeekToThu(ngayThang.getDayOfWeek()), gioPhongVan, ngayThang)){
                System.err.println("Giảng viên đang có ca dạy hay phổng vấn khác vào thời điểm đó !!!");
                return;
            }
            else{
                lichPhongVan.setGiangVien(giangVien);
                System.out.println("Đã thêm giảng viên thành công !!");
            }

            if (lichPhongVan.isValid()){
                lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.CHO_PHONGVAN);
                System.out.println("Đã duyệt thành công cho mã phổng vấn " + lichPhongVan.getMaCaPhongVan());
                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
            }else{
                System.err.println("Thêm thất bại !!! Có vấn đề hệ thống xảy ra lúc sắp xếp lịch phổng vấn !!");
            }
        }
    }

    public static void main(String[] args) {
        String title = "Tiêu đề với màu trắng trên nền đen";
        String line = "\u001B[30m" + "=".repeat(title.length() + 10) + "\u001B[0m";

        System.out.println(line);
        System.out.printf("\u001B[30;47m===  %s  ===\u001B[0m%n", title);
        System.out.println(line);
    }

    private void thayDoiTrangThaiLichPhongVan(){
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
        System.out.println("Bạn muốn xét thay đổi lịch phổng vấn nào (Nhập ID)");
        System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");
        String idPV = ScannerUtils.inputString();
        if (idPV.equals("1")){
            return;
        }
            LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(idPV);
            if (lichPhongVan == null){
                System.out.println("Mã không tồn tại !!!");
                thayDoiTrangThaiLichPhongVan();
            }
            else{

                if (lichPhongVan.getTrangThaiPhongVan().equals(TrangThaiPhongVan.HUY)){
                    System.err.println("Không thể thay đổi trạng thái của lịch phổng vấn đã bị hủy trước đó !!!");
                    return;
                }

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
                }
                else if (case2Choice.equals("2")){
                    lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.CHO_PHONGVAN);
                }
                else if (case2Choice.equals("3")){
                    lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.DA_PHONGVAN);
                }
                else if (case2Choice.equals("4")){
                    lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.HUY);
                }
                System.out.println("Đã thay đổi thành công !!");
                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
            }
    }

    private void dieuChinhTrangThaiKetQuaPhongVan(){
        QLKetQuaPhongVan.inDSKetQuaPhongVan(QLKetQuaPhongVan.getDsKetQuaPhongVan());
        System.out.println("Bạn có muốn thay đổi ca phổng vấn nào ? (Mã ID)");
        System.out.println("Ấn phím 1 để thoát ra màn hình chính ");

        String inputCase3 = ScannerUtils.inputString();
        if (inputCase3.equals("1")){
            return;
        }
        KetQuaPhongVan ketQuaPhongVan = QLKetQuaPhongVan.timKetQuaPhongVanTheoMa(inputCase3);
        if (ketQuaPhongVan != null){
                // Bạn đã thử liên hệ chưa ? Họ nói gì ?
                System.out.println("1. Chưa liên hệ"); //Đã liên hệ và họ muốn ghi danh
                System.out.println("2. Đã từ chối");
                System.out.println("3. Đã đăng ký");
                System.out.println("4. Liên hệ sau");

                System.out.println("Ấn bất cứ số nào khác 2 số trên để thoát !!");
                int case3choice = ScannerUtils.inputInt();
                switch (case3choice){
                    case 1:
                        ketQuaPhongVan.setLienHe(LienHe.ChuaLienHe);
                        break;
                    case 2:
                        ketQuaPhongVan.setLienHe(LienHe.DaTuChoi);
                        break;
                    case 3:
                        ketQuaPhongVan.setLienHe(LienHe.DaDangKy);
                        System.out.println("Bạn vừa điều chỉnh trạng thái đăng ký của kết quả phổng vấn thành \"Đã đăng ký\" !!");
                        System.out.println("Bạn có muốn tạo đăng ký cho họ không ?");
                        dangKyMonHocChoKhachHang(ketQuaPhongVan);
                        break;
                    case 4:
                        ketQuaPhongVan.setLienHe(LienHe.LienHeSau);
                        break;
                }
            }
        else{
            System.out.println("Không tìm thấy mã bạn yêu cầu !!");
        }
    }


    private void dangKyMonHoc(){
        System.out.println("Bạn muốn đăng ký môn học cho Học viên cũ hay Khách hàng mới ?");
        System.out.println("1. Học viên cũ");
        System.out.println("2. Khách hàng mới");
        System.out.println("Ấn các số còn lại để thoát !!");
        int case4choice = ScannerUtils.inputInt();
        switch (case4choice){
            case 1:
                dangKyMonHocChoHocVien();
                break;
            case 2:
                System.out.println("Theo quy định của Trung Tâm học viên mới bắt buộc phải thông qua phổng đầu vào để có thể tham gia vào học.");
                System.out.println("1. Đăng ký phổng vấn !!");
                System.out.println("2. Khách hàng mới đã phổng vấn");
                System.out.println("Ấn các số còn lại để thoát !!");
                int choice = ScannerUtils.inputInt();
                switch (choice){
                    case 1:
                        dangKyPhongVan();
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
                        dangKyMonHocChoKhachHang(ketQuaPhongVan);
                        break;

                }
        }
    }


    private void dangKyMonHocChoHocVien(){
        ArrayList<LopHoc> dsCacLopCacLopDangHoc = QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc);
        ArrayList<LopHoc> dsCacLopCacLopSapKhaiGiang = QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang);
        ArrayList<LopHoc> dsCacLopHocPhuHop = new ArrayList<>(dsCacLopCacLopDangHoc);
        QLLopHoc.inDanhSach(dsCacLopHocPhuHop);
        System.out.println("Bạn chọn lớp học nào ??");
        String malop = ScannerUtils.inputString();
        System.out.println("Nhấn 1 để thoát");
        if (malop.equals("1")){
            return;
        }
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
        while (lopHoc == null){
            System.out.println("Bạn chỉ được nhập mã lớp đúng với các lớp được đề xuất !!!");
            malop = ScannerUtils.inputString();
            lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
            System.out.println("Nhấn 1 để thoát");
            if (malop.equals("1")){
                return;
            }
        }

        System.out.println("Bạn có muốn thanh toán luôn học phí ?");
        System.out.println("1. Tôi muốn đóng ");
        System.out.println("2. Tôi chỉ muốn ghi danh");
        System.out.println("Ấn các số còn lại để thoát !!");
        int luaChon = ScannerUtils.inputInt();

        if (luaChon == 1){
            System.out.println("Nếu đóng tiền trọn gói bạn sẽ được giảm 30% học phí");
            System.out.printf("Chỉ phải thanh toán %.2fđ (Học phí gốc: %.2fđ)\n", lopHoc.getChuongTrinh().getHocPhi()*70/100,  lopHoc.getChuongTrinh().getHocPhi());
            System.out.println("Nếu đăng ký sớm thì bạn vẫn sẽ được giảm 15% học phí");
            System.out.printf("Chỉ phải thanh toán %.2fđ (Học phí gốc: %.2fđ)\n", lopHoc.getChuongTrinh().getHocPhi()*85/100,  lopHoc.getChuongTrinh().getHocPhi());

            double dongTien = ScannerUtils.inputHocPhi();
            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(Session.getTaiKhoan().getUser(), lopHoc, dongTien);
            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLHocVienLopHoc.getDsKetQua().add( new HocVienLopHoc(yeuCauDangKy.getHocVien(), yeuCauDangKy.getLopHoc() ) );
            BienLai bienLai = new BienLai(yeuCauDangKy, dongTien);
            bienLai.inBienLai();
            QLBienLai.getDsBienLai().add(bienLai);


        }else if(luaChon == 2){
            QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.HocVien));
            System.out.println("Nhập mã học viên: ");
            String maHV = ScannerUtils.inputString();
            User user = QLUser.timUserTheoMa(maHV);
            System.out.println("Nhấn 1 để thoát");
            if (maHV.equals("1")){
                return;
            }
            while (user == null){
                System.out.println("Không tìm thấy mã học viên !!");
                System.out.println("Xin mời nhập lại !!");
                maHV = ScannerUtils.inputString();
                user = QLUser.timUserTheoMa(maHV);
                System.out.println("Nhấn 1 để thoát");
                if (maHV.equals("1")){
                    return;
                }
            }

            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(user, lopHoc);
            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLHocVienLopHoc.getDsKetQua().add(new HocVienLopHoc(user, yeuCauDangKy.getLopHoc()));
            System.out.println("Đăng ký thành công !!");
        }
    }
    private void dangKyMonHocChoKhachHang(KetQuaPhongVan ketQuaPhongVan){
        ArrayList<LopHoc> dsCacLopCungChuongTrinh = QLLopHoc.timKiemLopTheoChuongTrinh(ketQuaPhongVan.getChuongTrinhHocDeXuat().getMaChuongTrinh());
        ArrayList<LopHoc> dsCacLopCacLopDangHoc = QLLopHoc.timKiemLopTheoTrangThai(dsCacLopCungChuongTrinh, TrangThaiLop.Dang_Hoc);
        ArrayList<LopHoc> dsCacLopCacLopSapKhaiGiang = QLLopHoc.timKiemLopTheoTrangThai(dsCacLopCungChuongTrinh, TrangThaiLop.Sap_Khai_Giang);
        ArrayList<LopHoc> dsCacLopHocPhuHop = new ArrayList<>(dsCacLopCacLopDangHoc);

        dsCacLopHocPhuHop.addAll(dsCacLopCacLopSapKhaiGiang);
        QLLopHoc.inDanhSach(dsCacLopHocPhuHop);
        System.out.println("Bạn chọn lớp học nào ??");
        System.out.println("Nhấn 1 để thoát");
        String malop = ScannerUtils.inputString();
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
        if (malop.equals("1")){
            return;
        }
        while (lopHoc == null){
            System.out.println("Bạn chỉ được nhập mã lớp đúng với các lớp được đề xuất !!!");
            System.out.println("Nhấn 1 để thoát");
            malop = ScannerUtils.inputString();
            lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
            if (malop.equals("1")){
                return;
            }
        }

        System.out.println("Bạn có muốn thanh toán luôn học phí ?");
        System.out.println("1. Tôi muốn đóng ");
        System.out.println("2. Tôi chỉ muốn ghi danh");
        System.out.println("Ấn các số còn lại để thoát !!");

        int luaChon = ScannerUtils.inputInt();
        User user = new User(
                ketQuaPhongVan.getLichPhongVan().getKhachHang().getHoTen(),
                ketQuaPhongVan.getLichPhongVan().getKhachHang().getEmail(),
                ketQuaPhongVan.getLichPhongVan().getKhachHang().isGioiTinh(),
                ketQuaPhongVan.getLichPhongVan().getKhachHang().getNgaySinh(),
                ketQuaPhongVan.getLichPhongVan().getKhachHang().getSoDienThoai(),
                ketQuaPhongVan.getLichPhongVan().getKhachHang().getDiaChi(),
                VaiTro.HocVien);
        QLUser.getDsUser().add(user);
        if (luaChon == 1){
            System.out.println("Nếu đóng tiền trọn gói bạn sẽ được giảm 30% học phí");
            System.out.printf("Chỉ phải thanh toán %.2fđ (Học phí gốc: %.2fđ)\n", lopHoc.getChuongTrinh().getHocPhi()*70/100,  lopHoc.getChuongTrinh().getHocPhi());
            System.out.println("Nếu đăng ký sớm thì bạn vẫn sẽ được giảm 15% học phí");
            System.out.printf("Chỉ phải thanh toán %.2fđ (Học phí gốc: %.2fđ)\n", lopHoc.getChuongTrinh().getHocPhi()*85/100,  lopHoc.getChuongTrinh().getHocPhi());

            double dongTien = ScannerUtils.inputHocPhi();

            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(user, lopHoc, dongTien);
            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLHocVienLopHoc.getDsKetQua().add( new HocVienLopHoc(yeuCauDangKy.getHocVien(), yeuCauDangKy.getLopHoc() ) );
            BienLai bienLai = new BienLai(yeuCauDangKy, dongTien);
            bienLai.inBienLai();
            QLBienLai.getDsBienLai().add(bienLai);
            ketQuaPhongVan.setLienHe(LienHe.DaDangKy);

        }else if(luaChon == 2){
            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(user, lopHoc);
            QLHocVienLopHoc.getDsKetQua().add(new HocVienLopHoc(user, yeuCauDangKy.getLopHoc()));
            System.out.println("Đăng ký thành công !!");
            ketQuaPhongVan.setLienHe(LienHe.DaDangKy);
        }
    }

    public void dangKyPhongVan(){
        String hoTen = ScannerUtils.inputName();
        String email = ScannerUtils.inputEmail();
        boolean gioiTinh = ScannerUtils.inputGioiTinh();
        String sdt = ScannerUtils.inputSDT();
        String diaChi = ScannerUtils.inputDiaChi();
        LocalDate ngayThang = ScannerUtils.inputDate("Nhập ngày tháng năm sinh: ");


        User khachHang = new User(hoTen, email, gioiTinh, ngayThang, sdt, diaChi, VaiTro.KhachHang);
        QLUser.getDsUser().add(khachHang);
        LichPhongVan lichPhongVan = new LichPhongVan(khachHang);
        QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);
        System.out.println("Bạn đã đăng ký thành công !!");
        giaoDien();
    }

    private void taoTaiKhoanMoi(){
        System.out.println("Bạn muốn tạo tài khoản cho đối tượng nào ?");
        System.out.println("1. Những người đã có thông tin trong cơ sở dữ liệu");
        System.out.println("2. Những người chưa có thông tin trong cơ sở dữ liệu");
        System.out.println("Các số còn lại để thoát !!");
        int choice = ScannerUtils.inputInt();
        switch (choice){
            case 1:
                ArrayList<User> dsNguoiChuaCoTaiKhoan = QLUser.timNhungUserChuaCoTaiKhoan();
                QLUser.inThongTin(dsNguoiChuaCoTaiKhoan);
                System.out.println("Đây là những người chưa có tài khoản !!");
                System.out.println("Bạn muốn tạo tài khoản cho ai ??");
                String id = ScannerUtils.inputString();
                User user = QLUser.timUserTheoMa(id, dsNguoiChuaCoTaiKhoan);
                if (user == null){
                    System.out.println("Không tìm thấy mã thông tin của người bạn cần tạo !!");

                }else {
                    QLTaiKhoan.taoTaiKhoanMoi(user);
                }
                break;
            case 2:
                    QLTaiKhoan.taoTaiKhoanMoi(QLUser.themUserMoi());
                break;


        }
        giaoDien();
    }

    private void sapXepLopHoc(){
        QLLopHoc.inDanhSach(QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Cho_Sap_Xep));
        System.out.println("Bạn chọn lớp nào để sắp xếp ?");
        System.out.println("Ấn 1 để trở về giao diện chính.");
        String choice = ScannerUtils.inputString();
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(choice);
        if (choice.equals("1")){
            return;
        }

        if (lopHoc == null){
            System.out.println("Không tìm thấy mã lớp !!!");
            sapXepLopHoc();
        }
        else {

            ArrayList<User> dsGiangVien = QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true);
            ArrayList<User> dsTroGiang = QLUser.timUserTheoVaiTro(VaiTro.TroGiang, true);


            ArrayList<CaHoc> dsCaHoc = new ArrayList<>();
            QLCaHoc.inDanhSach(QLCaHoc.getDsCaHoc());
            System.out.println("Hãy chọn ca học thứ 1 mà bạn muốn ?");
            int choiceCaHoc1 = ScannerUtils.inputInt();
            if (choiceCaHoc1 < 1 || choiceCaHoc1 > QLCaHoc.getDsCaHoc().size()){
                System.out.println("Ca học không hợp lẹ !!");
                sapXepLopHoc();
            }else{
                dsCaHoc.add(QLCaHoc.getDsCaHoc().get(choiceCaHoc1 - 1));
            }

            QLCaHoc.inDanhSach(QLCaHoc.getDsCaHoc());
            System.out.println("Hãy chọn ca học thứ 2 mà bạn muốn ?");
            int choiceCaHoc2 = ScannerUtils.inputInt();
            if (choiceCaHoc2 < 1 || choiceCaHoc2 > QLCaHoc.getDsCaHoc().size()){
                System.out.println("Ca học không hợp lẹ !!");
                sapXepLopHoc();
            }else{
                if (choiceCaHoc2 == choiceCaHoc1){
                    System.out.println("Bạn không được chọn 2 ca học giống nhau !!");
                    sapXepLopHoc();
                }else{
                    dsCaHoc.add(QLCaHoc.getDsCaHoc().get(choiceCaHoc2 - 1));
                }
            }

            lopHoc.setCaHocMacDinh(dsCaHoc);

            QLUser.inThongTin(dsGiangVien);
            System.out.println("Hãy chọn giảng viên phù hợp.");
            System.out.println("Ấn 1 để trở về giao diện chính.");
            String maGV = ScannerUtils.inputString();
            User giangVien = QLUser.timUserTheoMa(maGV, dsGiangVien);
            if (maGV.equals("1")){
                return;
            }

            while (giangVien == null){
                System.err.println("Mã giảng viên không hợp lẹ !!");
                System.out.println("Hãy chọn giảng viên phù hợp.");
                System.out.println("Ấn 1 để trở về giao diện chính.");

                maGV = ScannerUtils.inputString();
                giangVien = QLUser.timUserTheoMa(maGV, dsGiangVien);
                if (maGV.equals("1")){
                    return;
                }
            }

            while (giangVien.isBusy(dsCaHoc.get(0))){
                System.err.printf("Giảng viên bị trùng lịch vào %s !!!\n", dsCaHoc.get(0));
                System.out.println("Hãy chọn giảng viên phù hợp.");
                System.out.println("Ấn 1 để trở về giao diện chính.");
                maGV = ScannerUtils.inputString();
                giangVien = QLUser.timUserTheoMa(maGV, dsGiangVien);
                if (maGV.equals("1")){
                    return;
                }
            }

            while (giangVien.isBusy(dsCaHoc.get(1))) {
                System.err.printf("Giảng viên bị trùng lịch vào %s !!!\n", dsCaHoc.get(1));
                System.out.println("Hãy chọn giảng viên phù hợp.");
                System.out.println("Ấn 1 để trở về giao diện chính.");

                maGV = ScannerUtils.inputString();
                giangVien = QLUser.timUserTheoMa(maGV, dsGiangVien);
                if (maGV.equals("1")){
                    return;
                }
            }

            lopHoc.setGiangVien(giangVien);
            System.out.println("Đã thêm giảng viên thành công !!");

            QLUser.inThongTin(dsTroGiang);
            System.out.println("Hãy chọn trợ giảng phù hợp.");

            String maTG = ScannerUtils.inputString();
            User troGiang = QLUser.timUserTheoMa(maTG, dsTroGiang);
            System.out.println("Ấn 1 để trở về giao diện chính.");
            if (maTG.equals("1")){
                return;
            }

            while (troGiang == null){
                System.err.println("Mã trợ giảng không hợp lẹ !!");
                System.out.println("Hãy chọn trợ giảng phù hợp.");
                maTG = ScannerUtils.inputString();
                troGiang = QLUser.timUserTheoMa(maTG, dsTroGiang);
                System.out.println("Ấn 1 để trở về giao diện chính.");
                if (maTG.equals("1")){
                    return;
                }
            }

            while (troGiang.isBusy(dsCaHoc.get(0))){
                System.err.printf("Trợ giảng bị trùng lịch vào %s !!!\n", dsCaHoc.get(0));
                System.out.println("Hãy chọn trợ giảng phù hợp.");
                maTG = ScannerUtils.inputString();
                troGiang = QLUser.timUserTheoMa(maTG, dsTroGiang);
                System.out.println("Ấn 1 để trở về giao diện chính.");
                if (maTG.equals("1")){
                    return;
                }
            }

            while (troGiang.isBusy(dsCaHoc.get(1))) {
                System.err.printf("Trợ giảng bị trùng lịch vào %s !!!\n", dsCaHoc.get(1));
                System.out.println("Hãy chọn trợ giảng phù hợp.");
                System.out.println("Ấn 1 để trở về giao diện chính.");

                maTG = ScannerUtils.inputString();
                troGiang = QLUser.timUserTheoMa(maTG, dsTroGiang);
                if (maTG.equals("1")){
                    return;
                }
            }

            lopHoc.setTroGiang(troGiang);
            System.out.println("Đã thêm trợ giảng thành công !!");


            QLPhongHoc.inDSPhongHoc(QLPhongHoc.getDsPhongHoc());
            System.out.println("Hãy chọn phòng học phù hợp.");
            String maPhong = ScannerUtils.inputString();
            PhongHoc phongHoc = QLPhongHoc.timKiemTheoMaPhongHoc(maPhong);
            System.out.println("Ấn 1 để trở về giao diện chính.");
            if (maPhong.equals("1")){
                return;
            }

            while (phongHoc == null){
                System.err.println("Phòng học không hợp lệ !!");
                System.out.println("Hãy chọn phòng học phù hợp.");
                System.out.println("Ấn 1 để trở về giao diện chính.");

                maPhong = ScannerUtils.inputString();
                phongHoc = QLPhongHoc.timKiemTheoMaPhongHoc(maPhong);
                if (maPhong.equals("1")){
                    return;
                }
            }

            while (phongHoc.isBusy(lopHoc.getCaHocMacDinh().get(0))){
                System.err.printf("Phòng học này đã có lớp học tại thời điểm %s", lopHoc.getCaHocMacDinh().get(0));
                System.out.println("Hãy chọn phòng học phù hợp.");
                System.out.println("Ấn 1 để trở về giao diện chính.");

                maPhong = ScannerUtils.inputString();
                phongHoc = QLPhongHoc.timKiemTheoMaPhongHoc(maPhong);
                if (maPhong.equals("1")){
                    return;
                }
            }

            while (phongHoc.isBusy(lopHoc.getCaHocMacDinh().get(1))) {
                System.err.printf("Phòng học này đã có lớp học tại thời điểm %s", lopHoc.getCaHocMacDinh().get(1));
                System.out.println("Hãy chọn phòng học phù hợp.");
                System.out.println("Ấn 1 để trở về giao diện chính.");

                maPhong = ScannerUtils.inputString();
                phongHoc = QLPhongHoc.timKiemTheoMaPhongHoc(maPhong);
                if (maPhong.equals("1")) {
                    return;
                }
            }

            lopHoc.setPhongHocMacDinh(phongHoc);
            System.out.println("Đã thêm phòng học thành công !!");

            lopHoc.setTrangThai(TrangThaiLop.Sap_Khai_Giang);
            System.out.println("Đã sắp xếp thành công cho lớp học  !!");
        }
    }

    private void chuyenLop(){
        /*
        * Quy tắc chuyên lớp
        * - Tìm học viên và in ra danh sách KQ của học viên đó (Bao gồm lớp và học viên)
        * - Tìm danh sách các lớp có cùng chương trình
        * - Thay đổi kết quả cũ thành lớp mới đã được chọn
        * - Thay đổi lớp học trong đơn đăng ký thành lớp mới
        * */


        //Tìm học sinh muốn chuyển lớp
        System.out.println("Hãy nhập mã học sinh muốn chuyển lớp !!");
        String maHV = ScannerUtils.inputString();
        ArrayList<HocVienLopHoc>  dsHocVienLopHoc = QLHocVienLopHoc.timKiemTheoHocVien(maHV);
        while (dsHocVienLopHoc.isEmpty()){
            System.out.println("Học viên này chưa tham gia bất cứ lớp nào !!");
            System.out.println("Bạn có nhập nhầm hong ? Nhập lại nhé ^^");
            maHV = ScannerUtils.inputString();
            dsHocVienLopHoc = QLHocVienLopHoc.timKiemTheoHocVien(maHV);
        }


        //In danh sách các lớp học viên đó đang học
        QLHocVienLopHoc.inDanhSach(dsHocVienLopHoc);
        System.out.println("Hãy chọn lớp mà bạn muốn đổi theo thứ tự !!");
        System.out.println("Hãy ấn 0 để thoát !!");
        int sttLopCu = ScannerUtils.inputInt();
        if (sttLopCu == 0){
            return;
        }

        while (sttLopCu < 1 || sttLopCu > dsHocVienLopHoc.size()){
            System.out.println("Số thứ tự không hợp lệ !!");
            System.out.println("Hãy ấn 0 để thoát !!");
            sttLopCu = ScannerUtils.inputInt();
            if (sttLopCu == 0){
                return;
            }
        }
        LopHoc lopHocCu = dsHocVienLopHoc.get(sttLopCu - 1).getLopHoc();

        //Tìm các lớp học cùng trình độ ở trạng thái đang học
        ArrayList<LopHoc> dsLopHocMoiCungTrinhDo = QLLopHoc.timKiemLopTheoChuongTrinh(lopHocCu.getMaLop());
        ArrayList<LopHoc> dsLopHocMoiPhuHop = QLLopHoc.timKiemLopTheoTrangThai(dsLopHocMoiCungTrinhDo, TrangThaiLop.Dang_Hoc);
        QLLopHoc.inDanhSach(dsLopHocMoiPhuHop);

        if (dsLopHocMoiPhuHop.isEmpty()){
            System.out.println("Rất tiếc. Không có lớp học cùng trình độ nào phù hợp !!");
            System.out.println("Hãy trở lại sau.");
            return;
        }

        System.out.println("Hãy chọn lớp học cùng trình độ mà bạn muốn đổi sang !!");
        System.out.println("Ấn 1 để thoát");
        String maLopMoi = ScannerUtils.inputString();
        if (maLopMoi.equals("1")){
            return;
        }
        LopHoc lopHocMoi = QLLopHoc.timKiemLopTheoMaLop(maLopMoi, dsLopHocMoiPhuHop);
        while (lopHocMoi == null ){
            System.out.println("Hãy chọn lớp học cùng trình độ mà bạn muốn đổi sang !!");
            System.out.println("Ấn 1 để thoát");

            maLopMoi = ScannerUtils.inputString();
            lopHocMoi = QLLopHoc.timKiemLopTheoMaLop(maLopMoi, dsLopHocMoiPhuHop);
            if (maLopMoi.equals("1")){
                return;
            }
        }

        while (lopHocMoi.equals(lopHocCu)){
            System.out.println("Bạn không thể chuyển từ lớp học cũ sang lớp học cũ được !!");
            System.out.println("Ấn 1 để thoát");

            maLopMoi = ScannerUtils.inputString();
            lopHocMoi = QLLopHoc.timKiemLopTheoMaLop(maLopMoi, dsLopHocMoiPhuHop);
            if (maLopMoi.equals("1")){
                return;
            }
        }

        //Thay kết quả cũ thành kết quả mới
        dsHocVienLopHoc.get(sttLopCu - 1).setLopHoc(lopHocMoi);


        //Thay đơn đăng ký lớp cu thành đơn đăng ký lớp mới
        QLYeuCauDangKy.timKiemChinhXacTheoHocVienVaLopHoc(maHV, lopHocCu.getMaLop()).setLopHoc(lopHocMoi);

        System.out.println("Chuyển lớp thành công !!!");
    }
}



