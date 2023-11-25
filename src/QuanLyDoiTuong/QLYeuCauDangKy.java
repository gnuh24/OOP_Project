package QuanLyDoiTuong;

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
}
