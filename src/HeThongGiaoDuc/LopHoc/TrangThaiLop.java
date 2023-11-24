package HeThongGiaoDuc.LopHoc;

public enum TrangThaiLop {
    Sap_Khai_Giang, Dang_Hoc, Da_Ket_Thuc;
    public String toString(TrangThaiLop trangThaiLop){
        String trangThaiLopString="Sap khai giang";
        switch (trangThaiLop) {
            case Dang_Hoc:
                trangThaiLopString = "Dang hoc";
                break;
            case Da_Ket_Thuc:
                trangThaiLopString = "Da ket thuc";
                break;
        }
        return trangThaiLopString;
    }
    public static TrangThaiLop toTrangThaiLop(String trangThaiLopString){
        TrangThaiLop trangThaiLop=Sap_Khai_Giang;
        switch (trangThaiLopString) {
            case "Dang hoc":
                trangThaiLop=Dang_Hoc;
                break;
            case "Da ket thuc":
                trangThaiLop=Da_Ket_Thuc;
                break;
        }
        return trangThaiLop;
    }
}
