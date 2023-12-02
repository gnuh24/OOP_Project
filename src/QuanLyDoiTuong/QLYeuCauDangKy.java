package QuanLyDoiTuong;

import HeThongGiaoDuc.DangKy.TrangThaiDangKy;
import HeThongGiaoDuc.DangKy.YeuCauDangKy;

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

    public static ArrayList<YeuCauDangKy> timKiemTheoMaHocVien(String maHocVien) {
        ArrayList<YeuCauDangKy> ketQua = new ArrayList<>();
        for (YeuCauDangKy yeuCauDangKy : QLYeuCauDangKy.getDsYeuCauDangKy()) {
            if (yeuCauDangKy.getHocVien().getMaUser().equals(maHocVien)) {
                ketQua.add(yeuCauDangKy);
            }
        }
        return ketQua;
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
