package HeThongGiaoDuc.PhongVan;

public enum TrangThaiPhongVan {
    CHO_DUYET,
    CHO_PHONGVAN,
    DA_PHONGVAN,
    HUY;

    public static String toString(TrangThaiPhongVan trangThaiPhongVan) {
        if (trangThaiPhongVan.equals(CHO_DUYET)){
            return "Chờ duyệt";
        }
        else if(trangThaiPhongVan.equals(CHO_PHONGVAN)){
            return "Chờ phổng vấn";
        }else if (trangThaiPhongVan.equals(DA_PHONGVAN)){
            return "Đã phổng vấn";
        }else {
            return "Hủy";
        }
    }

    public static TrangThaiPhongVan toEnum(String trangThai){
        if (trangThai.equals("Chờ duyệt")){
            return TrangThaiPhongVan.CHO_DUYET;
        }
        else if(trangThai.equals("Chờ phổng vấn")){
            return TrangThaiPhongVan.CHO_PHONGVAN;
        }else if (trangThai.equals("Đã phổng vấn")){
            return TrangThaiPhongVan.DA_PHONGVAN;
        }else {
            return TrangThaiPhongVan.HUY;
        }
    }


}
