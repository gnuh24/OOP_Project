package HeThongGiaoDuc.DangKy;

public enum KhuyenMai {

    Qua_Luu_Niem,
    GIAM15_HocPhi,
    GIAM30_HocPhi;

    public static String toString(KhuyenMai khuyenMai){
        if(khuyenMai.equals(Qua_Luu_Niem)){
            return "Quà lưu niệm";
        }else if(khuyenMai.equals(GIAM15_HocPhi)){
            return "Giảm 15% học phí";
        }else {
            return "Giảm 30% học phí";
        }
    }

    public static KhuyenMai toEnum(String string){
        if(string.equals("Quà lưu niệm")){
            return GIAM15_HocPhi;
        } else if(string.equals("Giảm 15% học phí")){
            return GIAM15_HocPhi;
        }else {
            return GIAM30_HocPhi;
        }
    }
}
