package HeThongGiaoDuc.DangKy;

public enum TrangThaiDangKy {
    DA_GHI_DANH,
    CHUA_GHI_DANH,
    HUY;

    public String toString(TrangThaiDangKy trangThaiDangKy){
        String trangThaiDangKyString="Huy";
        switch (trangThaiDangKy) {
            case DA_GHI_DANH:
                trangThaiDangKyString="Da ghi danh";
                break;
            case CHUA_GHI_DANH:
            trangThaiDangKyString="Chua ghi danh";
                break;
        }
        return trangThaiDangKyString;
    }
    public static TrangThaiDangKy toTrangThaiDangKy(String trangThaiDangkyString){
        TrangThaiDangKy trangThaiDangKy = HUY;
        switch (trangThaiDangkyString) {
            case "Da ghi danh":
                trangThaiDangKy = DA_GHI_DANH;
                break;
            case "Chua ghi danh":
                trangThaiDangKy = CHUA_GHI_DANH;
                break;
        }
        return trangThaiDangKy;
    }
}