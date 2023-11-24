package ThoiGian;
public enum Thu {
    Hai, Ba, Tu, Nam, Sau, Bay, ChuNhat;
    public String toString(Thu thuEnum){
        String thuString="Hai";
        switch (thuEnum) {
            case Ba:
                thuString="Ba";
                break;
            case Tu:
                thuString="Tư";
                break;
            case Nam:
                thuString="Năm";
                break;
            case Sau:
                thuString="Sáu";
                break;
            case Bay:
                thuString="Bảy";
                break;
            case ChuNhat:
                thuString="Chủ nhật";
                break;
        }
        return thuString;
    }
    public static Thu toThu(String thuString){
        Thu thuEnum=Hai;
        switch (thuString) {
            case "Ba":
                thuEnum=Ba;
                break;
            case "Tư":
                thuEnum=Tu;
                break;
            case "Năm":
                thuEnum=Nam;
                break;
            case "Sáu":
                thuEnum=Sau;
                break;
            case "Bảy":
                thuEnum=Bay;
                break;
            case "Chủ nhật":
                thuEnum=ChuNhat;
                break;
        }
        return thuEnum;
    }
  
}
