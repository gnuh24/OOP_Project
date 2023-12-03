package QuanLyDoiTuong;

import HeThongGiaoDuc.DangKy.KhuyenMai;
import HeThongGiaoDuc.DangKy.TrangThaiDangKy;
import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.LopHoc;
import NguoiDung.User;
import Utils.DocGhiFile;

import java.time.LocalDate;
import java.util.ArrayList;

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
            int tongHocPhi = Integer.parseInt(cacThuocTinh[3]);
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
                    .append(yeuCauDangKy.getTrangThaiDangKy()).append("#")
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

    public static ArrayList<YeuCauDangKy> timKiemTheoMaHocVien(String maHocVien) {
        ArrayList<YeuCauDangKy> ketQua = new ArrayList<>();
        for (YeuCauDangKy yeuCauDangKy : QLYeuCauDangKy.getDsYeuCauDangKy()) {
            if (yeuCauDangKy.getHocVien().getMaUser().equals(maHocVien)) {
                ketQua.add(yeuCauDangKy);
            }
        }
        return ketQua;
    }

    public static YeuCauDangKy timKiemTheoMaDangKy(String maDangKy) {
        for (YeuCauDangKy yeuCauDangKy : QLYeuCauDangKy.getDsYeuCauDangKy()) {
            if (yeuCauDangKy.getMaDangKy().equals(maDangKy)) {
                return yeuCauDangKy;
            }
        }

        return null;
    }

    public static YeuCauDangKy timKiemTheoMaDangKy(String maDangKy, ArrayList<YeuCauDangKy> cacYCDK) {
        for (YeuCauDangKy yeuCauDangKy : cacYCDK) {
            if (yeuCauDangKy.getMaDangKy().equals(maDangKy)) {
                return yeuCauDangKy;
            }
        }

        return null;
    }

    public static ArrayList<YeuCauDangKy> timKiemTheoMaLop(String maLop) {
        ArrayList<YeuCauDangKy> ketQua = new ArrayList<>();
        for (YeuCauDangKy yeuCauDangKy : QLYeuCauDangKy.getDsYeuCauDangKy()) {
            if (yeuCauDangKy.getLopHoc().getMaLop().equals(maLop)) {
                ketQua.add(yeuCauDangKy);
            }
        }
        return ketQua;
    }

    public static ArrayList<YeuCauDangKy> timKiemTheoTrangThai(TrangThaiDangKy trangThaiDangKy) {
        ArrayList<YeuCauDangKy> ketQua = new ArrayList<>();
        for (YeuCauDangKy yeuCauDangKy : QLYeuCauDangKy.getDsYeuCauDangKy()) {
            if (yeuCauDangKy.getTrangThaiDangKy().equals(trangThaiDangKy)) {
                ketQua.add(yeuCauDangKy);
            }
        }
        return ketQua;
    }

}
