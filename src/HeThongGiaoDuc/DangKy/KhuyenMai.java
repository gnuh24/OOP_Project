package HeThongGiaoDuc.DangKy;

public enum KhuyenMai {
    TANG_Balo,
    GIAM15_HocPhi,
    GIAM30_HocPhi;

    public static String toString(KhuyenMai khuyenMai){
        if (khuyenMai.equals(TANG_Balo)){
            return "Tặng balo";
        }else if(khuyenMai.equals(GIAM15_HocPhi)){
            return "Giảm 15% học phí";
        }else {
            return "Giảm 30% học phí";
        }
    }

    public static KhuyenMai toEnum(String string){
        if (string.equals("Tặng balo")){
            return KhuyenMai.TANG_Balo;
        }else if(string.equals("Giảm 15% học phí")){
            return GIAM15_HocPhi;
        }else {
            return GIAM30_HocPhi;
        }
    }
}
