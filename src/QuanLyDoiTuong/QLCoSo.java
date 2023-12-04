package QuanLyDoiTuong;

import HeThongGiaoDuc.CoSoVatChat.CoSo;
import Utils.DocGhiFile;

import java.util.ArrayList;


public class QLCoSo {
    private static ArrayList<CoSo> dsCoSo = new ArrayList<>();

    public static ArrayList<CoSo> getDsCoSo() {
        return dsCoSo;
    }

    public static void setDsCoSo(ArrayList<CoSo> dsCoSo) {
        QLCoSo.dsCoSo = dsCoSo;
    }

    public static void inDSCoSo(ArrayList<CoSo> dsCoSo){
        System.out.println("*".repeat(117));
        System.out.printf("* %-10s* %-20s* %-80s*\n","Mã cơ sở","Tên cơ sở","Địa chỉ");
        System.out.println("*".repeat(117));

        for(CoSo coSo:dsCoSo){
            System.out.printf("* %-10s* %-20s* %-80s*\n",coSo.getMaCoSo(),coSo.getTenCoSo(),coSo.getDiaChi());
        }
        System.out.println("*".repeat(117));

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
        ArrayList<String> duLieu=DocGhiFile.docDuLieuFile("src\\Data\\qlCoSo.txt");
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong CƠ SỞ");

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
        DocGhiFile.ghiDuLieuFile("src\\Data\\qlCoSo.txt",duLieu);
        System.out.println("Đã lưu xong CƠ SỞ");

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
