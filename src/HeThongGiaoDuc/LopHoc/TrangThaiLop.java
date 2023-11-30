package HeThongGiaoDuc.LopHoc;

public enum TrangThaiLop {
    Sap_Khai_Giang, Dang_Hoc, Da_Ket_Thuc, Cho_Sap_Xep;

    public String toString(TrangThaiLop trangThaiLopEnum) {
        String trangThaiLopString = "Sắp khai giảng";
        switch (trangThaiLopEnum) {
            case Dang_Hoc:
                trangThaiLopString = "Đang học";
                break;
            case Da_Ket_Thuc:
                trangThaiLopString = "Đã kết thúc";
                break;
            case Cho_Sap_Xep:
                trangThaiLopString = "Đang chờ sắp xếp";
        }
        return trangThaiLopString;
    }

    public static TrangThaiLop toTrangThaiLop(String trangThaiLopString) {
        TrangThaiLop trangThaiLop = Sap_Khai_Giang;
        switch (trangThaiLopString) {
            case "Đang học":
                trangThaiLop = Dang_Hoc;
                break;
            case "Đã kết thúc":
                trangThaiLop = Da_Ket_Thuc;
                break;
            case "Đang chờ sắp xếp":
                trangThaiLop = Cho_Sap_Xep;
                break;
        }
        return trangThaiLop;
    }
}
