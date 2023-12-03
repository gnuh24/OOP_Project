package Menu.GiaoDien;

import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import HeThongGiaoDuc.DangKy.BienLai;
import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.KetQua;
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
import TaiKhoan.TaiKhoan;
import ThoiGian.CaHoc;
import Utils.ScannerUtils;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class GiaoDienCongTacVien extends GiaoDien {

    @Override
    public  void giaoDien(){
        int choice;
        do{
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Sắp xếp lịch phổng vấn.");
            System.out.println("2. Thay đổi trạng thái lịch phổng vấn ");
            System.out.println("3. Xem danh sách các cuộc phổng vấn đã có kết quả");
            System.out.println("4. Đăng ký khóa học mới");
            System.out.println("5. Tạo tài khoản mới");
            System.out.println("6. Thêm thông tin vào hệ thống");
            System.out.println("7. Chuyển lớp cho học sinh");
            System.out.println("8. Sắp xep cho các lớp sắp khai giảng");
            System.out.println("9. Đăng xuất");
            System.out.println("10. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
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
        System.out.println("Bạn muốn xét thay đổi lịch phổng vấn nào (Nhập ID)");
        System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");

        String id = ScannerUtils.inputString();

        if (id.equals("1")){
            giaoDien();
        }

        else{
            LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(id);
            if (lichPhongVan == null){
                System.out.println("Mã không tồn tại !!!");
                giaoDien();
            }
            else{
                System.out.printf("Bạn đã chọn lịch phổng vấn %s \n", lichPhongVan.getMaCaPhongVan());
                System.out.println("Hãy chọn giảng viên phù hợp :33");
                System.out.println("Nếu muốn thoát hãy ấn 1");
                QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true));
                String idGV = ScannerUtils.inputString();

                if (idGV.equals("1")){
                    giaoDien();
                }

                else {
                    User giangVien = QLUser.timUserTheoMa(idGV);
                    if (giangVien == null){
                        System.out.println("Giang viên không tồn tại !!");
                        giaoDien();
                    }
                    else{
                        lichPhongVan.setGiangVien(giangVien);
                        System.out.println("Đã thêm giảng vie6n thành công !!");
                    }

                    LocalDate ngayThang = ScannerUtils.inputDate("Nhập ngày phổng vấn. ");
                    lichPhongVan.setNgayThang(ngayThang);
                    System.out.println("Đã thêm ngày tháng thành công !!");


                    LocalTime gioHoc = ScannerUtils.inputTime();
                    lichPhongVan.setGioPV(gioHoc);
                    System.out.println("Đã thêm giờ thành công !!");

                    if (lichPhongVan.isValid()){
                        lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.CHO_PHONGVAN);
                        System.out.println("Đã duyệt thành công cho mã phổng vấn " + lichPhongVan.getMaCaPhongVan());
                        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                        giaoDien();
                    }
                }
            }
        }
    }

    private void thayDoiTrangThaiLichPhongVan(){
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
        System.out.println("Bạn muốn xét thay đổi lịch phổng vấn nào (Nhập ID)");
        System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");

        String idPV = ScannerUtils.inputString();

        if (idPV.equals("1")){
            giaoDien();
        }

        else{
            LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(idPV);
            if (lichPhongVan == null){
                System.out.println("Mã không tồn tại !!!");
                giaoDien();
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
    }

    private void dieuChinhTrangThaiKetQuaPhongVan(){
        QLKetQuaPhongVan.inDSKetQuaPhongVan(QLKetQuaPhongVan.getDsKetQuaPhongVan());
        System.out.println("Bạn có muốn thay đổi ca phổng vấn nào ? (Mã ID)");
        System.out.println("Ấn phím 1 để thoát ra màn hình chính ");

        String inputCase3 = ScannerUtils.inputString();
        if (!inputCase3.equals("1")){
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
            dieuChinhTrangThaiKetQuaPhongVan();
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
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
        while (lopHoc == null){
            System.out.println("Bạn chỉ được nhập mã lớp đúng với các lớp được đề xuất !!!");
            malop = ScannerUtils.inputString();
            lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
        }

        System.out.println("Bạn có muốn thanh toán luôn học phí ?");
        System.out.println("1. Tôi muốn đóng ");
        System.out.println("2. Tôi chỉ muốn ghi danh");
        System.out.println("Ấn các số còn lại để thoát !!");

        int luaChon = ScannerUtils.inputInt();

        if (luaChon == 1){
            int dongTien = ScannerUtils.inputHocPhi();
            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(Session.getTaiKhoan().getUser(), lopHoc, dongTien);
            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLKetQua.getDsKetQua().add( new KetQua(yeuCauDangKy.getHocVien(), yeuCauDangKy.getLopHoc() ) );
            BienLai bienLai = new BienLai(yeuCauDangKy, dongTien);
            bienLai.inBienLai();
            QLBienLai.getDsBienLai().add(bienLai);

        }else if(luaChon == 2){
            QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.HocVien));
            System.out.println("Nhập mã học viên: ");
            String maHV = ScannerUtils.inputString();
            User user = QLUser.timUserTheoMa(maHV);
            while (user == null){
                System.out.println("Không tìm thấy mã học viên !!");
                System.out.println("Xin mời nhập lại !!");
                maHV = ScannerUtils.inputString();
                user = QLUser.timUserTheoMa(maHV);
            }

            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(user, lopHoc);
            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLKetQua.getDsKetQua().add(new KetQua(user, yeuCauDangKy.getLopHoc()));
            System.out.println("Đăng ký thành công !!");
        }else {
            giaoDien();
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
        String malop = ScannerUtils.inputString();
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
        while (lopHoc == null){
            System.out.println("Bạn chỉ được nhập mã lớp đúng với các lớp được đề xuất !!!");
            malop = ScannerUtils.inputString();
            lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
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
            int dongTien = ScannerUtils.inputHocPhi();

            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(user, lopHoc, dongTien);
            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLKetQua.getDsKetQua().add( new KetQua(yeuCauDangKy.getHocVien(), yeuCauDangKy.getLopHoc() ) );
            BienLai bienLai = new BienLai(yeuCauDangKy, dongTien);
            bienLai.inBienLai();
            QLBienLai.getDsBienLai().add(bienLai);
        }else if(luaChon == 2){
            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(user, lopHoc);
            QLKetQua.getDsKetQua().add(new KetQua(user, yeuCauDangKy.getLopHoc()));
            System.out.println("Đăng ký thành công !!");
        }else {
            giaoDien();
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
        System.out.println(QLLichPhongVan.getDsLichPhongVan());
        System.out.println("Bạn đã đăng ký thành công !!");
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
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
        String choice = ScannerUtils.inputString();
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(choice);
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
            String maGV = ScannerUtils.inputString();
            User giangVien = QLUser.timUserTheoMa(maGV, dsGiangVien);

            while (giangVien == null){
                System.out.println("Mã giảng viên không hợp lẹ !!");
                System.out.println("Hãy chọn giảng viên phù hợp.");
                maGV = ScannerUtils.inputString();
                giangVien = QLUser.timUserTheoMa(maGV, dsGiangVien);
            }

            lopHoc.setGiangVien(giangVien);
            System.out.println("Đã thêm giảng viên thành công !!");



            QLUser.inThongTin(dsTroGiang);
            System.out.println("Hãy chọn trợ giảng phù hợp.");
            String maTG = ScannerUtils.inputString();
            User troGiang = QLUser.timUserTheoMa(maTG, dsTroGiang);

            while (troGiang == null){
                System.out.println("Mã giảng viên không hợp lẹ !!");
                System.out.println("Hãy chọn trợ giảng phù hợp.");
                maTG = ScannerUtils.inputString();
                troGiang = QLUser.timUserTheoMa(maTG, dsTroGiang);
            }

            lopHoc.setTroGiang(troGiang);
            System.out.println("Đã thêm trợ giảng thành công !!");


            QLPhongHoc.inDSPhongHoc(QLPhongHoc.getDsPhongHoc());
            System.out.println("Hãy chọn phòng học phù hợp.");
            String maPhong = ScannerUtils.inputString();
            PhongHoc phongHoc = QLPhongHoc.timKiemTheoMaPhongHoc(maPhong);

            while (phongHoc == null){
                System.out.println("Phòng học không hợp lệ !!");
                System.out.println("Hãy chọn phòng học phù hợp.");
                maPhong = ScannerUtils.inputString();
                phongHoc = QLPhongHoc.timKiemTheoMaPhongHoc(maPhong);
            }

            lopHoc.setPhongHocMacDinh(phongHoc);
            System.out.println("Đã thêm phòng học thành công !!");

            lopHoc.setTrangThai(TrangThaiLop.Sap_Khai_Giang);
            System.out.println("Đã sắp xếp thành công cho lớp học  !!");

        }
        giaoDien();
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
        ArrayList<KetQua>  dsHocVienLopHoc = QLKetQua.timKiemTheoHocVien(maHV);
        while (dsHocVienLopHoc.isEmpty()){
            System.out.println("Học viên này chưa tham gia bất cứ lớp nào !!");
            System.out.println("Bạn có nhập nhầm hong ? Nhập lại nhé ^^");
            maHV = ScannerUtils.inputString();
            dsHocVienLopHoc = QLKetQua.timKiemTheoHocVien(maHV);
        }


        //In danh sách các lớp học viên đó đang học
        QLKetQua.inDanhSach(dsHocVienLopHoc);
        System.out.println("Hãy chọn lớp mà bạn muốn đổi theo thứ tự !!");
        int sttLopCu = ScannerUtils.inputInt();

        while (sttLopCu < 1 || sttLopCu > dsHocVienLopHoc.size()){
            System.out.println("Số thứ tự không hợp lệ !!");
            sttLopCu = ScannerUtils.inputInt();
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
        String maLopMoi = ScannerUtils.inputString();
        LopHoc lopHocMoi = QLLopHoc.timKiemLopTheoMaLop(maLopMoi, dsLopHocMoiPhuHop);
        while (lopHocMoi == null ){
            System.out.println("Hãy chọn lớp học cùng trình độ mà bạn muốn đổi sang !!");
            maLopMoi = ScannerUtils.inputString();
            lopHocMoi = QLLopHoc.timKiemLopTheoMaLop(maLopMoi, dsLopHocMoiPhuHop);
        }

        while (lopHocMoi.equals(lopHocCu)){
            System.out.println("Bạn không thể chuyển từ lớp học cũ sang lớp học cũ được !!");
            maLopMoi = ScannerUtils.inputString();
            lopHocMoi = QLLopHoc.timKiemLopTheoMaLop(maLopMoi, dsLopHocMoiPhuHop);
        }

        //Thay kết quả cũ thành kết quả mới
        dsHocVienLopHoc.get(sttLopCu - 1).setLopHoc(lopHocMoi);


        //Thay đơn đăng ký lớp cu thành đơn đăng ký lớp mới
        QLYeuCauDangKy.timKiemChinhXacTheoHocVienVaLopHoc(maHV, lopHocCu.getMaLop()).setLopHoc(lopHocMoi);

        System.out.println("Chuyển lớp thành công !!!");
        giaoDien();

    }
}



