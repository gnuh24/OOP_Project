package HeThongGiaoDuc.PhongVan;

public enum LienHe {
    ChuaLienHe,
    DaTuChoi,
    DaLienHe;

    public static String toString(LienHe lienHe) {
        if (lienHe.equals(ChuaLienHe)){
            return "Chưa liên hệ";
        }
        else if(lienHe.equals(DaTuChoi)){
            return "Đã từ chối";
        }else {
            return "Đã liên hệ";
        }
    }

    public static LienHe toEnum(String lienHe){
        if (lienHe.equals("Chưa liên hệ")){
            return LienHe.ChuaLienHe;
        }
        else if(lienHe.equals("Đã từ chối")){
            return LienHe.DaTuChoi;
        }else {
            return LienHe.DaLienHe;
        }
    }
}
