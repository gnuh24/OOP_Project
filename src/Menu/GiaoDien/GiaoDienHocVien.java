package Menu.GiaoDien;

import java.util.ArrayList;

import HeThongGiaoDuc.DangKy.BienLai;
import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import Menu.Session;
import NguoiDung.User;
import QuanLyDoiTuong.QLBienLai;
import QuanLyDoiTuong.QLHocVienLopHoc;
import QuanLyDoiTuong.QLLopHoc;
import QuanLyDoiTuong.QLYeuCauDangKy;
import Utils.ScannerUtils;

public class GiaoDienHocVien extends GiaoDien {
    @Override
    public void giaoDien() {
        int choice;
        do {
            System.out.println("*".repeat(100));
            System.out.printf("*%75s%24s\n", "CHÀO MỪNG BẠN ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88", "*");
            System.out.println("*".repeat(100));
            System.out.printf("*   %-95s*\n","1. Xem thời khóa biểu các lớp đang học");
            System.out.printf("*   %-95s*\n","2. Xem thời khóa biểu các lớp sắp khai giảng");
            System.out.printf("*   %-95s*\n","3. Xem điểm");
            System.out.printf("*   %-95s*\n","4. Đóng học phí");
            System.out.printf("*   %-95s*\n","5. Đăng ký lớp học mới");
            System.out.printf("*   %-95s*\n","6. Đăng xuất");
            System.out.printf("*   %-95s*\n","7. Thoát chương trình");
            System.out.printf("*   %-95s*\n","Bạn đã có lựa chọn chưa ?");
            System.out.println("*".repeat(100));

            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 7 trên màn hình");
            }

            switch (choice) {
                case 1:
                    xemThoiKhoaBieuCacLopDangHoc();
                    break;
                case 2:
                    xemThoiKhoaBieuCacLopSapKhaiGiang();
                    break;
                case 3:
                    xemDiem();
                    break;
                case 4:
                    dongHocPhi();
                    break;
                case 5:
                    dangKyMonHocChoHocVien();
                    break;
                case 6:
                    Session.logout();
                    break;
                case 7:
                    exit();
                    break;
            }
        } while (true);
    }

    private void xemThoiKhoaBieuCacLopDangHoc(){
        QLHocVienLopHoc.xemTKBCacLopDangHoc(Session.getTaiKhoan().getUser());
        backTo();
    }

    private void xemThoiKhoaBieuCacLopSapKhaiGiang(){
        QLHocVienLopHoc.xemTKBCacLopSapKhaiGiang(Session.getTaiKhoan().getUser());
        backTo();
    }

    private void xemDiem() {
        QLHocVienLopHoc.inDanhSach(QLHocVienLopHoc.timKiemTheoHocVien(Session.getTaiKhoan().getUser().getMaUser()));
        backTo();
    }

    private void dangKyMonHocChoHocVien() {
        ArrayList<LopHoc> dsCacLopHocPhuHop = QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang, TrangThaiLop.Dang_Hoc);

        // Hiển thị cho học viên các lớp học phù hợp
        QLLopHoc.inDanhSach(dsCacLopHocPhuHop);

        System.out.println("Bạn chọn lớp học nào ??");
        System.out.println("Ấn 1 để thoát !");
        String malop = ScannerUtils.inputString();
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
        if (malop.equals("1")){
            return;
        }

        while (Session.getTaiKhoan().getUser().isBusy(malop) || lopHoc == null){
            if (Session.getTaiKhoan().getUser().isBusy(malop)){
                System.err.println("Bạn không thể đăng ký thêm lớp học mà bạn đang học !!!");
            }else{
                System.err.println("Bạn chỉ được nhập mã lớp đúng với các lớp được đề xuất !!!");
            }
            System.out.println("Ấn 1 để thoát !");
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
        User temp = Session.getTaiKhoan().getUser();
        if (luaChon == 1) {
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
            System.out.println("Đăng ký thành công !!");
        } else if (luaChon == 2) {

            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(temp, lopHoc);
            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLHocVienLopHoc.getDsKetQua().add(new HocVienLopHoc(temp, lopHoc));

            System.out.println("Đăng ký thành công !!");
        }
    }


    private void inSoTienConNo( ArrayList<YeuCauDangKy> cacYCDK) {
        // in ra số tiền còn nợ của từng yêu cầu đăng ký
        System.out.println("*".repeat(100));
        System.out.printf("* %-20s* %-20s* %-25s* %-26s*\n",
                "Mã đăng ký", "Tên lớp học", "Tổng học phí", "Số tiền còn nợ");

        for (YeuCauDangKy YCDK : cacYCDK) {
            // chỉ in ra các YCDK còn nợ học phí
            if (QLBienLai.soTienConNo(YCDK) > 0) {
                System.out.printf("* %-20s* %-20s* %-25.2f* %-26s*\n",
                        YCDK.getMaDangKy(),
                        YCDK.getLopHoc().getTenLop(),
                        YCDK.getTongHocPhi(),
                        QLBienLai.soTienConNo(YCDK));
            }
        }

        System.out.println("*".repeat(100));
    }

    private void dongHocPhi() {
        // xác định học viên này
        User hocVien = Session.getTaiKhoan().getUser();

        // tìm các yêu cầu đăng ký của học viên này
        ArrayList<YeuCauDangKy> cacYCDK = QLYeuCauDangKy.timKiemTheoMaHocVien(hocVien.getMaUser());

        // in ra số tiền còn nợ
        inSoTienConNo(cacYCDK);

        // chọn ycdk muốn đóng
        System.out.println("Bạn muốn thanh toán cho Yêu cầu đăng ký nào? (Nhập mã đăng ký)");
        System.out.println("Ấn phím 1 để thoát");
        String input = ScannerUtils.inputString();
        if (input.equals("1")){
            return;
        }
        YeuCauDangKy YCDK = QLYeuCauDangKy.timKiemTheoMaDangKy(input, cacYCDK);
        while (YCDK == null) {
            System.err.println("Không tìm thấy Yêu cầu đăng ký phù hợp. Vui lòng nhập lại");
            System.out.println("Ấn phím 1 để thoát");
            input = ScannerUtils.inputString();
            YCDK = QLYeuCauDangKy.timKiemTheoMaDangKy(input, cacYCDK);
            if (input.equals("1")){
                return;
            }
        }

        // bước tiếp theo, đóng học phí
        System.out.println("Nhập số tiền bạn muốn thanh toán (VND): ");
        System.out.println("Ấn phím 1 để thoát");
        double tien = ScannerUtils.inputHocPhi();
        if (tien == 1){
            return;
        }

        // tạo và in biên lai
        BienLai bienLai = new BienLai(YCDK, tien);
        bienLai.inBienLai();
        QLBienLai.getDsBienLai().add(bienLai);

        System.out.println("\nThanh toán thành công!!");
    }

}

