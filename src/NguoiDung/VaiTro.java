package NguoiDung;

public enum VaiTro {
    KhachHang,

    HocVien,

    GiangVien,
    TroGiang,
    CongTacVien,
    QuanLy,
    GiamDoc;

    public static String toString(VaiTro vaiTro){
        if (vaiTro.equals(VaiTro.HocVien)){
            return "Học viên";
        } else if (vaiTro.equals(VaiTro.GiangVien)) {
            return "Giảng viên";
        } else if (vaiTro.equals(VaiTro.TroGiang)) {
            return "Trợ giảng";
        } else if (vaiTro.equals(VaiTro.CongTacVien)) {
            return "Cộng tác viên";
        } else if (vaiTro.equals(VaiTro.QuanLy)) {
            return "Quản lý";
        } else if (vaiTro.equals(VaiTro.GiamDoc)) {
            return "Giám đốc";
        } else {
            return "Khách hàng";
        }
    }

    public static VaiTro toEnum(String vaiTro){
        if (vaiTro.equals("Học viên")){
            return VaiTro.HocVien;
        } else if (vaiTro.equals("Giảng viên")) {
            return  VaiTro.GiangVien;
        } else if (vaiTro.equals("Trợ giảng")) {
            return VaiTro.TroGiang;
        } else if (vaiTro.equals("Cộng tác viên")) {
            return VaiTro.CongTacVien;
        } else if (vaiTro.equals("Quản lý")) {
            return VaiTro.QuanLy;
        } else if (vaiTro.equals("Giám đốc")) {
            return VaiTro.GiamDoc;
        } else {
            return VaiTro.KhachHang;
        }
    }

    public static String toCode(VaiTro vaiTro){
        if (vaiTro.equals(VaiTro.HocVien)){
            return "HV";
        } else if (vaiTro.equals(VaiTro.GiangVien)) {
            return "GV";
        } else if (vaiTro.equals(VaiTro.TroGiang)) {
            return "TG";
        } else if (vaiTro.equals(VaiTro.CongTacVien)) {
            return "CTV";
        } else if (vaiTro.equals(VaiTro.QuanLy)) {
            return "QL";
        } else if (vaiTro.equals(VaiTro.GiamDoc)) {
            return "GD";
        } else {
            return "KH";
        }
    }


}
