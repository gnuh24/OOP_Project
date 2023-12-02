package Menu.GiaoDien;

import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.KetQua;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.LienHe;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
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

                    break;
                case 5:
                    //Form.logout();
                    break;

                case 6:
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
//            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(ketQuaPhongVan.getLichPhongVan().getKhachHang(), lopHoc, dongTien);
//            KetQua ketQua = new KetQua(yeuCauDangKy.getHocVien(), yeuCauDangKy.getLopHoc());
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

        if (luaChon == 1){
//            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(ketQuaPhongVan.getLichPhongVan().getKhachHang(), lopHoc, dongTien);
//            KetQua ketQua = new KetQua(yeuCauDangKy.getHocVien(), yeuCauDangKy.getLopHoc());
        }else if(luaChon == 2){
            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(ketQuaPhongVan.getLichPhongVan().getKhachHang(), lopHoc);
            QLKetQua.getDsKetQua().add(new KetQua(yeuCauDangKy.getHocVien(), yeuCauDangKy.getLopHoc()));
            System.out.println("Đăng ký thành công !!");
        }else {
            giaoDien();
        }
    }

    public void dangKyPhongVan(){
        System.out.println("Nhập họ và tên");
        String hoTen = ScannerUtils.inputString();

        System.out.println("Nhập email");
        String email = ScannerUtils.inputEmail();

        System.out.println("Chọn giới tính:");
        System.out.println("1. Nam");
        System.out.println("Các nút còn lại sẽ là nữ");
        boolean gioiTinh ;
        String genderChoice = ScannerUtils.inputString();
        if (genderChoice.equals("1")){
            gioiTinh = true;
        }
        else gioiTinh = false;


        System.out.println("Nhập số điện thoại");
        String sdt = ScannerUtils.inputSDT();

        System.out.println("Nhập địa chỉ");
        String diaChi = ScannerUtils.inputString();

        System.out.println("Nhập ngày tháng năm sinh: ");
        LocalDate ngayThang = ScannerUtils.inputDate();



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

        }

    }
}
