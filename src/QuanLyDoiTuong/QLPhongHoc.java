package QuanLyDoiTuong;

import java.util.ArrayList;

import HeThongGiaoDuc.CoSoVatChat.CoSo;
import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import Utils.DocGhiFile;

public class QLPhongHoc {
    private  static ArrayList<PhongHoc> dsPhongHoc =  new ArrayList<>();

    public static ArrayList<PhongHoc> getDsPhongHoc() {
        return dsPhongHoc;
    }

    public static void setDsPhongHoc(ArrayList<PhongHoc> dsPhongHoc) {
        QLPhongHoc.dsPhongHoc = dsPhongHoc;
    }

    public static void inDSPhongHoc(ArrayList<PhongHoc> dsPhongHoc){
        System.out.println("*************************************");
        System.out.printf("* %-10s* %-10s* %-10b*\n","Mã phòng","Cơ sở","Trạng thái");
        System.out.println("*************************************");

        for(PhongHoc phong:dsPhongHoc){
            if(!phong.getTrangThai()){
                System.out.printf("* %-10s* %-10s* %-10s*\n",phong.getMaPhongHoc(),phong.getCoSoTrucThuoc().getMaCoSo(),"Đang học");
            }
            else{
                System.out.printf("* %-10s* %-10s* %-10s*\n",phong.getMaPhongHoc(),phong.getCoSoTrucThuoc().getMaCoSo(),"Trống");
            }
        }
        System.out.println("*************************************");

    }
    public static ArrayList<PhongHoc> timKiemTheoMaCoSo(String maCoSo){
        ArrayList<PhongHoc> dsPhongHocTheoCoSo=new ArrayList<PhongHoc>();
        for(PhongHoc phong:dsPhongHoc){
            if(phong.getCoSoTrucThuoc().getMaCoSo().equals(maCoSo)){
                dsPhongHocTheoCoSo.add(phong);
            }
        }
        return dsPhongHocTheoCoSo;
    }



    public static PhongHoc timKiemTheoMaPhongHoc(String maPhongHoc){
        PhongHoc phongHoc = null;
        for(PhongHoc phong:dsPhongHoc){
            if(phong.getMaPhongHoc().equals(maPhongHoc)){
                phongHoc = phong;
            }
        }
        return phongHoc;
    }

    public static ArrayList<PhongHoc> timKiemTheoTrangThai(boolean trangThai){
        ArrayList<PhongHoc> dsPhongHocTheoTrangThai=new ArrayList<PhongHoc>();
        for(PhongHoc phong:dsPhongHoc){
            if(phong.getTrangThai()==trangThai){
               dsPhongHocTheoTrangThai.add(phong);
            }
        }
        return dsPhongHocTheoTrangThai;
    }

    public static void loadDuLieu(){
        ArrayList<String> duLieu=DocGhiFile.docDuLieuFile("src\\Data\\qlPhongHoc.txt");
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong PHÒNG HỌC");

    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String dong : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = dong.split("#");


            String maPhong = cacThuocTinh[0];
            boolean trangThai = Boolean.parseBoolean(cacThuocTinh[1]);
            String maCoSo = cacThuocTinh[2];

            CoSo coSoTrucThuoc = QLCoSo.timCoSoTheoMa(maCoSo);

            dsPhongHoc.add(new PhongHoc(maPhong,trangThai,coSoTrucThuoc));

        }
    }

    public static void luuDuLieu() {
        ArrayList<String> duLieu = xuLyDuLieuDeLuu();
        if(DocGhiFile.ghiDuLieuFile("src\\Data\\qlPhongHoc.txt", duLieu)){
            System.out.println("Đã lưu xong PHÒNG HỌC");

        }
    }
    public static ArrayList<String> xuLyDuLieuDeLuu() {
        // duyệt qua duLieu và bắt đầu xử lý!
        ArrayList<String> duLieu=new ArrayList<String>();
        for (PhongHoc phongHoc:dsPhongHoc) {
            StringBuilder sb = new StringBuilder();
            sb.append(phongHoc.getMaPhongHoc());sb.append("#");
            sb.append(phongHoc.getTrangThai());sb.append("#");
            sb.append(phongHoc.getCoSoTrucThuoc().getMaCoSo());sb.append(System.lineSeparator());
            duLieu.add(sb.toString());
        }
        return duLieu;
    }

}
