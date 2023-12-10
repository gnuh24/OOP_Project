package ThoiGian;
import java.time.DayOfWeek;

public enum Thu {
    Hai, Ba, Tu, Nam, Sau, Bay, ChuNhat;

    public static String toString(Thu thuEnum) {
        String thuString = "";
        if (thuEnum == null){
            return thuString;
        }else{
            switch (thuEnum) {
                case Hai:
                    thuString = "Hai";
                    break;
                case Ba:
                    thuString = "Ba";
                    break;
                case Tu:
                    thuString = "Tư";
                    break;
                case Nam:
                    thuString = "Năm";
                    break;
                case Sau:
                    thuString = "Sáu";
                    break;
                case Bay:
                    thuString = "Bảy";
                    break;
                case ChuNhat:
                    thuString = "Chủ nhật";
                    break;
            }
        }
        return thuString;
    }

    public static Thu toThu(String thuString) {
        Thu thuEnum = null;
        switch (thuString) {
            case "Hai":
                thuEnum = Hai;
                break;
            case "Ba":
                thuEnum = Ba;
                break;
            case "Tư":
                thuEnum = Tu;
                break;
            case "Năm":
                thuEnum = Nam;
                break;
            case "Sáu":
                thuEnum = Sau;
                break;
            case "Bảy":
                thuEnum = Bay;
                break;
            case "Chủ nhật":
                thuEnum = ChuNhat;
                break;
        }
        return thuEnum;
    }


    public static Thu formDayOfWeekToThu(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return Hai;
            case TUESDAY:
                return Ba;
            case WEDNESDAY:
                return Tu;
            case THURSDAY:
                return Nam;
            case FRIDAY:
                return Sau;
            case SATURDAY:
                return Bay;
            case SUNDAY:
                return ChuNhat;
            default:
                System.err.println("Chuyển thất bại từ DayOfWeek sang Thu");
        }
        return null;
    }

}
