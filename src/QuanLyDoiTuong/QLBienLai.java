package QuanLyDoiTuong;

import java.time.LocalDateTime;
import java.util.ArrayList;

import HeThongGiaoDuc.DangKy.BienLai;

public class QLBienLai {
    public static ArrayList<BienLai> dsBienLai = new ArrayList<BienLai>();



    public static ArrayList<BienLai> getDsBienLai() {
        return dsBienLai;
    }

    public static void setDsBienLai(ArrayList<BienLai> dsBienLai) {
        QLBienLai.dsBienLai = dsBienLai;
    }

    public static ArrayList<BienLai> timKiemTheoNgay(LocalDateTime ngay){
        ArrayList<BienLai> dsBienLais = new ArrayList<BienLai>();
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if(bienLai.getNgayThanhToan().equals(ngay)){
                dsBienLais.add(bienLai);
            }
            else if((bienLai.getNgayThanhToan().getYear()==ngay.getYear())
            &&bienLai.getNgayThanhToan().getMonthValue()==ngay.getMonthValue()
            &&bienLai.getNgayThanhToan().getDayOfMonth()==ngay.getDayOfMonth()){
                dsBienLais.add(bienLai);
            }
        }
        return dsBienLais;
    }
    
    public static ArrayList<BienLai> timKiemTheoMaKhoa(String maKhoa){
        ArrayList<BienLai> dsBienLais = new ArrayList<BienLai>();
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getYeuCauDangKy().getLopHoc().getKhoa().getMaKhoa().equals(maKhoa)) {
                dsBienLais.add(bienLai);
            }
        }
        return dsBienLais;
    }

    public static ArrayList<BienLai> timKiemTheoChuongTrinh(String maChuongTrinh){
        ArrayList<BienLai> dsBienLais = new ArrayList<BienLai>();
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getYeuCauDangKy().getLopHoc().getChuongTrinh().getMaChuongTrinh().equals(maChuongTrinh)) {
                dsBienLais.add(bienLai);
            }
        }
        return dsBienLais;
    }


    public static BienLai timKiemTheoMaBienLai(String maBienLai){
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if(bienLai.getMaBienLai().equals(maBienLai))
                return bienLai;
        }
        System.out.println("Không tìm thấy mã biên lai");
        return null;
    }

    public static void thongKeDoanhThuTheoChuongTrinh(){
        int []tongDoanhThu=new int[18];
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            tongDoanhThu[0]+=bienLai.getSoTienDaDong();
            switch (bienLai.getYeuCauDangKy().getLopHoc().getChuongTrinh().getMaChuongTrinh()) {
                case "CTH001":  tongDoanhThu[1]+=bienLai.getSoTienDaDong(); break;
                case "CTH002":  tongDoanhThu[2]+=bienLai.getSoTienDaDong(); break;
                case "CTH003":  tongDoanhThu[3]+=bienLai.getSoTienDaDong(); break;
                case "CTH004":  tongDoanhThu[4]+=bienLai.getSoTienDaDong(); break;
                case "CTH005":  tongDoanhThu[5]+=bienLai.getSoTienDaDong(); break;
                case "CTH006":  tongDoanhThu[6]+=bienLai.getSoTienDaDong(); break;
                case "CTH007":  tongDoanhThu[7]+=bienLai.getSoTienDaDong(); break;
                case "CTH008":  tongDoanhThu[8]+=bienLai.getSoTienDaDong(); break;
                case "CTH009":  tongDoanhThu[9]+=bienLai.getSoTienDaDong(); break;
                case "CTH010": tongDoanhThu[10]+=bienLai.getSoTienDaDong(); break;
                case "CTH011": tongDoanhThu[11]+=bienLai.getSoTienDaDong(); break;
                case "CTH012": tongDoanhThu[12]+=bienLai.getSoTienDaDong(); break;
                case "CTH013": tongDoanhThu[13]+=bienLai.getSoTienDaDong(); break;
                case "CTH014": tongDoanhThu[14]+=bienLai.getSoTienDaDong(); break;
                case "CTH015": tongDoanhThu[15]+=bienLai.getSoTienDaDong(); break;
                case "CTH016": tongDoanhThu[16]+=bienLai.getSoTienDaDong(); break;
                case "CTH017": tongDoanhThu[17]+=bienLai.getSoTienDaDong(); break;
                
            }
        }

        
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Tong doanh thu: "+tongDoanhThu[0]);
        int min=tongDoanhThu[0];
        for(int i=1; i<tongDoanhThu.length;i++){
            if(min>tongDoanhThu[i])
                min=tongDoanhThu[i];
        }
        if(min==0) min=1;
        for(int i=1; i<tongDoanhThu.length;i++){
            tongDoanhThu[i]/=min;
        }
        for(int i=1; i<tongDoanhThu.length; i++){
            System.out.printf("%-10s","CTH"+i+"|"+tongDoanhThu[i]+"| ");
            for(int j=0; j<tongDoanhThu[i]; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------------------------------------------------------");

    }

}