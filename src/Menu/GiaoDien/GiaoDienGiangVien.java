package Menu.GiaoDien;

import Menu.Session;
import QuanLyDoiTuong.*;
import Utils.ScannerUtils;

public class GiaoDienGiangVien extends GiaoDienTroGiang {

    public void giaoDien() {
        int choice;
        do {
            System.out.println(
                    "-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem lịch dạy của lớp hiện tại");
            System.out.println("2. Xem lịch dạy của lớp sắp khai giảng");
            System.out.println("3. Xem danh sách học sinh của các lớp");
            System.out.println("4. Xem danh sách lịch phổng vấn");
            System.out.println("5. Nhập điểm cho thí sinh phổng vấn");
            System.out.println("6. Nhập điểm cho học viên các lớp");
            System.out.println("7. Đăng xuất");
            System.out.println("8. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 8) {
                System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
            }

            switch (choice) {
                case 1:
                    super.xemDanhSachLopHoc();
                    break;
                case 2:
                    super.xemDanhSachLopSapKhaiGiang();
                    break;

                case 3:
                    super.xemDanhSachHocVien();
                    break;

                case 4:
                    xemLichPhongVan();
                    break;

                case 5:
                    // QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.timKiemLichPhongVanTheoGV(QLUser.timUserTheoMa(Form.getTaiKhoan().getUser().getMaUser()).getMaUser()));
                    // System.out.println("Hãy chọn buổi phổng vấn bạn muốn nhập điểm (Nhập ID)");
                    // System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");
                    //
                    // String id = ScannerUtils.inputString();
                    //
                    // if (!id.equals("1")){
                    // LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(id);
                    // if (lichPhongVan == null){
                    // System.out.println("Mã không tồn tại !!!");
                    // Menu.giaoDienGiangVien();
                    // }
                    // else
                    // if(!lichPhongVan.getTrangThaiPhongVan().equals(TrangThaiPhongVan.DA_PHONGVAN)){
                    // System.out.println("Bạn không thể chấm điểm khi buổi phổng vấn chưa diễn ra
                    // !!");
                    // Menu.giaoDienGiangVien();
                    // }
                    // else{
                    // System.out.printf("Bạn đã chọn lịch phổng vấn %s \n",
                    // lichPhongVan.getMaCaPhongVan());
                    // double diem = ScannerUtils.inputDiem();
                    //
                    // System.out.println("Bạn muốn đe xuất chương trình nào cho khách ?");
                    // QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
                    //
                    // String maChuongTrinh = ScannerUtils.inputString();
                    // ChuongTrinhHoc chuongTrinhHoc =
                    // QLChuongTrinhHoc.timKiemTheoMa(maChuongTrinh);
                    // if (chuongTrinhHoc == null){
                    // System.out.println("Không tìm thấy chương trình !!");
                    // }else{
                    // KetQuaPhongVan ketQuaPhongVan = new KetQuaPhongVan(lichPhongVan, diem,
                    // chuongTrinhHoc);
                    // QLKetQuaPhongVan.getDsKetQuaPhongVan().add(ketQuaPhongVan);
                    // System.out.println("Đã chấm điểm thành công !!");
                    // }
                    // }
                    // }else{
                    // this.giaoDien();;
                    // }
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

    private void xemLichPhongVan() {
        QLLichPhongVan.inDSLichPhongVan(
                QLLichPhongVan.timKiemLichPhongVanTheoGV(Session.getTaiKhoan().getUser().getMaUser()));
    }
}
