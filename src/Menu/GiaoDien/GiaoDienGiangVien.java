package Menu.GiaoDien;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import Menu.Session;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;

import java.util.ArrayList;

public class GiaoDienGiangVien extends GiaoDienTroGiang {

    public void giaoDien() {
        int choice;
        do {
            System.out.println("*".repeat(100));
            System.out.printf("*%75s%24s\n", "CHÀO MỪNG BẠN ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88", "*");
            System.out.println("*".repeat(100));
            System.out.printf("*   %-95s*\n" ,"1. Xem lịch dạy của lớp hiện tại");
            System.out.printf("*   %-95s*\n" ,"2. Xem lịch dạy của lớp sắp khai giảng");
            System.out.printf("*   %-95s*\n" ,"3. Xem danh sách học sinh của các lớp");
            System.out.printf("*   %-95s*\n" ,"4. Xem danh sách lịch phổng vấn");
            System.out.printf("*   %-95s*\n" ,"5. Nhập điểm cho thí sinh phổng vấn");
            System.out.printf("*   %-95s*\n" ,"6. Nhập điểm cho học viên các lớp");
            System.out.printf("*   %-95s*\n" ,"7. Đăng xuất");
            System.out.printf("*   %-95s*\n" ,"8. Thoát chương trình");
            System.out.printf("*   %-95s*\n" ,"Bạn đã có lựa chọn chưa ?");
            System.out.println("*".repeat(100));

            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 8) {
                System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
            }

            switch (choice) {
                case 1:
                    xemDanhSachLopHoc();
                    backTo();
                    break;
                case 2:
                    xemDanhSachLopSapKhaiGiang();
                    backTo();
                    break;

                case 3:
                    super.xemDanhSachHocVien();
                    backTo();
                    break;

                case 4:
                    xemLichPhongVan();
                    backTo();
                    break;

                case 5:
                    nhapDiemChoThiSinhPhongVan();
                    break;

                case 6:
//                    nhapDiemChoHocVienLopHoc();
                    break;
                case 7:
                    Session.logout();
                    break;

                case 8:
                    exit();
                    break;
            }
        } while (true);
    }
@   Override
    protected void xemDanhSachLopHoc() {
        QLLopHoc.inDanhSach(
                QLLopHoc.timKiemLopTheoTrangThai(
                        QLLopHoc.timKiemLopTheoGiangVien(Session.getTaiKhoan().getUser().getMaUser()),
                        TrangThaiLop.Dang_Hoc));
    }

    @Override
    protected void xemDanhSachLopSapKhaiGiang() {
        QLLopHoc.inDanhSach(
                QLLopHoc.timKiemLopTheoTrangThai(
                        QLLopHoc.timKiemLopTheoGiangVien(Session.getTaiKhoan().getUser().getMaUser()),
                        TrangThaiLop.Sap_Khai_Giang)
        );
    }

    private void xemLichPhongVan() {
        QLLichPhongVan.inDSLichPhongVan(
                QLLichPhongVan.timKiemLichPhongVanTheoGV(Session.getTaiKhoan().getUser().getMaUser()));
    }

    private void nhapDiemChoThiSinhPhongVan(){
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.timKiemLichPhongVanTheoGV(
                QLUser.timUserTheoMa(
                        Session.getTaiKhoan().getUser().getMaUser()
                ).getMaUser()
        ));
        System.out.println("Hãy chọn buổi phổng vấn bạn muốn nhập điểm (Nhập ID)");
        System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");

        String id = ScannerUtils.inputString();

        if (id.equals("1")) {
            return;
        }

            LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(id);
            if (lichPhongVan == null) {
                System.err.println("Mã không tồn tại !!!");
            } else if (!lichPhongVan.getTrangThaiPhongVan().equals(TrangThaiPhongVan.DA_PHONGVAN)) {
                System.err.println("Bạn không thể chấm điểm khi buổi phổng vấn chưa diễn ra!!");
            } else {
                System.out.printf("Bạn đã chọn lịch phổng vấn %s \n",
                        lichPhongVan.getMaCaPhongVan());
                double diem = ScannerUtils.inputDiem();

                System.out.println("Bạn muốn đề xuất chương trình nào cho khách ?");
                QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());

                String maChuongTrinh = ScannerUtils.inputString();
                ChuongTrinhHoc chuongTrinhHoc =
                        QLChuongTrinhHoc.timKiemTheoMa(maChuongTrinh);

                if (chuongTrinhHoc == null) {
                    System.out.println("Không tìm thấy chương trình !!");
                } else {
                    KetQuaPhongVan ketQuaPhongVan = new KetQuaPhongVan(lichPhongVan, diem,
                            chuongTrinhHoc);
                    QLKetQuaPhongVan.getDsKetQuaPhongVan().add(ketQuaPhongVan);
                    System.out.println("Đã chấm điểm thành công !!");
                }
            }

    }


//    private void nhapDiemChoHocVienLopHoc() {
//        super.xemDanhSachHocVien();
//        do {
//            System.out.println("Bạn muốn nhập điểm cho học viên nào? (Nhập id):");
//            System.out.println("Nhập -1 để thoát.");
//
//            String id = ScannerUtils.inputString();
//
//            // thoát
//            if (id.equals("-1")) {
//                this.giaoDien();
//                return;
//            }
//            // tiếp tục
//            else {
//                ArrayList<HocVienLopHoc> ketQuaCuaHocVien = QLHocVienLopHoc.timKiemTheoHocVien(id);
//
//                // nếu tìm thấy ketQua ứng với id đã cung cấp
//                if (ketQuaCuaHocVien == null) {
//                    System.out.println("Không tìm thấy!");
//
//
//                }
//
//                // ngược lại nếu không tìm thấy thì in ra thông báo
//                else {
//                    for (HocVienLopHoc ketQua : ketQuaCuaHocVien) {
//                        String tenHocVien = ketQua.getHocVien().getHoTen();
//                        String tenLop = ketQua.getLopHoc().getTenLop();
//
//                        System.out.println("Nhập điểm cho " + tenHocVien + " tại lớp " + tenLop + " (ví dụ: 9.8)");
//                        System.out.println("(Hoặc nhập -1 để thoát / kí tự bất kỳ khác để bỏ qua)");
//
//                        String diem = ScannerUtils.inputString();
//
//                        if (diem.equals("-1")) {
//                            this.giaoDien();
//                            return;
//                        } else if (diem.matches("\\d(.\\d)?")) {
//                            ketQua.setDiem(diem);
//                            System.out.println("Nhập điểm thành công!");
//                        }
//                    }
//                }
//            }
//        } while (true);
//    }
}
