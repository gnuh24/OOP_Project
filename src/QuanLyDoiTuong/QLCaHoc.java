package QuanLyDoiTuong;

import ThoiGian.CaHoc;
import ThoiGian.Gio;
import ThoiGian.Thu;

import java.util.ArrayList;

public class QLCaHoc {
    private static ArrayList<CaHoc> dsCaHoc = new ArrayList<>();

    public static ArrayList<CaHoc> getDsCaHoc() {
        return dsCaHoc;
    }

    public static void setDsCaHoc(ArrayList<CaHoc> dsCaHoc) {
        QLCaHoc.dsCaHoc = dsCaHoc;
    }

    public static void inDSCaHoc(ArrayList<CaHoc> dsCaHoc){
        System.out.println("*********************************************************");
        System.out.printf("* %-10s* %-20s* %-20s*\n", "Thu", "Giờ bắt đầu", "Giờ kết thúc");
        System.out.println("*********************************************************");
        for (CaHoc caHoc: dsCaHoc) {
            System.out.printf("* %-10s* %-20s* %-20s*\n", caHoc.getThu(), caHoc.getGioVaoHoc(), caHoc.getGioTanHoc());
        }
        System.out.println("*********************************************************");
    }

    public static ArrayList<CaHoc> timCaHocTheoThu(Thu thu){
        ArrayList<CaHoc> result = new ArrayList<>();
        for(CaHoc caHoc: QLCaHoc.getDsCaHoc()){
            if (caHoc.getThu().equals(thu)){
                result.add(caHoc);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Tạo đối tượng Gio
        Gio gio1 = new Gio(8, 0);
        Gio gio2 = new Gio(10, 0);
        Gio gio3 = new Gio(13, 30);
        Gio gio4 = new Gio(15, 30);

        // Tạo 10 đối tượng CaHoc và thêm vào danh sách
        dsCaHoc.add(new CaHoc(Thu.Hai, gio1, gio2));
        dsCaHoc.add(new CaHoc(Thu.Ba, gio2, gio3));
        dsCaHoc.add(new CaHoc(Thu.Tu, gio3, gio4));
        dsCaHoc.add(new CaHoc(Thu.Nam, gio4, gio1));
        dsCaHoc.add(new CaHoc(Thu.Sau, gio1, gio2));
        dsCaHoc.add(new CaHoc(Thu.Bay, gio2, gio3));
        dsCaHoc.add(new CaHoc(Thu.Bay, gio3, gio4));
        dsCaHoc.add(new CaHoc(Thu.Hai, gio4, gio1));
        dsCaHoc.add(new CaHoc(Thu.Ba, gio1, gio2));
        dsCaHoc.add(new CaHoc(Thu.Tu, gio2, gio3));


        inDSCaHoc(QLCaHoc.timCaHocTheoThu(Thu.Tu));
    }
}
