package QuanLyDoiTuong;

import HeThongGiaoDuc.DangKy.BienLai;
import HeThongGiaoDuc.DangKy.KhuyenMai;
import HeThongGiaoDuc.DangKy.TrangThaiDangKy;
import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.LopHoc.TrangThaiLop;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LienHe;
import NguoiDung.User;
import NguoiDung.VaiTro;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class QLYeuCauDangKy {
    private static ArrayList<YeuCauDangKy> dsYeuCauDangKy = new ArrayList<>();

    public static ArrayList<YeuCauDangKy> getDsYeuCauDangKy() {
        return dsYeuCauDangKy;
    }

    public static void setDsYeuCauDangKy(ArrayList<YeuCauDangKy> dsYeuCauDangKy) {
        QLYeuCauDangKy.dsYeuCauDangKy = dsYeuCauDangKy;
    }

    public static YeuCauDangKy timKiemTheoMa(String maYCDK) {
        for (YeuCauDangKy yeuCauDangKy : QLYeuCauDangKy.getDsYeuCauDangKy()) {
            if (yeuCauDangKy.getMaDangKy().equals(maYCDK)) {
                return yeuCauDangKy;
            }
        }
        return null;
    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String temp : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = temp.split("#");

            // thiết lập các thuộc tính cho đối tượng

            String maDangKy = cacThuocTinh[0];
            String maUser = cacThuocTinh[1];
            String maLopLop = cacThuocTinh[2];
            double tongHocPhi = Double.parseDouble(cacThuocTinh[3]);
            TrangThaiDangKy trangThaiDangKy = TrangThaiDangKy.toTrangThaiDangKy(cacThuocTinh[4]);
            KhuyenMai khuyenMai = KhuyenMai.toEnum(cacThuocTinh[5]);
            LocalDate localDate = LocalDate.parse(cacThuocTinh[6]);
            User hocVien = QLUser.timUserTheoMa(maUser);
            LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(maLopLop);
            // tạo ra dối tượng và thêm vào
            QLYeuCauDangKy.dsYeuCauDangKy.add(
                    new YeuCauDangKy(maDangKy, hocVien, lopHoc, tongHocPhi, trangThaiDangKy, khuyenMai, localDate));
        }
    }

    public static void loadDuLieu() {
        // sửa đường dẫn này:
        String filePath = "src\\Data\\qlYeuCauDangKy.txt";

        ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong Yeu Cau Dang Ky");
    }

    // xử lý dữ liệu từ đối tượng thành chuỗi để lưu
    public static ArrayList<String> xuLyDuLieuLuu() {
        ArrayList<String> duLieu = new ArrayList<>();

        for (YeuCauDangKy yeuCauDangKy : dsYeuCauDangKy) {
            StringBuilder sb = new StringBuilder();
            sb
                    .append(yeuCauDangKy.getMaDangKy()).append("#")
                    .append(yeuCauDangKy.getHocVien().getMaUser()).append("#")
                    .append(yeuCauDangKy.getLopHoc().getMaLop()).append("#")
                    .append(yeuCauDangKy.getTongHocPhi()).append("#")
                    .append(TrangThaiDangKy.toString(yeuCauDangKy.getTrangThaiDangKy())).append("#")
                    .append(yeuCauDangKy.getKhuyenMai()).append("#")
                    .append(yeuCauDangKy.getLocalDate())
                    .append(System.lineSeparator());

            duLieu.add(sb.toString());
        }

        return duLieu;
    }

    // Hàm save dữ liệu vào file
    public static void luuDuLieu() {
        // sửa đường dẫn này:
        String filePath = "src\\Data\\qlYeuCauDangKy.txt";

        ArrayList<String> duLieu = xuLyDuLieuLuu();
        DocGhiFile.ghiDuLieuFile(filePath, duLieu);
        System.out.println("Đã lưu xong Yeu Cau Dang Ky");
    }

    public static YeuCauDangKy timKiemChinhXacTheoHocVienVaLopHoc(String maHocVien, String maLopHoc){
        for (YeuCauDangKy yeuCauDangKy : QLYeuCauDangKy.getDsYeuCauDangKy()) {
            if (yeuCauDangKy.getHocVien().getMaUser().equals(maHocVien) && yeuCauDangKy.getLopHoc().getMaLop().equals(maLopHoc)) {
                return yeuCauDangKy;
            }
        }
        return null;
    }

    public static ArrayList<YeuCauDangKy> timKiemTheoMaHocVien(String maHocVien) {
        ArrayList<YeuCauDangKy> ketQua = new ArrayList<>();
        for (YeuCauDangKy yeuCauDangKy : QLYeuCauDangKy.getDsYeuCauDangKy()) {
            if (yeuCauDangKy.getHocVien().getMaUser().equals(maHocVien)) {
                ketQua.add(yeuCauDangKy);
            }
        }
        return ketQua;
    }

    public static YeuCauDangKy timKiemTheoMaDangKy(String maDangKy, ArrayList<YeuCauDangKy> cacYCDK) {
        for (YeuCauDangKy yeuCauDangKy : cacYCDK) {
            if (yeuCauDangKy.getMaDangKy().equals(maDangKy)) {
                return yeuCauDangKy;
            }
        }

        return null;
    }

    public static void thongKeTheoNam() {
        ArrayList<YeuCauDangKy> dsYeuCauDangKy = new ArrayList<>(QLYeuCauDangKy.dsYeuCauDangKy);
        dsYeuCauDangKy.sort(Comparator.comparingInt(yeuCau -> yeuCau.getLocalDate().getYear()));
        int demHocVien = 0;
        int tongSoHocVien = 0;
        int nam = getDsYeuCauDangKy().get(0).getLocalDate().getYear();

        System.out.println("*".repeat(47));
        System.out.printf("*  %-20s*  %-20s*\n", "Năm", "Số học viên");
        System.out.println("*".repeat(47));
        int i=0;
        for (YeuCauDangKy yeuCauDangKy : dsYeuCauDangKy) {
            if(yeuCauDangKy.getTrangThaiDangKy()!=TrangThaiDangKy.HUY){
                if (yeuCauDangKy.getLocalDate().getYear() == nam) {
                    demHocVien++;
                    i++;
                } else {
                    System.out.printf("*  %-20s*  %-20s*\n", nam, demHocVien);
                    demHocVien = 1; // Bắt đầu đếm từ một nếu có năm mới
                    nam = yeuCauDangKy.getLocalDate().getYear();
                    i++;
                }
                tongSoHocVien++;
            }
           
            if (i==dsYeuCauDangKy.size()-1) {
                System.out.printf("*  %-20s*  %-20s*\n", nam, demHocVien);
            }

        }

        // In thông tin của năm cuối cùng
        System.out.println("*".repeat(47));
        System.out.printf("*  %-20s*  %-20s*\n","Tổng học viên:",tongSoHocVien);
    }

    public static void thongKeHocVienTheoThang(){
        int []demHocVien=new int[13];
        System.out.println("Nhập năm muốn kiểm tra: ");
        int nam = ScannerUtils.inputInt();
        for(YeuCauDangKy yeuCauDangKy : QLYeuCauDangKy.getDsYeuCauDangKy()){
            if(yeuCauDangKy.getLocalDate().getYear()==nam){
                demHocVien[0]++;
                demHocVien[yeuCauDangKy.getLocalDate().getMonthValue()]++;
            }
        }

        System.out.println("*".repeat(47));
        System.out.printf("*  %-20s*  %-20s*\n","Tháng","Số học viên");
        System.out.println("*".repeat(47));
        for(int i=1; i<demHocVien.length; i++){
            System.out.printf("*  %-20s*  %-20s*\n",i,demHocVien[i]);
        }
        System.out.println("*".repeat(47));
        System.out.printf("*  Tổng số học viên:   *  %-20d*\n", demHocVien[0]);
        System.out.println("*".repeat(47));
    }


    public static void dangKyMonHocChoHocVien(){
        QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.HocVien));
        System.out.println("Nhập mã học viên: ");
        System.out.println("Nhấn 1 để thoát");
        String maHV = ScannerUtils.inputString();
        User hocVien = QLUser.timUserTheoMa(maHV);
        if (maHV.equals("1")){
            return;
        }
        while (hocVien == null){
            System.out.println("Không tìm thấy mã học viên !!");
            System.out.println("Xin mời nhập lại !!");
            System.out.println("Nhấn 1 để thoát");
            maHV = ScannerUtils.inputString();
            hocVien = QLUser.timUserTheoMa(maHV);
            if (maHV.equals("1")){
                return;
            }
        }
        ArrayList<LopHoc> dsCacLopHocPhuHop = QLLopHoc.timKiemLopTheoTrangThai(TrangThaiLop.Sap_Khai_Giang, TrangThaiLop.Dang_Hoc);

        QLLopHoc.inDanhSach(dsCacLopHocPhuHop);
        System.out.println("Bạn chọn lớp học nào ??");
        System.out.println("Nhấn 1 để thoát");
        String malop = ScannerUtils.inputString();
        if (malop.equals("1")){
            return;
        }
        LopHoc lopHoc = QLLopHoc.timKiemLopTheoMaLop(malop, dsCacLopHocPhuHop);
        while (lopHoc == null || hocVien.isBusy(malop)){
            if (hocVien.isBusy(malop)){
                System.err.println("Học viên không thể đăng ký học thêm lớp mới này !! Vì học viên đã tham gia rồi !!");
            }else{
                System.out.println("Bạn chỉ được nhập mã lớp đúng với các lớp được đề xuất !!!");
            }
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

        if (luaChon == 1){
            System.out.println("Nếu đóng tiền trọn gói bạn sẽ được giảm 30% học phí");
            System.out.printf("Chỉ phải thanh toán %.2fđ (Học phí gốc: %.2fđ)\n", lopHoc.getChuongTrinh().getHocPhi()*70/100,  lopHoc.getChuongTrinh().getHocPhi());
            System.out.println("Nếu đăng ký sớm thì bạn vẫn sẽ được giảm 15% học phí");
            System.out.printf("Chỉ phải thanh toán %.2fđ (Học phí gốc: %.2fđ)\n", lopHoc.getChuongTrinh().getHocPhi()*85/100,  lopHoc.getChuongTrinh().getHocPhi());

            double dongTien = ScannerUtils.inputHocPhi();
            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(hocVien, lopHoc, dongTien);
            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLHocVienLopHoc.getDsKetQua().add( new HocVienLopHoc(yeuCauDangKy.getHocVien(), yeuCauDangKy.getLopHoc() ) );
            BienLai bienLai = new BienLai(yeuCauDangKy, dongTien);
            bienLai.inBienLai();
            QLBienLai.getDsBienLai().add(bienLai);
            System.out.println("Đăng ký thành công !!");

        }else if(luaChon == 2){
            YeuCauDangKy yeuCauDangKy = new YeuCauDangKy(hocVien, lopHoc);
            QLYeuCauDangKy.getDsYeuCauDangKy().add(yeuCauDangKy);
            QLHocVienLopHoc.getDsKetQua().add(new HocVienLopHoc(hocVien, yeuCauDangKy.getLopHoc()));
            System.out.println("Đăng ký thành công !!");
        }
    }
    public static void dangKyMonHocChoKhachHang(KetQuaPhongVan ketQuaPhongVan){
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

        public static void dangKyMonHoc(){
        System.out.println("Bạn muốn đăng ký môn học cho Học viên cũ hay Khách hàng mới ?");
        System.out.println("1. Học viên cũ");
        System.out.println("2. Khách hàng mới");
        System.out.println("Ấn các số còn lại để thoát !!");
        int case4choice = ScannerUtils.inputInt();
        switch (case4choice){
            case 1:
                QLYeuCauDangKy.dangKyMonHocChoHocVien();
                break;
            case 2:
                System.out.println("Theo quy định của Trung Tâm học viên mới bắt buộc phải thông qua phổng đầu vào để có thể tham gia vào học.");
                System.out.println("1. Đăng ký phổng vấn !!");
                System.out.println("2. Khách hàng mới đã phổng vấn");
                System.out.println("Ấn các số còn lại để thoát !!");
                int choice = ScannerUtils.inputInt();
                switch (choice){
                    case 1:
                        QLLichPhongVan.dangKyPhongVan();
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
                        QLYeuCauDangKy.dangKyMonHocChoKhachHang(ketQuaPhongVan);
                        break;

                }
        }
    }

}
