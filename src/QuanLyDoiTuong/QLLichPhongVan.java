package QuanLyDoiTuong;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import Menu.Session;
import NguoiDung.User;
import NguoiDung.VaiTro;
import ThoiGian.Thu;
import Utils.Convert;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class QLLichPhongVan {
    private static ArrayList<LichPhongVan> dsLichPhongVan = new ArrayList<>();

    public static ArrayList<LichPhongVan> getDsLichPhongVan() {
        return dsLichPhongVan;
    }

    public static void setDsLichPhongVan(ArrayList<LichPhongVan> dsLichPhongVan) {
        QLLichPhongVan.dsLichPhongVan = dsLichPhongVan;
    }

    public static void loadDuLieu(){
        ArrayList<String> duLieu= DocGhiFile.docDuLieuFile("src\\Data\\qlLichPhongVan.txt");
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong LỊCH PHỔNG VẤN");

    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String dong : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = dong.split("#");



            String maCa = cacThuocTinh[0];

            String maGiangVien = cacThuocTinh[1];
            User giangVien = QLUser.timUserTheoMa(maGiangVien);

            LocalDate ngayThang = null;
            if ( !cacThuocTinh[2].equals("") ){
                ngayThang = Convert.stringToDate(cacThuocTinh[2]);
            }

            LocalTime thoiGian = null;
            if (!cacThuocTinh[3].equals("")){

                thoiGian = Convert.stringToTime(cacThuocTinh[3]);
            }


            String maKhach = cacThuocTinh[4];
            User khachHang = QLUser.timUserTheoMa(maKhach);
            TrangThaiPhongVan trangThai = TrangThaiPhongVan.toEnum(cacThuocTinh[5]);

            LichPhongVan lichPhongVan = new LichPhongVan(maCa, giangVien, ngayThang, thoiGian, khachHang, trangThai);
            QLLichPhongVan.getDsLichPhongVan().add(lichPhongVan);

        }
    }

    public static void saveDuLieu() {
        ArrayList<String> duLieu = xuLyDuLieuDeLuu();
        DocGhiFile.ghiDuLieuFile("src\\Data\\qlLichPhongVan.txt",duLieu);
        System.out.println("Đã lưu xong LỊCH PHỔNG VẤN");

    }
    public static ArrayList<String> xuLyDuLieuDeLuu() {
        // duyệt qua duLieu và bắt đầu xử lý!
        ArrayList<String> duLieu= new ArrayList<>();
        for (LichPhongVan lichPhongVan: QLLichPhongVan.getDsLichPhongVan()) {
            StringBuilder sb = new StringBuilder();
            sb.append(lichPhongVan.getMaCaPhongVan());sb.append("#");

            if (lichPhongVan.getGiangVien() == null){
                sb.append("#");
            }else {
                sb.append(lichPhongVan.getGiangVien().getMaUser());sb.append("#");
            }

            if (lichPhongVan.getNgayThang() == null){
                sb.append("#");
            }else {
                sb.append( Convert.dateToString(lichPhongVan.getNgayThang() ) )
                ;sb.append("#");
            }


            if (lichPhongVan.getGioPV() == null){
                sb.append("#");

            }else {
                sb.append( Convert.timeToString(lichPhongVan.getGioPV()) );sb.append("#");
            }

            sb.append(lichPhongVan.getKhachHang().getMaUser());sb.append("#");

            sb.append(TrangThaiPhongVan.toString(lichPhongVan.getTrangThaiPhongVan()));
            sb.append(System.lineSeparator());
            duLieu.add(sb.toString());
        }
        return duLieu;
    }

    public static void inDSLichPhongVan(ArrayList<LichPhongVan> lichPhongVan){
        System.out.println("*".repeat(128));
        System.out.printf("* %-10s* %-30s* %-30s* %-15s* %-15s* %-15s*\n", "Mã PV", "Tên khách hàng", "Tên người phổng vấn", "Ngày tháng", "Thời gian", "Trạng thái");
        System.out.println("*".repeat(128));
        for (LichPhongVan lichPhongVan1: lichPhongVan){
            String pvMa, pvHoTenGiangVien, pvNgayThang, pvGio, pvHoTenKhachHang, pvTrangThai;
            pvMa = lichPhongVan1.getMaCaPhongVan();

            if (lichPhongVan1.getGiangVien() == null){
                pvHoTenGiangVien = "Chưa cập nhật";
            }else {
                pvHoTenGiangVien = lichPhongVan1.getGiangVien().getHoTen();
            }

            if (lichPhongVan1.getNgayThang() == null){
                pvNgayThang = "Chưa cập nhật";
            }else {
                pvNgayThang = Convert.dateToString( lichPhongVan1.getNgayThang() );
            }

            if (lichPhongVan1.getGioPV() == null){
                pvGio = "Chưa cập nhật";
            } else {
                pvGio = Convert.timeToString(lichPhongVan1.getGioPV());
            }

            pvHoTenKhachHang = lichPhongVan1.getKhachHang().getHoTen();

            pvTrangThai = TrangThaiPhongVan.toString(lichPhongVan1.getTrangThaiPhongVan());

            System.out.printf("* %-10s* %-30s* %-30s* %-15s* %-15s* %-15s*\n",
                    pvMa,
                    pvHoTenKhachHang,
                    pvHoTenGiangVien,
                    pvNgayThang,
                    pvGio,
                    pvTrangThai);
        }
        System.out.println("*".repeat(128));

    }

    public static LichPhongVan timKiemLichPhongVanTheoMa(String idPhongVan){
        LichPhongVan lichPhongVan = null;
        for(LichPhongVan lichPhongVan1: QLLichPhongVan.getDsLichPhongVan()){
            if (lichPhongVan1.getMaCaPhongVan().equals(idPhongVan)){
                return lichPhongVan1;
            }
        }
        return lichPhongVan;
    }
    public static ArrayList<LichPhongVan>  timKiemLichPhongVanTheoGV(String IDgiangVien){
        ArrayList<LichPhongVan> ketQua = new ArrayList<>();

        for(LichPhongVan lichPhongVan: QLLichPhongVan.getDsLichPhongVan()){
            if (lichPhongVan.getGiangVien() != null && lichPhongVan.getGiangVien().getMaUser().equals(IDgiangVien)){
                ketQua.add(lichPhongVan);
            }
        }
        return ketQua;
    }

    public static void sapXepLichPhongVan(){
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
        System.out.println("Bạn muốn sắp xếp lịch phổng vấn nào ? (Nhập ID)");
        System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");
        String id = ScannerUtils.inputString();
        if (id.equals("1")){
            return;
        }
        LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(id);

        while (lichPhongVan == null){
            System.err.println("Mã không tồn tại !!!");
            System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");
            id = ScannerUtils.inputString();
            if (id.equals("1")){
                return;
            }
            lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(id);
        }
            System.out.printf("Bạn đã chọn lịch phổng vấn %s \n", lichPhongVan.getMaCaPhongVan());

            LocalDate ngayThang = ScannerUtils.inputDate("Nhập ngày phổng vấn. ");
            while (ngayThang.isBefore(LocalDate.now())){
                System.err.println("Ngày phổng vấn không được ở trong quá khứ !!");
                ngayThang = ScannerUtils.inputDate("Nhập ngày phổng vấn. ");
            }
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

    public static void thayDoiTrangThaiLichPhongVan(){
        QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
        System.out.println("Bạn muốn xét thay đổi lịch phổng vấn nào (Nhập ID)");
        System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");
        String idPV = ScannerUtils.inputString();
        if (idPV.equals("1")){
            return;
        }
        LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(idPV);
        if (lichPhongVan == null){
            System.err.println("Mã không tồn tại !!!");
            thayDoiTrangThaiLichPhongVan();
        }
        else{

            if (lichPhongVan.getTrangThaiPhongVan().equals(TrangThaiPhongVan.HUY)){
                System.err.println("Không thể thay đổi trạng thái của lịch phổng vấn đã bị hủy trước đó !!!");
                thayDoiTrangThaiLichPhongVan();
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

    public static void dangKyPhongVan(){
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
    }

    public static void nhapDiemChoThiSinhPhongVan(){
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
                System.err.println("Không tìm thấy chương trình !!");
            } else {
                KetQuaPhongVan ketQuaPhongVan = new KetQuaPhongVan(lichPhongVan, diem,
                        chuongTrinhHoc);
                QLKetQuaPhongVan.getDsKetQuaPhongVan().add(ketQuaPhongVan);
                System.out.println("Đã chấm điểm thành công !!");
            }
        }

    }

}
