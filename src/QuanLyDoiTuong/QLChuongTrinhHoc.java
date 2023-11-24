package QuanLyDoiTuong;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import Utils.DocGhiFile;
import Utils.ScannerUtils;
import java.util.ArrayList;

public class QLChuongTrinhHoc {
    private static ArrayList<ChuongTrinhHoc> dsChuongTrinhHoc = new ArrayList<>();

    public static ArrayList<ChuongTrinhHoc> getDsChuongTrinhHoc() {
        return dsChuongTrinhHoc;
    }

    public static void setDsChuongTrinhHoc(ArrayList<ChuongTrinhHoc> dsChuongTrinhHoc) {
        QLChuongTrinhHoc.dsChuongTrinhHoc = dsChuongTrinhHoc;
    }

    public static void inChuongTrinhHoc(ArrayList<ChuongTrinhHoc> dsChuongTrinhHoc){
        System.out.printf("*****************************************************************************************************************************\n");
        System.out.printf("* %-5s*   %-27s*   %-23s*   %-20s*   %-12s*   %-15s*\n", "Code", "Thể loại", "Trình độ", "Tên khóa học", "Thời lượng", "Học phí");
        System.out.printf("*****************************************************************************************************************************\n");
        for (ChuongTrinhHoc i: dsChuongTrinhHoc){
            System.out.printf("*  %-4s*   %-27s*   %-23s*   %-20s*   %-12d*   %-15d*\n", i.getMaChuongTrinh(), i.getTheLoai(), i.getTrinhDo(), i.getKhoaHoc(), i.getThoiLuong(), i.getHocPhi());
        }
        System.out.printf("*****************************************************************************************************************************\n");

    }

    public static ChuongTrinhHoc timKiemTheoMa(String ma) {
        ChuongTrinhHoc result = null;
        for (ChuongTrinhHoc i : QLChuongTrinhHoc.getDsChuongTrinhHoc()) {
            if (i.getMaChuongTrinh().equals(ma)){
                result = i;
            }
        }
        return result;
    }

    public static ArrayList<ChuongTrinhHoc> timKiemTheoTheLoai() {

        int choice;
        ArrayList<ChuongTrinhHoc> result = new ArrayList<>();
        String theLoai = null;
        do{
            System.out.println("Nhập thể loại bạn muốn chọn ?");
            System.out.println("1. Tiếng anh cho trẻ em");
            System.out.println("2. Tiếng anh cho người lớn");
            choice = ScannerUtils.inputInt();

            if (choice == 1){
                theLoai = "Tiếng Anh cho trẻ em";
            }
            else if (choice == 2){
                theLoai = "Tiếng Anh cho người lớn";
            }
            else{
                System.out.println("Bạn chỉ có thể chọn các lựa chọn được đề xuất !!");
            }
        }while (choice != 1 && choice != 2);


        for (ChuongTrinhHoc i : QLChuongTrinhHoc.getDsChuongTrinhHoc()) {
            if (i.getTheLoai().equals(theLoai)){
                result.add(i);
            }
        }
        return result;
    }

    public static void loadDuLieu(){
        ArrayList<String> duLieu=DocGhiFile.docDuLieuFile("src\\Data\\qlChuongTrinhHoc.txt");
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong CHƯƠNG TRÌNH HỌC");

    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String dong : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = dong.split("#");


            String maChuongTrinh = cacThuocTinh[0];
            String theLoai = cacThuocTinh[1];
            String trinhDo = cacThuocTinh[2];
            String khoaHoc = cacThuocTinh[3];
            int thoiLuong = Integer.parseInt(cacThuocTinh[4]);
            int hocPhi = Integer.parseInt(cacThuocTinh[5]);


            dsChuongTrinhHoc.add(new ChuongTrinhHoc(maChuongTrinh,theLoai,trinhDo,khoaHoc,thoiLuong,hocPhi));
        }
    }

    public static void luuDuLieu() {
        ArrayList<String> duLieu = xuLyDuLieuDeLuu();
        DocGhiFile.ghiDuLieuFile("src\\Data\\qlChuongTrinhHoc.txt",duLieu);
        System.out.println("Đã lưu xong CHƯƠNG TRÌNH HỌC");
    }
    public static ArrayList<String> xuLyDuLieuDeLuu() {
        // duyệt qua duLieu và bắt đầu xử lý!
        ArrayList<String> duLieu=new ArrayList<String>();
        for (ChuongTrinhHoc chuongTrinhHoc: dsChuongTrinhHoc) {
            StringBuilder sb = new StringBuilder();
            sb.append(chuongTrinhHoc.getMaChuongTrinh());sb.append("#");
            sb.append(chuongTrinhHoc.getTheLoai());sb.append("#");
            sb.append(chuongTrinhHoc.getTrinhDo());sb.append("#");
            sb.append(chuongTrinhHoc.getKhoaHoc());sb.append("#");
            sb.append(chuongTrinhHoc.getThoiLuong());sb.append("#");
            sb.append(chuongTrinhHoc.getHocPhi());sb.append(System.lineSeparator());
            duLieu.add(sb.toString());
        }
        return duLieu;
    }

//    public static void main(String[] args) {
//        loadDuLieu();
//        inChuongTrinhHoc(dsChuongTrinhHoc);
//        luuDuLieu();
//    }



}