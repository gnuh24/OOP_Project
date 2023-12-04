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
    public void giaoDien() {
        int choice;
        do {
            System.out.println(
                    "-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem thời khóa biểu các lớp đang học");
            System.out.println("2. Xem thời khóa biểu các lớp sắp khai giảng");
            System.out.println("3. Xem điểm");
            System.out.println("4. Đóng học phí");
            System.out.println("5. Đăng ký lớp học mới");
            System.out.println("6. Đăng xuất");
            System.out.println("7. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Bạn chỉ được nhập các lựa chọn từ 1 -> 7 trên màn hình");
            }

            switch (choice) {
                case 1:
                    QLHocVienLopHoc.xemTKBCacLopDangHoc(Session.getTaiKhoan().getUser());
                    break;
                case 2:
                    QLHocVienLopHoc.xemTKBCacLopSapKhaiGiang(Session.getTaiKhoan().getUser());
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

    private void xemDiem() {
        QLHocVienLopHoc.inDanhSach(QLHocVienLopHoc.timKiemTheoHocVien(Session.getTaiKhoan().getUser().getMaUser()));
    }

    private void dangKyMonHocChoHocVien() {
        ArrayList<LopHoc> dsCacLopCacLopDangHoc = QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Dang_Hoc);
        ArrayList<LopHoc> dsCacLopCacLopSapKhaiGiang = QLLopHoc
                .timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang);

        ArrayList<LopHoc> dsCacLopHocPhuHop = new ArrayList<>(dsCacLopCacLopDangHoc);
        dsCacLopHocPhuHop.addAll(dsCacLopCacLopSapKhaiGiang);

        // Hiển thị cho học viên các lớp học phù hợp
        QLLopHoc.inDanhSach(dsCacLopHocPhuHop);

        System.out.println("Bạn chọn lớp học nào ??");

        String malop = ScannerUtils.inputString();
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);

        while (lopHoc == null) {
            System.out.println("Bạn chỉ được nhập mã lớp đúng với các lớp được đề xuất !!!");
            malop = ScannerUtils.inputString();
            lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
        }

        System.out.println("Bạn có muốn thanh toán luôn học phí ?");
        System.out.println("1. Tôi muốn đóng ");
        System.out.println("2. Tôi chỉ muốn ghi danh");
        System.out.println("Ấn các số còn lại để thoát !!");

        int luaChon = ScannerUtils.inputInt();
        User temp = Session.getTaiKhoan().getUser();
        if (luaChon == 1) {
            int dongTien = ScannerUtils.inputHocPhi();
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
        } else {
            giaoDien();
        }
    }

    public static int soTienConNo(YeuCauDangKy YCDK) {
        int tienNo = YCDK.getTongHocPhi();
        for (BienLai bienLai : QLBienLai.getDsBienLai()) {
            if (bienLai.getYeuCauDangKy().getMaDangKy().equals(YCDK.getMaDangKy())) {
                tienNo -= bienLai.getSoTienDaDong();
            }
        }
        return tienNo;
    }

    private void inSoTienConNo( ArrayList<YeuCauDangKy> cacYCDK) {
        // in ra số tiền còn nợ của từng yêu cầu đăng ký
        System.out.println("*".repeat(100));
        System.out.printf("* %-20s* %-20s* %-25s* %-25s*\n",
                "Mã đăng ký", "Tên lớp học", "Tổng học phí", "Số tiền còn nợ");

        for (YeuCauDangKy YCDK : cacYCDK) {
            // chỉ in ra các YCDK còn nợ học phí
            if (soTienConNo(YCDK) > 0) {
                System.out.printf("* %-20s* %-20s* %-25s* %-25s*\n",
                        YCDK.getMaDangKy(),
                        YCDK.getLopHoc().getTenLop(),
                        YCDK.getTongHocPhi(),
                        soTienConNo(YCDK));
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
        String input = ScannerUtils.inputString();
        YeuCauDangKy YCDK = QLYeuCauDangKy.timKiemTheoMaDangKy(input, cacYCDK);

        while (YCDK == null) {
            System.out.println("Không tìm thấy Yêu cầu đăng ký phù hợp. Vui lòng nhập lại");

            input = ScannerUtils.inputString();
            YCDK = QLYeuCauDangKy.timKiemTheoMaDangKy(input, cacYCDK);
        }

        // bước tiếp theo, đóng học phí
        System.out.print("Nhập số tiền bạn muốn thanh toán (VND): ");
        int tien = ScannerUtils.inputHocPhi();

        // tạo và in biên lai
        BienLai bienLai = new BienLai(YCDK, tien);
        bienLai.inBienLai();
        QLBienLai.getDsBienLai().add(bienLai);

        System.out.println("\nThanh toán thành công!!");
    }

}

