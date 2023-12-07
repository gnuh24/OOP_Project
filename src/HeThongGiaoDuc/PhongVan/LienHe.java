package HeThongGiaoDuc.PhongVan;

public enum LienHe {
    ChuaLienHe,
    DaTuChoi,
    LienHeSau,
    DaDangKy;

    public static String toString(LienHe lienHe) {
        if (lienHe.equals(ChuaLienHe)){
            return "Chưa liên hệ";
        }else if(lienHe.equals(DaTuChoi)){
            return "Đã từ chối";
        }else if(lienHe.equals(DaDangKy)){
            return "Đã đăng ký";
        }else {
            return "Liên hệ sau";
        }
    }

    public static LienHe toEnum(String lienHe){
        if (lienHe.equals("Chưa liên hệ")){
            return LienHe.ChuaLienHe;
        } else if(lienHe.equals("Đã từ chối")){
            return LienHe.DaTuChoi;
        }   else if(lienHe.equals("Đã đăng ký")){
            return LienHe.DaDangKy;
        }  else {
            return LienHe.LienHeSau;
        }
    }
}
