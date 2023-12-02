package Menu.GiaoDien;

import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.LienHe;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.QLKetQuaPhongVan;
import QuanLyDoiTuong.QLLichPhongVan;
import QuanLyDoiTuong.QLLopHoc;
import QuanLyDoiTuong.QLUser;
import Utils.ScannerUtils;
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


    private void dangKyMonHocChoHocVien(){


    }
    private void dangKyMonHocChoKhachHang(KetQuaPhongVan ketQuaPhongVan){
        ArrayList<LopHoc> dsCacLopCungChuongTrinh = QLLopHoc.timKiemLopTheoChuongTrinh(ketQuaPhongVan.getChuongTrinhHocDeXuat().getMaChuongTrinh());
        ArrayList<LopHoc> dsCacLopCacLopDangHoc = QLLopHoc.timKiemLopTheoTrangThai(dsCacLopCungChuongTrinh, TrangThaiLop.Dang_Hoc);
        ArrayList<LopHoc> dsCacLopCacLopSapKhaiGiang = QLLopHoc.timKiemLopTheoTrangThai(dsCacLopCungChuongTrinh, TrangThaiLop.Sap_Khai_Giang);
        ArrayList<LopHoc> dsCacLopHocPhuHop = new ArrayList<>(dsCacLopCacLopDangHoc);
        dsCacLopHocPhuHop.addAll(dsCacLopCacLopSapKhaiGiang);


        QLLopHoc.inDanhSach(dsCacLopHocPhuHop);
        System.out.println("Bạn chọn lớp học nào ??");
        String maLop = ScannerUtils.inputString();
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLop, dsCacLopHocPhuHop);
        while (lopHoc == null){
            System.out.println("Bạn chỉ được nhập mã lớp đúng với các lớp được đề xuất !!!");
            maLop = ScannerUtils.inputString();
        }



        YeuCauDangKy(ketQuaPhongVan.getLichPhongVan().getKhachHang(), );
    }
}
