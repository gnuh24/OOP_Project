package QuanLyDoiTuong;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.LienHe;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

import java.util.ArrayList;

public class QLKetQuaPhongVan {
    private static ArrayList<KetQuaPhongVan> dsKetQuaPhongVan = new ArrayList<>();

    public static ArrayList<KetQuaPhongVan> getDsKetQuaPhongVan() {
        return dsKetQuaPhongVan;
    }

    public static void setDsKetQuaPhongVan(ArrayList<KetQuaPhongVan> dsKetQuaPhongVan) {
        QLKetQuaPhongVan.dsKetQuaPhongVan = dsKetQuaPhongVan;
    }

    public static void inDSKetQuaPhongVan(ArrayList<KetQuaPhongVan> dsKetQuaPhongVan){
        System.out.println("*".repeat(133));
        System.out.printf("* %-20s* %-30s* %-20s* %-20s* %-20s* %-20s*\n", "Mã ca phổng vấn", "Tên khách hàng", "Số điện thoại","Điểm phổng vấn", "Chương Trình Phù Hợp", "Trạng thái");
        System.out.println("*".repeat(133));
        for (KetQuaPhongVan ketQuaPhongVan: dsKetQuaPhongVan){
            String lienHe = LienHe.toString(ketQuaPhongVan.getLienHe());
            System.out.printf("* %-20s* %-30s* %-20s* %-20s* %-20s* %-20s*\n", ketQuaPhongVan.getLichPhongVan().getMaCaPhongVan(), ketQuaPhongVan.getLichPhongVan().getKhachHang().getHoTen(), ketQuaPhongVan.getLichPhongVan().getKhachHang().getSoDienThoai(), ketQuaPhongVan.getDiem(), ketQuaPhongVan.getChuongTrinhHocDeXuat().getKhoaHoc(), lienHe);
        }
        System.out.println("*".repeat(133));


    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String tam : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = tam.split("#");

            LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(cacThuocTinh[0]);
            double diem = Double.parseDouble(cacThuocTinh[1]);
            ChuongTrinhHoc chuongTrinhHoc = QLChuongTrinhHoc.timKiemTheoMa(cacThuocTinh[2]);


            LienHe lienHe = LienHe.toEnum(cacThuocTinh[3]);

            // tạo ra dối tượng và thêm vào dsKhachHang
            QLKetQuaPhongVan.getDsKetQuaPhongVan().add(new KetQuaPhongVan(lichPhongVan, diem, chuongTrinhHoc, lienHe) );
        }
    }

    public static ArrayList<String> trichXuatDuLieu() {
        ArrayList<String> duLieu = new ArrayList<>();

        for (KetQuaPhongVan ketQuaPhongVan : QLKetQuaPhongVan.getDsKetQuaPhongVan()){

            String lienHe = LienHe.toString(ketQuaPhongVan.getLienHe());

            StringBuilder tam = new StringBuilder();
            tam.append(ketQuaPhongVan.getLichPhongVan().getMaCaPhongVan()).append("#")
                    .append(ketQuaPhongVan.getDiem()).append("#")
                    .append(ketQuaPhongVan.getChuongTrinhHocDeXuat().getMaChuongTrinh()).append("#")
                    .append(lienHe)
                    .append(System.lineSeparator());

            duLieu.add(tam.toString());
        }

        return duLieu;
    }

    // Hàm load dữ liệu từ file
    public static void loadDuLieu() {
        String filePath = "src\\Data\\qlKetQuaPhongVan.txt";
        ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong KẾT QUẢ PHỔNG VẤN");

    }

    // Hàm save dữ liệu vào file
    public static void saveDuLieu() {
        String filePath = "src\\Data\\qlKetQuaPhongVan.txt";
        ArrayList<String> duLieu = trichXuatDuLieu();
        DocGhiFile.ghiDuLieuFile(filePath, duLieu);
        System.out.println("Đã lưu xong KẾT QUẢ PHỔNG VẤN");

    }

    public static KetQuaPhongVan timKetQuaPhongVanTheoMa(String id){
        for (KetQuaPhongVan ketQuaPhongVan: QLKetQuaPhongVan.getDsKetQuaPhongVan()){
            if (ketQuaPhongVan.getLichPhongVan().getMaCaPhongVan().equals(id)){
                return ketQuaPhongVan;
            }
        }
        return null;
    }

    public static void dieuChinhTrangThaiKetQuaPhongVan(){
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

            System.out.println("Ấn bất cứ số nào khác các số trên để thoát !!");
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
                    QLYeuCauDangKy.dangKyMonHocChoKhachHang(ketQuaPhongVan);
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
}
