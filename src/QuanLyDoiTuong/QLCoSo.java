package QuanLyDoiTuong;

import HeThongGiaoDuc.CoSoVatChat.CoSo;
import Utils.DocGhiFile;

import java.util.ArrayList;


public class QLCoSo {
    public static ArrayList<CoSo> dsCoSo = new ArrayList<>();

    public static ArrayList<CoSo> getDsCoSo() {
        return dsCoSo;
    }

    public static void setDsCoSo(ArrayList<CoSo> dsCoSo) {
        QLCoSo.dsCoSo = dsCoSo;
    }

    public static void inDSCoSo(ArrayList<CoSo> dsCoSo){
        System.out.println("*********************************************************");
        System.out.printf("* %-10s* %-20s* %-20s*\n","Ma co so","Ten co so","Dia chi");
        System.out.println("*********************************************************");

        for(CoSo coSo:dsCoSo){
            System.out.printf("* %-10s* %-20s* %-20s*\n",coSo.getMaCoSo(),coSo.getTenCoSo(),coSo.getDiaChi());
        }
        System.out.println("*********************************************************");

    }
    public static CoSo timCoSoTheoMa(String maCoSo){
        CoSo coSoTheoMa=new CoSo();
        for(CoSo coSo:dsCoSo){
            if(coSo.getMaCoSo().equals(maCoSo))
                coSoTheoMa=coSo;
        }
        return coSoTheoMa;
    }
    public static CoSo timCoSoTheoTen(String tenCoSo){
        CoSo coSoTheoTen=new CoSo();
        for(CoSo coSo:dsCoSo){
            if(coSo.getTenCoSo().equals(tenCoSo))
                coSoTheoTen=coSo;
        }
        return coSoTheoTen;
    }

    public static void loadDuLieu(){
        ArrayList<String> duLieu=DocGhiFile.docDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlCoSo.txt");
        xuLyDuLieu(duLieu);
    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String dong : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = dong.split("#");

            String maCoSo = cacThuocTinh[0];
            String tenCoSo = cacThuocTinh[1];
            String diaChi = cacThuocTinh[2];


            dsCoSo.add(new CoSo(maCoSo,tenCoSo,diaChi));
        }
    }

    public static void luuDuLieu() {
        ArrayList<String> duLieu = xuLyDuLieuDeLuu();
        DocGhiFile.ghiDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlCoSo.txt",duLieu);

    }
    public static ArrayList<String> xuLyDuLieuDeLuu() {
        // duyệt qua duLieu và bắt đầu xử lý!
        ArrayList<String> duLieu=new ArrayList<String>();
        for (CoSo coSo:dsCoSo) {
            StringBuilder sb = new StringBuilder();
            sb.append(coSo.getMaCoSo());sb.append("#");
            sb.append(coSo.getTenCoSo());sb.append("#");
            sb.append(coSo.getDiaChi());sb.append(System.lineSeparator());
            duLieu.add(sb.toString());
        }
        return duLieu;
    }
}
