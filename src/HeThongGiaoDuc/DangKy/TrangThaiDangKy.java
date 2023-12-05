package HeThongGiaoDuc.DangKy;

public enum TrangThaiDangKy {
    DA_GHI_DANH,
    HUY;

    public static String toString(TrangThaiDangKy trangThaiDangKy){
        String trangThaiDangKyString="Hủy";
        switch (trangThaiDangKy) {
            case DA_GHI_DANH:
                trangThaiDangKyString="Đã ghi danh";
                break;
        }
        return trangThaiDangKyString;
    }
    public static TrangThaiDangKy toTrangThaiDangKy(String trangThaiDangkyString){
        TrangThaiDangKy trangThaiDangKy = HUY;
        switch (trangThaiDangkyString) {
            case "Đã ghi danh":
                trangThaiDangKy = DA_GHI_DANH;
                break;
        }
        return trangThaiDangKy;
    }
}