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
                thuString="Tu";
                break;
            case Nam:
                thuString="Nam";
                break;
            case Sau:
                thuString="Sau";
                break;
            case Bay:
                thuString="Bay";
                break;
            case ChuNhat:
                thuString="ChuNhat";
                break;
        }
        return thuString;
    }
    public int toInt(Thu thuEnum){
        int thuInt=2;
        switch (thuEnum) {
            case Ba:
                thuInt=3;
                break;
            case Tu:
                thuInt=4;
                break;
            case Nam:
                thuInt=5;
                break;
            case Sau:
                thuInt=6;
                break;
            case Bay:
                thuInt=7;
                break;
            case ChuNhat:
                thuInt=8;
                break;
        }
        return thuInt;
    }
    public static Thu toThu(String thuString){
        Thu thuEnum=Hai;
        switch (thuString) {
            case "Ba":
                thuEnum=Ba;
                break;
            case "Tu":
                thuEnum=Tu;
                break;
            case "Nam":
                thuEnum=Nam;
                break;
            case "Sau":
                thuEnum=Sau;
                break;
            case "Bay":
                thuEnum=Bay;
                break;
            case "ChuNhat":
                thuEnum=ChuNhat;
                break;
        }
        return thuEnum;
    }
    public static Thu toThu(int thuInt){
        Thu thuEnum=Hai;
        switch (thuInt) {
            case 3:
                thuEnum=Ba;
                break;
            case 4:
                thuEnum=Tu;
                break;
            case 5:
                thuEnum=Nam;
                break;
            case 6:
                thuEnum=Sau;
                break;
            case 7:
                thuEnum=Bay;
                break;
            case 8:
                thuEnum=ChuNhat;
                break;
        }
        return thuEnum;
    }
}
