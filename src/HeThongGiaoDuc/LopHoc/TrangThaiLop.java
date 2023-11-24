package HeThongGiaoDuc.LopHoc;

public enum TrangThaiLop {
    Sap_Khai_Giang, Dang_Hoc, Da_Ket_Thuc;
    public String toString(TrangThaiLop trangThaiLop){
        String trangThaiLopString="Sắp khai giảng";
        switch (trangThaiLop) {
            case Dang_Hoc:
                trangThaiLopString = "Đang học";
                break;
            case Da_Ket_Thuc:
                trangThaiLopString = "Đã kết thúc";
                break;
        }
        return trangThaiLopString;
    }
    public static TrangThaiLop toTrangThaiLop(String trangThaiLopString){
        TrangThaiLop trangThaiLop=Sap_Khai_Giang;
        switch (trangThaiLopString) {
            case "Đang học":
                trangThaiLop=Dang_Hoc;
                break;
            case "Đã kết thúc":
                trangThaiLop=Da_Ket_Thuc;
                break;
        }
        return trangThaiLop;
    }
}
