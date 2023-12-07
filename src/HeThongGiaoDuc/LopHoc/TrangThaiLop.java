package HeThongGiaoDuc.LopHoc;

import Utils.ScannerUtils;

public enum TrangThaiLop {
    Sap_Khai_Giang,
    Dang_Hoc,
    Da_Ket_Thuc,
    Cho_Sap_Xep;

    public static String toString(TrangThaiLop trangThaiLopEnum) {
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

    public static TrangThaiLop nhapTrangThaiLop(){
        System.out.println("Bạn chọn trạng thái nào ?");
        System.out.println("1. Sắp khai giảng");
        System.out.println("2. Đang học");
        System.out.println("3. Đã kết thúc");
        System.out.println("4. Đang chờ sắp xếp");
        int choice = ScannerUtils.inputInt();
        while (choice < 1 || choice > 4){
            System.err.println("Bạn có 4 lựa chọn thôi mà ??????");
            choice = ScannerUtils.inputInt();
        }
        switch (choice){
            case 1:
                return Sap_Khai_Giang;
            case 2:
                return Dang_Hoc;
            case 3:
                return Da_Ket_Thuc ;
                case 4:
                    return Cho_Sap_Xep;

        }
        return Cho_Sap_Xep;
    }
}
