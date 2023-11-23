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

    }
}
